#include<stdio.h>
#include<stdlib.h>
#include<cstdlib>
#include<queue>
#include<iostream>
#include<fstream>
#include"event.h"
#include"customer.h"
#include"teller.h"
#include"simulation.h"

using namespace std;
int simulation_time;
int timeavg;
double seed=-1;
int Total_time;
int Total_idle_time;
int Times_idle;
int Total_trans_time;
int customers,tellers;
int* cust_in_line;
//void case1(int customers,int tellers);
//void case2(int customers,int tellers);
//void print();

Teller tel;
Customer cust;
Event* sample_teller=&tel;
Event* sample_customer=&cust;
Event** all_tellers;
Event** all_customers;
TellerQueue tell_queue;
TellerQueue* tell_queues;
EventQueue *eq;

/** returns 0 if the program is successful
@param argc Number of arguments
@param *argv Array of pointers
@return 0

*/

int main(int argc,char *argv[]) {

	//freopen("a.out","w",stdout);
    customers=atoi(argv[1]);
	tellers=atoi(argv[2]);
	simulation_time=atoi(argv[3]);
	//timeavg= atoi(argv[4]);
	if(argc>=5)seed=atof(argv[4]);else
		seed=-1;

	if(seed==-1)seed=rand();

	srand(seed+1);

	printf("Simulation time  - %d\n",simulation_time);
	printf("Transaction time between       %5d - %d\n",1,500);
	printf("Idle time between              %5d - %d\n",1,600);
	printf("Customers and Tellers          %5d - %d\n",customers,tellers);
	cout<<endl<<endl<<endl;

	cout<<"Simulation with one line"<<endl<<endl;

	case1(customers, tellers);
	//cout<<"line 1"<<endl;
	print();
	Total_time=Total_idle_time=Times_idle=Total_trans_time=0;

	cout<<endl<<endl<<endl;

	cout<<"Simulation with multiple line"<<endl<<endl;


	case2(customers, tellers);

	print();


	return 0;
}

/**case1 is the simulation of situation when there is only one line with multiple tellers
@param customers Number of customers
@param tellers Number of tellers
@return (void)
@
*/

void case1(int customers,int tellers){
	//cout<<"line 2"<<endl;
	eq=new EventQueue();
	//cout<<"line 3"<<endl;
	all_customers=new Event*[customers];
	//cout<<"line 4"<<endl;
	all_tellers=new Event*[tellers];

	/*for loop iterates between 0 and number of customers
		 * it generates new customers
		 * and pushes those new customers into the priority queue of eventq
		 * */

	for(int i=0;i<customers;i++){

	    	all_customers[i]=sample_customer->add();
			//all_customers[i]= Customer(5)->add();

			eq->thequeue.push(all_customers[i]);

		}
	/*
	//double avg = 0.0;
	//double size = 0.0;
	while(!(eq->thequeue.empty())){
		cout<< (eq->thequeue.top())->gettime()<<endl;
		//avg += double((eq->thequeue.top())->gettime());
		//size += 1.0;
		eq->thequeue.pop();
	}*/
	//avg = avg/size;
	//cout <<avg<<endl;

	/*all_tellers[0]=new Teller(6);
		all_tellers[1]=new Teller(2);
		all_tellers[2]=new Teller(5);
		all_tellers[3]=new Teller(1);*/


	/*for loop iterates between 0 and number of tellers
			 * it generates new tellers
			 * and pushes those new tellers into the priority queue of eventq
			 * */

	for(int i=0;i<tellers;i++){

		all_tellers[i]=sample_teller->add();
		eq->thequeue.push(all_tellers[i]);// adding to priority_Queue

	}
	/*avg = 0.0;
	size = 0.0;
		while(!(eq->thequeue.empty())){
			cout<< (eq->thequeue.top())->gettime()<<endl;
			avg += double((eq->thequeue.top())->gettime());
			size += 1.0;
			//eq->thequeue.pop();
		}
		avg = avg/size;
			cout <<avg<<endl;*/
	/*While loop iterates until the Queue of the EventQueue pointed to by eventq pointer is not empty
		 * This loop processes the members of eventqueue
		 * */
	//cout<<"line 5"<<endl;
	//int i =0;
	while(!eq->thequeue.empty()){ // checking members of eventqueue
		//cout<<"line 6"<<endl;
		eq->getnew();
		//eq->thequeue;
		//i++;

	}
	//cout<<"line 7    "<<i<<endl;

	/*for loop iterates between 0 and number of customers
		 * it free the memory of the pointer array to ALL customers
		 * */
	for(int i=0;i<customers;i++)
		delete(all_customers[i]);

	delete(all_customers);

	/*for loop iterates between 0 and number of tellers
		 * it free the memory of the pointer array to ALL tellers
		 * */
	for(int i=0;i<tellers;i++)
		delete(all_tellers[i]);
	delete(all_tellers);

	delete(eq);
}
/**case2 is the simulation of situation when there are multiple lines with multiple tellers
@param customers Number of customers
@param tellers Number of tellers
@return (void)
@
*/
void case2(int customers,int tellers){

	tell_queues=new TellerQueue[tellers];
	eq=new EventQueue();


	all_customers=new Event*[customers];
	all_tellers=new Event*[tellers];
	/*for loop iterates between 0 and number of customers
			 * it generates new customers
			 * and pushes those new customers into the priority queue of eventq
			 * */
	for(int i=0;i<customers;i++){  // creating new customers 
    	all_customers[i]=sample_customer->add();
		eq->thequeue.push(all_customers[i]); // adding to priority queue
	}
	/*for loop iterates between 0 and number of tellers
				 * it generates new tellers
				 * and pushes those new tellers into the priority queue of eventq
				 * */
	for(int i=0;i<tellers;i++){  //creaiting new tellers
		all_tellers[i]=sample_teller->add();
		all_tellers[i]->lineNumber=i;
		eq->thequeue.push(all_tellers[i]); // adding to priority queue
	}
	cust_in_line=new int[tellers];
	/*for loop iterates from 0 to the number of tellers and makes every element of num_cust 0*/
	for(int i=0;i<tellers;i++)cust_in_line[i]=0;
	/*While loop iterates until the Queue of the EventQueue pointed to by eventq pointer is not empty
			 * This loop processes the members of eventqueue
			 * */
	while(!eq->thequeue.empty()){
		eq->getnew2();
	}


	/*for loop iterates between 0 and number of customers
			 * it free the memory of the pointer array to ALL customers
			 * */
	for(int i=0;i<customers;i++)
		delete(all_customers[i]);
	delete(all_customers);

	/*for loop iterates between 0 and number of tellers
			 * it free the memory of the pointer array to ALL tellers
			 * */
	for(int i=0;i<tellers;i++)
		delete(all_tellers[i]);

	delete(all_tellers);
}
//printing statistics
void print(){
	printf("Average transaction time                      %7.2f\n",double(Total_trans_time)/double(customers));
	printf("%f",double(Total_trans_time));
	printf("Total idle time - Times_idle                  %7d %d\n",Total_idle_time,Times_idle);
	printf("Total time -  Average waiting time            %7d %.2f\n",Total_time,double(Total_time)/double(customers));

}
