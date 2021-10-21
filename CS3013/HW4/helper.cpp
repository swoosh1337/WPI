#include "helper.h"

Helper::Helper(Server * s)
{
    server = s;
}

bool Helper::StartThread()
{
    return (pthread_create(&_thread, NULL, &this->StartThreadFunction, this) == 0);
}

bool Helper::JoinThread()
{
    return (pthread_join(_thread, NULL) == 0);
}

void * Helper::help(void * helper)
{
    Server * s = ((Helper *)helper)->server;

    string next;
    struct stat fileinfo;
    for (;;)
    {
        try
        {
            next = s->getNextFile();
        }
        catch (runtime_error & e)
        {
            break;
        }
        int ret = stat(next.c_str(), &fileinfo);
        if (ret < 0) 
        {
            s->lock(&s->nBadFiles, 1);
        }
        else if (S_ISREG(fileinfo.st_mode)) 
        {
            s->lock(&s->nRegularFiles, 1);
            s->lock(&s->bRegularFiles, fileinfo.st_size);
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
                    s->lock(&s->bTextFiles, fileinfo.st_size);
                    s->lock(&s->nTextFiles, 1);
                }
            }
        }
        else if (S_ISDIR(fileinfo.st_mode)) 
        {
            s->lock(&s->nDirectories, 1);
        }
        else 
        {
            s->lock(&s->nSpecialFiles, 1);
        }
    }
    return NULL;
}