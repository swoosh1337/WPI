#ifndef EVENT_H_
#define EVENT_H_

#include<stdio.h>
#include<stdlib.h>
#include<vector>
#include<queue>

using namespace std;

class Event{
public:
	int lineNumber;
	Event(){}
	virtual Event* add ()
	      { return NULL; }
	virtual int gettime ()
	      { return (0); }
	virtual int getidle()
	      { return (0); }
	virtual void Action1 ()
	      {return ; }
	virtual void Action2 ()
	      {return ; }
	virtual void addtimeto (int trans_time)
	      { return ; }



	virtual ~Event(){}
};

struct cmp {
    bool operator()(Event *a, Event *b)
    {
        return (a->gettime()>b->gettime());
    }
};

class EventQueue{
public:
	std::priority_queue<Event *,std::vector<Event *>,cmp> thequeue;
	EventQueue(){}
	void getnew();
	void getnew2();
	Event* TOP();
	void REMOVE();
	void ADD(Event *a);

};



#endif /* EVENT_H_ */
