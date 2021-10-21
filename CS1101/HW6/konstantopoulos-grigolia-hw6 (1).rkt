;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname konstantopoulos-grigolia-hw6) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f () #f)))
;; Homework assignment 6

;; Theodoros Konstantopoulos (tkonstantopoulos)
;; Irakli Grigorlia (igrigolia)


;;
;; Part 1
;;

;; a TimeOfDay is one of
;;   "daytime"
;;   "primetime"
;;   "off-hour"

(define-struct ad (name duration production-cost national? time-of-day repetitions))
;; an Ad is a (make-ad String Natural Number Boolean TimeOfDay Natural)
;; interp:  a television ad, where
;;          name is the name of the product the ad is for
;;          duration is the length of the ad (in seconds)
;;          production-cost is the cost to produce the ad (in thousands of dollars)
;;          national? is true if the ad is to be aired nationally (false if locally)
;;          time-of-day is the time of day that the ad airs
;;          repetitions is the number of times the ad is to be played

;; a ListOfAd is one of
;;   empty
;;   (cons Ad ListOfAd)

(define AD1 (make-ad "Apple" 20 1000 true "daytime" 10))
(define AD2 (make-ad "Microsoft" 30 1200 true "primetime" 12))
(define AD-GROUP1 (cons AD1 (cons AD2 empty)))
(define AD-GROUP2 (cons
                   (make-ad "Google" 10 500 false "daytime" 5)
                   (cons
                    (make-ad "Oracle" 5 800 true "off-hour" 3) empty)))
(define AD-GROUP3 (cons
                   (make-ad "Toyota" 15 750 false "off-hour" 8)
                   (cons (make-ad "YouTube" 8 400 true "daytime" 5) empty)))

;;
;; Problem 1
;;

;; count-long-primetime: ListOfAd Natural -> Natural
;; consumes a list of ads and an amount of time
;; and produces the number of primetime ads in the list
;; that run longer than the given number of seconds

(check-expect (count-long-primetime empty 0) 0)
(check-expect (count-long-primetime AD-GROUP1 5) 1)
(check-expect (count-long-primetime AD-GROUP2 3) 0)
(check-expect (count-long-primetime AD-GROUP1 20) 1)
(check-expect (count-long-primetime AD-GROUP2 5) 0)
(check-expect (count-long-primetime AD-GROUP1 30) 0)
(check-expect (count-long-primetime AD-GROUP2 10) 0)
(check-expect (count-long-primetime (cons
                                     (make-ad "Unilever" 10 2000 true "off-hour" 20) empty)
                                    10)
                                     0)

(define (count-long-primetime loa seconds)
  (local [(define (count-ad? ad0)
            (and (string=? (ad-time-of-day ad0) "primetime")
                     (> (ad-duration ad0) seconds)))]
    (length (filter count-ad? loa))))

;;
;; Problem 2
;;

;; national-ads: ListOfAd -> ListOfAd
;; Consumes a ListOfAd and produces a list containing only
;; the ads airing nationally
(check-expect (national-ads empty) empty)
(check-expect (national-ads AD-GROUP1) (cons
                                        (make-ad "Apple" 20 1000 true "daytime" 10)
                                        (cons
                                         (make-ad "Microsoft" 30 1200 true "primetime" 12) empty)))
(check-expect (national-ads (cons AD1 empty)) (cons
                                               (make-ad "Apple" 20 1000 true "daytime" 10) empty))
(check-expect (national-ads (cons
                             (make-ad "Coca Cola" 15 1500 false "daytime" 8) empty)) empty)
(check-expect (national-ads AD-GROUP3) (cons
                                        (make-ad "YouTube" 8 400 true "daytime" 5) empty))

(define (national-ads loa)
  (local [(define (national? ad)
            (ad-national? ad))]
    (filter national? loa)))

;;
;; Problem 3
;;

;; late-night-products: ListOfAd -> ListOfString
;; Consumes a list of ads and produces
;; a list of strings that contains
;; the name of the products that are advertised
;; during the off-hours
(check-expect (late-night-products empty) empty)
(check-expect (late-night-products AD-GROUP1) empty)
(check-expect (late-night-products AD-GROUP2) (cons "Oracle" empty))
(check-expect (late-night-products AD-GROUP3) (cons "Toyota" empty))
(check-expect (late-night-products (cons AD1
                                    (cons AD2
                                      (cons
                                       (make-ad "Youtube" 8 400 true "daytime" 5) empty))))
                                   empty)
(check-expect (late-night-products
               (cons AD1
                     (cons AD2
                           (cons
                            (make-ad "YouTube" 8 400 true "daytime" 5)
                                         (cons
                                          (make-ad "Oracle" 5 800 true "off-hour" 3) empty)))))
              (cons "Oracle" empty))

(define (late-night-products loa)
  (local [(define (late-night? ad)
            (string=? (ad-time-of-day ad) "off-hour"))]
    (map ad-name (filter late-night? loa))))

;;
;; Problem 4
;;

;; adjust-for-inflation: ListOfAd -> ListOfAd
;; consumes a list of ads and produces a list where
;; the production cost for each ad in the list has increased
;; by 1%

(check-expect (adjust-for-inflation empty) empty)
(check-expect (adjust-for-inflation AD-GROUP1)
              (cons
               (make-ad "Apple" 20 1010 true "daytime" 10)
               (cons
                (make-ad "Microsoft" 30 1212 true "primetime" 12) empty)))
(check-expect (adjust-for-inflation AD-GROUP2)
              (cons
                   (make-ad "Google" 10 505 false "daytime" 5)
                   (cons
                    (make-ad "Oracle" 5 808 true "off-hour" 3) empty)))

(define (adjust-for-inflation loa)
  (local [(define (adjust-ad ad)
            (make-ad (ad-name ad)
                     (ad-duration ad)
                     (+ (ad-production-cost ad)
                        (* 0.01 (ad-production-cost ad)))
                     (ad-national? ad)
                     (ad-time-of-day ad)
                     (ad-repetitions ad)))]
    (map adjust-ad loa)))

;;
;; Part 2
;;

(define-struct user (name messages))
;; a User is a (make-user String ListOfMessage)
;; interp: a User where
;;   name is the user's username
;;   messages is a list containing all of the user's messages

(define-struct message (sender text read?))
;; a Message is a (make-message User String Boolean)
;; interp: a Message where
;;   sender is the user that sent the message
;;   text is the message's contents
;;   read? is whether the message has been read or not

;; a ListOfMessage is one of
;;   empty
;;   (cons Message ListOfMessage)

;; a ListOfUser is one of
;;   empty
;;   (cons User ListOfUser)

;; a MailSys is one of
;;   empty
;;   ListOfUser

;;
;; Problem 5
;;

(define mailsys empty)

;;
;; Problem 6
;;

;; add-user: String -> void
;; consumes a username and adds
;; a user with the given username to mailsys
;; EFFECT: modifies mailsys

(define (add-user username)
  (set! mailsys (append
                   (list (make-user username empty))
                   mailsys)))

;;
;; Problem 7
;;

;; send-email: String String String -> void
;; consumes the name of the sender, the name of
;; the recipient and the message's text and stores
;; the new message in the recipient's mailbox as unread
;; EFFECT: modifies mailsys

(define (send-email sender recipient email-text)
  (set! mailsys (send-email-list sender recipient email-text mailsys)))

;; send-email-list: String String String ListOfUser -> ListOfUser
;; consumes a sender, a recipient, a message and a list of users
;; and produces the same list with a new message stored in
;; the recipient mailbox

(check-expect (send-email-list "George" "Nick" "Test" empty) empty)
(check-expect (send-email-list "John" "George" "Test"
                               (list
                                (make-user "George" empty)
                                (make-user "John" empty)))
              (list
               (make-user "George" (list
                                    (make-message "John" "Test" false)))
               (make-user "John" empty)))

(define (send-email-list sender-username receiver-username contents lou)
  (cond [(empty? lou) empty]
        [(cons? lou) (if (string=? (user-name (first lou))
                                   receiver-username)
                         (cons (make-user (user-name (first lou))
                                    (append (user-messages (first lou))
                                            (list
                                             (make-message sender-username
                                                       contents
                                                       false))))
                               (rest lou))
                         (send-email-list
                          sender-username
                          receiver-username
                          contents (rest lou)))]))



;;
;; Problem 8
;;

;; get-unread-messages-and-mark-read: String -> ListOfMessage
;; consumes a username and produces a list of messages that
;; contains the (previously) unread messages in the mailbox
;; of the user with the given name
;; all of the user's messages are set to read
;; assumes that the username given is a valid user
;; in the mail system
;; EFFECT: modifies mailsys
(define (get-unread-messages-and-mark-read username)
  (set! mailsys (mark-read-list username mailsys)))

;; mark-read-list: String ListOfUser -> ListOfUser
;; consumes a user and a list of users and
;; produces a list of users with the messages in
;; the given user's mailbox being marked as read
(check-expect (mark-read-list "Bob"
                              (list
                               (make-user "George" empty)
                               (make-user "John"
                                          (list
                                           (make-message "George" "Test" false)))
                               (make-user "Bob" (list
                                                 (make-message "George" "Hello World" false)))))
              (list
               (make-user "George" empty)
               (make-user "John" (list
                                  (make-message "George" "Test" false)))
               (make-user "Bob" (list
                                 (make-message "George" "Hello World" true)))))

(define (mark-read-list username lou)
  (cond [(empty? lou) empty]
        [(cons? lou) (cons (make-user (user-name (first lou))
                                      (if (string=? (user-name (first lou))
                                                    username)
                                          (process-unread-messages-list
                                           (user-messages (first lou)))
                                          (user-messages (first lou))))
                           (mark-read-list username (rest lou)))]))

;; process-unread-messages-list: ListOfMessage -> ListOfMessage
;; consumes a list of messages and produces the same list
;; with the messages marked as read
(check-expect (process-unread-messages-list empty) empty)
(check-expect (process-unread-messages-list
               (list
                (make-message "George" "Hello World" false)
                (make-message "George" "Test" true)))
              (list
               (make-message "George" "Hello World" true)
               (make-message "George" "Test" true)))

(define (process-unread-messages-list lom)
  (cond [(empty? lom) empty]
        [(cons? lom)
         (cons (make-message (message-sender (first lom))
                             (message-text (first lom))
                             true)
               (process-unread-messages-list (rest lom)))]))

;;
;; Problem 9
;;

;; most-messages: -> User
;; produces the user in the mailsystem with the largest number of messages
;; in his/her mailbox
;; if there aren't any users in the mailsystem it returns an error

(define (most-messages)
  (local [(define (most-messages a-mailsystem acc)
            (cond [(empty? a-mailsystem) acc]
                  [(cons? a-mailsystem) (if (> (length (user-messages (first a-mailsystem)))
                                               (length (user-messages acc)))
                                            (most-messages (rest a-mailsystem)
                                                           (first a-mailsystem))
                                            (most-messages (rest a-mailsystem) acc))]))]
    (if (empty? mailsys)
        (error "there aren't any users in the mail system")
        (most-messages mailsys (first mailsys)))))
                                            

;;
;; Problem 10
;;

"show mailsys"
mailsys
"add user with username 'George'"
(add-user "George")
"show that mailsys now has 1 user, user 'George'"
mailsys

"show mailsys"
mailsys
"add user with username 'Nick'"
(add-user "George")
"show that mailsys now has a new user, user 'Nick'"
mailsys
"add another user, user 'John'"
(add-user "John")
"show that mailsys now has 3 users"
mailsys

"send an email from 'Nick' to 'John' with a message 'Hello World'"
(send-email "Nick" "John" "Hello World")
"show that mailsys has been updated"
mailsys

"show mailsys"
mailsys
"mark John's messages as read"
(get-unread-messages-and-mark-read "John")
"show that John's messages have been marked as read and everything else remains unchanged"
mailsys

"check the most-messages function"
"currently, nick has more messages than everyone else"
(most-messages)
"send 2 test emails to George and run most-messages again"
(send-email "John" "George" "Test Message 1")
(send-email "Nick" "George" "Test Message 2")
"now George should have more messages than everyone else"
(most-messages)
"show mailsys to make sure it was updated"
mailsys
