#ifndef HELPER_H
#define HELPER_H

#include "server.h"
#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <iostream>
#include <string>
#include <stack>
#include <sys/stat.h>
#include <pthread.h>
#include <ctype.h>
#include <fcntl.h>
#include <stdexcept>
#include <sys/types.h>
#include <unistd.h>


using namespace std;

class Server;

class Helper
{
    private:
        Server * server;
        
        pthread_t _thread;

        static void * StartThreadFunction(void * helper)
        {
            return ((Helper *)helper)->help(helper);
        }
        
    protected:

        void * help(void * Helper);

    public:

        Helper(Server * s);

        bool StartThread();
        bool JoinThread();
};

#endif