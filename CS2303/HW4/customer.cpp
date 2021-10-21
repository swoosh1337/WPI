#include<stdio.h>
#include<stdlib.h>
#include<iostream>
#include <queue>

#include "customer.h"
#include "teller.h"
using namespace std;
extern TellerQueue tell_queue;
extern int Total_time;
extern int Total_idle_time;
extern int Times_idle;
extern int Total_trans_time;
/**
 * @return time Time the customer went into the bank
 * */
int Customer::gettime(){
	//cout<<time<<" cpp time"<<endl;
	return time;
}

void Customer::Action1(){

//cout<<tell_queue.thequeue.size()<<endl;
	Event* now=new Event();
//cout<<tell_queue.thequeue.size()<<endl;
//cout<<"line 10"<<endl;
for(int i=0; i<tell_queue.thequeue.size(); i++){
	//cout<<tell_queue.thequeue<<endl;
}
//cout<<tell_queue.TOP()->gettime()<<endl;
	while((tell_queue.TOP()->gettime())<(this->time)){
		cout<<"line 11"<<endl;
		/*teller should go idle if customers arrival time is more than tellers time
		  when he got free, and we can have case when  many tellers go idle at the same time or
		  they can  go idle multiple times in a row so we need while loop to
		  represent this kind of situations properly*/
		Event* now2=new Event();
		now2=(tell_queue.TOP());    //  getting top customer from the priority_queue
		tell_queue.REMOVE();       //  then removing him from the the priority_queue
		now2->addtimeto(now2->getidle());// giving him an idle time
		tell_queue.ADD(now2);       // and finally pushing him back to priority_queue

		Total_idle_time+=now2->getidle();   // adding idle time to total idle time
		Times_idle++;           // and then increamenting times_idle
	}
	now=tell_queue.TOP();
	tell_queue.REMOVE();

	int trans_time=1+rand()%200; // generating random time from 1 second to 200

	now->addtimeto(trans_time);

	Total_time+=(now->gettime()-this->time);
	Total_trans_time+=trans_time;
	cout<<"Total trans time: "<<Total_trans_time<<endl;
	cout<<"Totaltime: "<<Total_time<<endl;
	tell_queue.ADD(now);

}


extern int* cust_in_line;
extern int tellers;
extern TellerQueue* tell_queues;

void Customer::Action2(){


	int minimum=0,num_of_min=0;

	for(int i=0;i<tellers;i++)
		if(cust_in_line[minimum]>cust_in_line[i])  // getting index of the line with minimum number of customers
			minimum=i;							

	for(int i=0;i<tellers;i++)					// then find number of minimums
		if(cust_in_line[minimum]==cust_in_line[i])
			num_of_min++;

	int randnum=rand()%num_of_min;  // randomly generating line where each custumer should go

	for(int i=0;i<tellers;i++)       // and adding custumer to random line
			if(cust_in_line[minimum]==cust_in_line[i]){
				if(randnum==0){
					cust_in_line[i]++;
					tell_queues[i].ADD(this);
					break;
				}
				randnum--;
			}
}



extern int simulation_time;
Event* Customer::add(){
	int newtime=rand()%simulation_time;
	//int newtime=5;
	//int newtime=rand()%;
	Event* in=new Customer(newtime);
	return in;
}
