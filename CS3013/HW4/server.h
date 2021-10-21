#ifndef SERVER_H
#define SERVER_H

#include "helper.h"

#include <stdio.h>
#include <semaphore.h>
#include <iostream>
#include <stdexcept>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/time.h>
#include <string>
#include <stack>
#include <sys/resource.h>
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>
#include <ctype.h>
#include <fcntl.h>
#include <vector>

using namespace std;

class helper;

class Server
{
    private:
        sem_t sem_count;
        sem_t sem_file;
        stack<string> ListofFiles;

        int nThreads;
        struct timeval start;
    public:
        Server(int threads);
        ~Server();

        void add(string filename);
        void lock(unsigned long * val, unsigned long addition);
        void run();

        string getNextFile();
        
        unsigned long nBadFiles;
        unsigned long nDirectories;
        unsigned long nSpecialFiles;
        unsigned long nRegularFiles;
        unsigned long bRegularFiles;
        unsigned long nTextFiles;
        unsigned long bTextFiles;
};

#endif