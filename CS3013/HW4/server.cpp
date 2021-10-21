#include "server.h"

Server::Server(int threads):
    nBadFiles(0),
    nDirectories(0),
    nSpecialFiles(0),
    nRegularFiles(0),
    bRegularFiles(0),
    nTextFiles(0),
    bTextFiles(0)
{
    nThreads = threads;

    gettimeofday(&start, NULL);
    sem_init(&sem_count, 0, 1);
    sem_init(&sem_file, 0, 1);
}

void Server::lock(unsigned long * val, unsigned long addition)
{
    sem_wait(&sem_count);
    *val += addition;
    sem_post(&sem_count);
}

Server::~Server()
{
    sem_destroy(&sem_count);
    sem_destroy(&sem_file);
}


void Server::add(string filename)
{
    ListofFiles.push(filename);
}


string Server::getNextFile()
{
    sem_wait(&sem_file);
    if (ListofFiles.empty())
    {
        sem_post(&sem_file);
        throw runtime_error("No files left.");
    }
    string file = ListofFiles.top();
    ListofFiles.pop();
    sem_post(&sem_file);
    return file;
}


void Server::run()
{
    if (nThreads == 1)
    {
        string next;
        struct stat fileinfo;
        for (;;)
        {
            try
            {
                next = this->getNextFile();
            }
            catch (runtime_error & e)
            {
                break;
            }
            int ret = stat(next.c_str(), &fileinfo);
            if (ret < 0) 
            {
                nBadFiles++;
            }
            else if (S_ISREG(fileinfo.st_mode)) 
            {
                nRegularFiles++;
                bRegularFiles += fileinfo.st_size;
                int infile;
                infile = open(next.c_str(), O_RDONLY);
                if (infile)
                {
                    unsigned char buf;
                    int cnt = read(infile, &buf, sizeof(unsigned char));
                    int isprintable = 1;
                    do
                    {
                        if (!isprint(buf) && !isspace(buf))
                        {
                            isprintable = 0;
                            break;
                        }
                        cnt = read(infile, &buf, sizeof(unsigned char));
                    }
                    while (cnt == 1);
                    close(infile);
                    if (isprintable)
                    {
                        bTextFiles += fileinfo.st_size;
                        nTextFiles++;
                    }
                }
            }
            else if (S_ISDIR(fileinfo.st_mode)) 
            {
                nDirectories++;
            }
            else 
            {
                nSpecialFiles++;
            }
        }
    } else
    {   vector<Helper> helpers;
        nThreads = (nThreads > 15) ? 15 : nThreads;
        for (int i = 0; i < nThreads; i++)
        {
            Helper c(this);
            helpers.push_back(c);
        }
        for (int i = 0; (unsigned long)i < helpers.size(); i++)
        {
            helpers.at(i).StartThread();
        }
        for (int i = 0; (unsigned long)i < helpers.size(); i++)
        {
            helpers.at(i).JoinThread();
        }
    }
    cout << "Bad files: " << nBadFiles << endl;
    cout << "Directories: " << nDirectories << endl;
    cout << "Regular Files: " << nRegularFiles << endl;
    cout << "Special Files: " << nSpecialFiles << endl;
    cout << "Regular File Bytes: " << bRegularFiles << endl;
    cout << "Text Files: " << nTextFiles << endl;
    cout << "Text File Bytes: " << bTextFiles  << endl;

    struct rusage stats;
    getrusage(RUSAGE_SELF, &stats);

    cout << "User Time: " << stats.ru_utime.tv_sec * 1000 + stats.ru_utime.tv_usec / 1000 << endl;
    cout << "System Time: " << stats.ru_stime.tv_sec * 1000 + stats.ru_stime.tv_usec / 1000 << endl;

    struct timeval end;
    gettimeofday(&end, NULL);

    cout << "Clock Time: " << (end.tv_sec * 1000 + end.tv_usec / 1000) - (start.tv_sec * 1000 + start.tv_usec / 1000) << endl;
}