 /*  Irakli Grigolia(igrigolia) homework 1
 *
 *
 * This project implements a command shell that accepts commands from a user.
 * Also it gives you statistics for the process after completion.
 * The project can be compiled with the 'make all' command; after that we need to execute the
 * file 'doit'. The 'doit' program takes another command as an agrument and executes that command. For example:
 * 
 * % ./doit wc foo.txt
 *
 * will execute the 'wc'  command with an argument of 'foo.txt'. After the execution is completed, statistics will be displayed 
 *
 * The shell includes several built-in commands:
 * 	exit - causes the shell to terminate
 * 	cd dir - causes the shell to change the directory to dir
 * 	set prompt = newprompt - causes the shell to change the prompt to newprompt
 *
 * This shell  also supports running tasks in the background  by adding '&', to the argument list. The 'jobs' command
 * will display a list of  running background tasks. If we try to exit the shell with the 'exit' command while there are still background tasks running, the
 * shell will wait for the background tasks to complete before exiting.
 *
 * This simple shell is  good, but still lacks many of the features which are common in
 * regular Linux shells. For example: There is no auto-completion using 'tab'.  Normal shells also have 
 * pipe  and directing output to files options, which we can not do with our shell.
 * Also it  doesn't store previously used commands and  doesn't have many other features.
 *
 *
*/




using namespace std;

#include <iostream>
#include <sstream>
#include <stdio.h>
#include <stdlib.h>
#include <map>
#include <vector>
#include <sys/types.h>
#include <sys/time.h>
#include <signal.h>
#include <string.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/resource.h>

#define MAX_CHARS 128 // maximum size of command line arguments
#define MAX_ARGS 32  // minimum suze of command line arguments 




// necessary functions
void shell();
void print();
void statistics(double startin, int pid);
int command(char *args[]);
double convert(struct timeval time);
void processEnd(int num);

struct rusage total;
//Structure to hold info on running processes
struct process {
	int pid;
	string title;
	double startTime;
	int num;
};
map <int, process> running;  // using map to save running processes


void shell(){
	bool exit = false;
	string prompt = "==>";
	while (!exit) {

		vector<string> args;
		cout << prompt;
		string line;
		cin.clear();

		getline(cin, line);
		istringstream input (line);
		string word;
		vector<string> list;
		while(input >> word){
			list.push_back(word);
		}

		if (list.size() == 1 && list[0] == "exit"){
			exit = true;
			//Check if background processes are running
			if( running.size() == 0)
				break;
			else{
				cout << "There are processes running, please wait before exiting"<<endl;
				cout << "Running jobs:" << endl;
				print();			
				wait(NULL);
			}
		}else
 
		if (list.size() == 4 && 
			list[0] == "set" && 
			list[1] == "prompt" && 
			list[2] == "=" )
		{
			prompt = list[3];
		}else
		if (list.size() < 1){
			
		}else 
		if(list[0] == "cd"){
	
			if (chdir(list[1].c_str()) < 0){
					cerr << "No directory to change to!\n";
			}
		}
		else 
		if(list[0] == "jobs"){

			print();
		}
		else {
			
			char *newargs[list.size() + 1];
			for(int i = 0; i < (int)list.size(); i++){
				newargs[i] = (char *)list[i].c_str();
			} 
			newargs[list.size()] = 0;

			
			bool back = false;
			if(newargs[list.size() -1][0] ==  '&'){
				newargs[list.size() -1 ] = 0;
				back = true;
			}
			int pid = command(newargs);
			if(back){
		
				struct timeval astart;
				gettimeofday(&astart, NULL);
				process p = {pid, newargs[0], convert(astart), int(running.size())+1};
				running[pid] = p;
				cout << "[" << running.size() << "] " << pid << "\n";
			}else{
				
				statistics(-1, pid);
			}
		}
		list.clear();

	}
}

// prints  ongoing jobs
void print(){
	typedef map<int, process>::iterator it_type;
	for (it_type it = running.begin(); it != running.end(); it++){
		process info = it->second;
		cout << "[" << info.num << "] " << info.pid << " " << info.title << "\n";
	}
}

// prints statistics
void statistics(double startin, int pid = -1){
	struct rusage usage;
	struct timeval start, end;
	if( startin < 0){
		gettimeofday(&start, NULL);
		startin = convert(start);
		int status;
		waitpid(pid, &status, 0 );	
	}
	gettimeofday(&end, NULL);
	if(getrusage(RUSAGE_CHILDREN, &usage) != 0){
        	cerr << "Error getting usage\n";
        }
	double utime = convert(usage.ru_utime) - convert(total.ru_utime);
	double stime = convert(usage.ru_stime) - convert(total.ru_stime);
	double wtime = convert(end) - startin;

	// printing stats
	cout << "\n--Statistics--\n";
        cout << "User Time: " << utime  << "ms\n";
	cout << "System Time : " << stime << "ms\n";
	cout << "Wall clock time : " << wtime << "ms\n";
	cout << "Involuntarily preempted " << usage.ru_nivcsw - total.ru_nivcsw << " times\n";
	cout << "Voluntarily preempted " << usage.ru_nvcsw - total.ru_nvcsw << " times\n";
	cout << "Major Page faults : " << usage.ru_majflt  - total.ru_majflt << "\n";
	cout << "Minor Page faults satisfied by memory reclaim: " << usage.ru_minflt - total.ru_minflt << "\n";
	
	//Set total of all completed tasks
	total = usage;
}
// command execution
int command(char *args[]){
	int pid;
	if ((pid = fork()) < 0){	//error
		cerr << "Error forking process\n";
		exit(1);
	}
	else if (pid == 0){	//is child process
		execvp(args[0], args);
		cerr << "Error with execvp\n";
		exit(1);
	}
	else{	//is parent process
		return pid;	
	}	
}


double convert(struct timeval time){
	return time.tv_sec * 1000 + (time.tv_usec/1000.0);
}

void processEnd(int num){
	int pid, status;
	pid = waitpid(-1, &status, WNOHANG);
	if (!(running.find(pid) == running.end())){
		process info = running[pid];
		running.erase(pid);
		cout << "[" << info.num << "] " << pid << " completed\n";
		statistics(info.startTime, pid);
	}
}







int main (int argc, char *argv[]){
	getrusage(RUSAGE_CHILDREN, &total);
	struct sigaction sigchld_action; 
  	memset (&sigchld_action, 0, sizeof (sigchld_action)); 
  	sigchld_action.sa_handler = &processEnd; 
  	sigaction (SIGCHLD, &sigchld_action, NULL);

	if (argc > 1){
		char *newargs[argc];
		for (int i = 1; i < argc; i++){
			newargs[i-1] = argv[i];
		}
		newargs[argc -1] = 0;
		command(newargs);
		statistics(-1, 0);
	}else{
		shell();
	}
	exit(0);
}
