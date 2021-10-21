// Irakli Grigolia

#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <pthread.h>
#include <semaphore.h>
#include <time.h>

// maximum number of threads that can be created
#define MAXTHREAD 10
#define REQUEST 1
#define REPLY 2

// msg struct
struct msg {
	int iFrom; /* who sent the message (0 .. number-of-threads) */
	int value; /* its value */
	int cnt;  /*count of operations (no needed by all msgs) */
	int tot; /* total time (not needed by all msgs) */
};

// global variables
struct msg cc[MAXTHREAD];
sem_t array1[MAXTHREAD], array2[MAXTHREAD];
int fix[100];


//  put a given message into a mailbox given by the iTo ID
void SendMsg(int iTo, struct msg *pMsg) {
	fix[iTo] = 1;

    time_t begin,end; 
    begin = time(NULL);

	sem_wait(&array1[iTo]);
	if(pMsg->value != -1 ){
		sleep(1);
		cc[iTo].cnt ++;
		cc[iTo].iFrom = pMsg->iFrom;
		cc[iTo].value += pMsg->value;
	}
	
	sem_post(&array2[iTo]);
    end = time(NULL);

	cc[iTo].tot += end - begin;
}

// this functions gets a message from a given mailbox iFrom ID 
void RecvMsg(int iRecv, struct msg *pMsg) {
	sem_wait(&array2[iRecv]);
	pMsg->iFrom = cc[iRecv].iFrom;
	pMsg->value = cc[iRecv].value;
	pMsg->tot = cc[iRecv].tot; 
	sem_post(&array1[iRecv]);
}


void *init_thread(void *arg) {

}

int main(int argc, char *argv[]) {
	long i;
	

	
	if (argc != 2) {
		fprintf(stderr, "Error! type only number of threads to make!\n");
		exit(1);
	}

	int inputThread = atoi(argv[1]);


	if (inputThread > MAXTHREAD) {
		fprintf(stderr, "Error: program cannot create more than 10 threads\n");
		exit(1);
	}
	else if (inputThread == 0) {
		printf("Defaulting to maximum number of threads which is 10\n");
		inputThread = 10;
	}

	// array of threads, based on user inputted number of threads
	pthread_t t[inputThread];

	
	

	// producer and consumer semaphore for each mailbox
	for (i = 0; i < (MAXTHREAD + 1); i++) {
		if (sem_init(&array1[i], 0, 1) < 0) {
        	perror("sem_init");
        	exit(1);
    	}
    	if (sem_init(&array2[i], 0, 0) < 0) {
        	perror("sem_init");
        	exit(1);
    	}
	}

	for (i = 1; i <= inputThread; i++) {
		if (pthread_create(&t[i], NULL, init_thread, (void *)i) != 0) {
			perror("pthread_create");
			exit(1);
		}
	}


	int ind,value;
    char str[50]; 
     
	while(scanf("%[^\n]%*c", str)){

		int cnt = 1;
		for(int i=0;str[i];i++)
			if(str[i]==' ')
				cnt++;
		
		if(cnt != 2) break;

		
		sscanf(str, "%d%d", &value, &ind);

		if(value<0){
			printf("ERROR! Value %d is negative!\n", value);
		}

		if(ind>inputThread){
			printf("ERROR! Thread %d does not exist !!!\n", ind);
		}


		if(ind == -1)break;

		struct msg someMessage;

		someMessage.iFrom = 0;
		someMessage.value = value;
		someMessage.cnt = 0;
		someMessage.tot = 0;

		SendMsg(ind, &someMessage);
		RecvMsg(ind, &someMessage);	
	}
	

    

	for (int i=1;i<=inputThread;i++){
		if(!fix[i]){
			continue;
		}

		struct msg someMessage;


		someMessage.iFrom = 0;
		someMessage.value = -1;
		someMessage.cnt = 0;
		someMessage.tot = 0;

		SendMsg(i, &someMessage);
		RecvMsg(i, &someMessage);

		printf("The result from thread %d is %d from %d operations during %d secs.\n", i, cc[i].value, cc[i].cnt, cc[i].tot);
	}
	

	

	for (i = 1; i <= inputThread; i++) {
		(void)pthread_join(t[i], NULL);
	}


	
}
