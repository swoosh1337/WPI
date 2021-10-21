#include<stdio.h>
#include<stdlib.h>
#include<iostream>
#include<queue>
#include<typeinfo>
#include "event.h"


void EventQueue::getnew(){
	//cout<<"line 7"<<endl;
	Event *now=thequeue.top();
	//cout<<"line 8"<<endl;
	thequeue.pop();
	//cout<<thequeue<<endl;
	//cout<<"line 9"<<endl;
	//cout<<typeid(now).name()<<endl;
	if(typeid(now).name()=="Customer"){
	now->Action1();
	now->Action1();
	}
//cout<<"aq varoooooooooo"<<endl;
}
void EventQueue::getnew2(){

	Event *now=thequeue.top();
	thequeue.pop();

	now->Action2();
}
Event* EventQueue::TOP(){
	return thequeue.top();
}
void EventQueue::REMOVE(){
	thequeue.pop();
}
void EventQueue::ADD(Event *a){
	thequeue.push(a);
}

