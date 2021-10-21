;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname konstantopoulos_grigolia_hw1) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define-struct date (year month day))
;; a Date is (make-date Natural Natural Natural)
;; interpratation: represents a date where
;; year is a year
;; month is a numerical month [1,12]
;; day is a numerical day [1,31]

(define date1 (make-date 2016 12 23))
(define date2 (make-date 2017 08 23))
(define date3 (make-date 2012 02 23))
(define date4 (make-date 2015 05 23))
(define date5 (make-date 2011 09 23))

(define-struct film (title genre time date receipt))
;; a Film is (make-film String String Natural Date Natural)
;; interpration: represents a film where
;; title is the Film's title
;; genre is the Film's genre
;; time is the running time of the Film (minutes)
;; date is the date the Film opened at the theater
;; receipt is the total box office receipts collected (millions)

(define Film1 (make-film "Star Wars" "Comedy"  105 date1  500000000))
(define Film2 (make-film "Death Note" "Fantasy" 200 date2  142000000))
(define Film3 (make-film "21 jump street" "Comedy" 90 date3 142000000))

(check-expect (short-comedy? Film1 100) false)
(check-expect (short-comedy? Film1 105) false)
(check-expect (short-comedy? Film1 106) true)
(check-expect (short-comedy? Film2 150) false)
(check-expect (short-comedy? Film2 200) false)
(check-expect (short-comedy? Film2 250) false)
(check-expect (short-comedy? Film3 80) false)
(check-expect (short-comedy? Film3 90) false)
(check-expect (short-comedy? Film3 100) true)
(check-expect (short-comedy? (make-film "Game of Thrones" "Adventure" 60 (make-date 2017 07 10) 200000000) 80) false)

;; short-comedy? : Film Natural -> Boolean
;; consumes a Film and the number of minutes
;; produces true if the number of minutes are less
;; then the Film's running time

(define (short-comedy? movie minutes)
  (if (and (string=? (film-genre movie) "Comedy") (< (film-time movie) minutes))
       true
       false))

;; film-with-more-receipts : Film Film -> Film
;; Consumes 2 Films and produces
;; one with the higher number of box-office receipts

(check-expect (film-with-more-receipts Film1 Film2) Film1)
(check-expect (film-with-more-receipts Film2 Film3) Film3)
(check-expect (film-with-more-receipts Film1 Film3) Film1)

(define (film-with-more-receipts movie1 movie2)
  (if (> (film-receipt movie1) (film-receipt movie2))
      movie1
      movie2
      ))

;; add-time-for-trailers : Film Natural -> Film
;; Consumes a Film and number of trailers
;; and produces a Film with increased running time (+ 3 minutes per trailer)

(check-expect (add-time-for-trailers Film1 3) (make-film "Star Wars" "Comedy" 114 date1  500000000))

(define (add-time-for-trailers movie trail-num)
 (make-film (film-title movie) (film-genre movie)  (+ (film-time movie) (* 3 trail-num)) (film-date movie) (film-receipt movie)))

;; opens-before? : Film Date -> Boolean
;; Consumes film and  date and produces
;; true if the given film opens before the given date

(check-expect (opens-before? Film1 date5) false)
(check-expect (opens-before? Film1 (make-date 2016 12 22)) false)
(check-expect (opens-before? Film1 (make-date 2016 12 24)) true)
(check-expect (opens-before? Film2  date1) false)
(check-expect (opens-before? Film2 (make-date 2017 08 22)) false)
(check-expect (opens-before? Film2 (make-date 2017 08 24)) true)
(check-expect (opens-before? Film3 date4) true)
(check-expect (opens-before? Film3 (make-date 2012 02 22)) false)
(check-expect (opens-before? Film3 (make-date 2012 02 24)) true)
               
(define (opens-before? movie date)
    (cond [(and (<= (date-year (film-date movie)) (date-year date)) 
              (<= (date-month (film-date movie))  (date-month date)) 
              (<= (date-day  (film-date movie)) (date-day date ))) true]
                       [else false]))

