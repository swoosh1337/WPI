all: main

main: server.o helper.o main.o
	g++ main.o server.o helper.o -lpthread -o proj4
	rm *.o

main.o: main.cpp server.h
	g++ -std=c++0x -c main.cpp

server.o: server.h helper.h
	g++ -std=c++0x -c server.cpp

helper.o: helper.h server.h
	g++ -std=c++0x -c helper.cpp

clean:
	rm proj4