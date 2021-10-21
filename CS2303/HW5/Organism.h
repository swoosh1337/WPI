using namespace std;

#ifndef ORGANISM_H_
#define ORGANISM_H_

class Organism {
public:
	Organism();
	virtual ~Organism(){}

	int x, y;
	int step;
	int timetoeat;

	virtual void print();
	virtual int isPrey(){return 0;}
	virtual Organism* get(){return NULL;}
	virtual int breedtime(){return 0;}
	virtual pair<int,int> movement(Organism*** curBoard, Organism*** newBoard){return make_pair(-1,-1);}
	virtual void breed(Organism*** curBoard, Organism*** newBoard){return ;}
	virtual void starving(Organism*** newBoard){return;}

};

#endif /* ORGANISM_H_ */
