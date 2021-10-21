#include <stdio.h>
#include <stdlib.h>
#include <iostream>
using namespace std;
#include "Organism.h"

#ifndef DOODLEBUG_H_
#define DOODLEBUG_H_

class Doodlebug:public Organism {
public:
	Doodlebug(int X,int Y);
	virtual ~Doodlebug(){}

	int isPrey();
	void print();
	pair<int,int> movement(Organism*** curBoard, Organism*** newBoard);
	pair<int,int> eat(Organism*** curBoard, Organism*** newBoard);

	void starving(Organism*** curBoard);
	int breedtime();
	Organism* get();

	void breed(Organism*** curBoard, Organism*** newBoard);
};

#endif /* DOODLEBUG_H_ */
