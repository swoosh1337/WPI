#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <algorithm>

#include "Ant.h"
#include "board.h"
#include "Organism.h"

using namespace std;
extern vector<pair<int,int> >moving;
/**Constructor for Ant
 * @param X x parameter of Ant's position on the grid
 * @param Y y parameter of Ant's position on the grid
 * */
Ant::Ant(int X,int Y) {
	x=X;
	y=Y;
}
/**Prints 0, which represents Ant in the printed grid
 * @return void
 * */
void Ant::print(){
	cout<<"o";
	return;
}
/**returns 1 if Ant is a Prey, which it always is
 * @return int 1
 * */
int Ant::isPrey(){
	return 1;
}

pair<int,int> Ant::movement(Organism*** curBoard, Organism*** newBoard){

	random_shuffle(moving.begin(),moving.end());
	for(int i=0;i<4;i++){	// check surroundings
		int newx=x+moving[i].first;
		int newy=y+moving[i].second;

		if(!check(newx,newy))continue;

		if(curBoard[newx][newy]->isPrey()>0 ||
		   newBoard[newx][newy]->isPrey()!=0){
			continue;  // not empty
		}else{
				newBoard[newx][newy]=new Ant(newx,newy);
				newBoard[newx][newy]->step=step+1;

				return make_pair(x,y);
			}
		}
	return make_pair(-1,-1);
}
/** getter for the Pointer to a new Ant with steps(number of steps it has taken)
 * @return Organism* Pointer to a new organism
 * */
Organism* Ant::get(){
	Ant* a=new Ant(x,y);
	a->step=step;
	return a;
}
/**returns 0 or -1 based on if the breadtime of the Ant is equal or more than 3
 * @return int 0 0r -1
 * */
int Ant::breedtime(){
	return(step>=3);
}
/** updates the board according to the effects of Ant making a breeding move
 * @param curBoard Pointer 2D array to current Board
 * @param newBoard Pointer 2D array to new Board
 * @return void
 * */
void Ant::breed(Organism*** curBoard, Organism*** newBoard){

	random_shuffle(moving.begin(),moving.end());
	random_shuffle(moving.begin(),moving.end());
	for(int i=0;i<4;i++){	// check surroundings
		int newx=x+moving[i].first;
		int newy=y+moving[i].second;

		if(!check(newx,newy))continue;

		if(newBoard[newx][newy]->isPrey()==0){
				newBoard[newx][newy]=new Ant(newx,newy);
				newBoard[newx][newy]->step=0;
				step=0;
				return ;
			}
		}

	return;
}
