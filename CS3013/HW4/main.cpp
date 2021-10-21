#include "server.h"
#include <iostream>
#include <string.h>

using namespace std;

int main(int argc, char ** argv)
{
    int threads = 1;

    if (argc == 3 && strncmp(argv[1], "thread", 6) == 0)
    {
        threads = atoi(argv[2]);
    }
    Server server(threads);

    string input;

    while (getline(cin,input)) {
      
        server.add(input);
    }
    server.run();
}