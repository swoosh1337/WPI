


CFLAGS = -Wall -g


all: life

life: life.o twoD.o screen.o
	gcc $(CFLAGS) life.o twoD.o screen.o -o life


life.o: life.c twoD.h
	gcc $(CFLAGS) -c life.c

twoD.o: twoD.c twoD.h
	gcc $(CFLAGS) -c twoD.c

screen.o: screen.c
	gcc $(CFLAGS) -Wall -c screen.c

clean:
	rm -f *.o life
	rm -f -r html latex


docs:
	make docs 
