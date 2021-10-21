#include <stdio.h>
#include <stdlib.h>
#include <iostream>

#ifndef ANT_H_
#define ANT_H_

#include "Organism.h"

class Ant:public Organism {
public:
	Ant(int X,int Y);
	virtual ~Ant(){}

	void print();
	int isPrey();
	Organism* get();

	pair<int,int> movement(Organism*** A, Organism*** B);
	void breed(Organism*** A, Organism*** B);
	int breedtime();
};

#endif /* ANT_H_ */
