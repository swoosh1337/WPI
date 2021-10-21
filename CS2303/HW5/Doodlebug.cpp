#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <vector>
#include <algorithm>

#include "Doodlebug.h"
#include "board.h"

using namespace std;
extern vector<pair<int,int> >moving;
/**Constructor for Doodlebug
 * @param X x parameter of Doodlebug's position on the grid
 * @param Y y parameter of Doodlebug's position on the grid
 * */
Doodlebug::Doodlebug(int X,int Y) {
	x=X;
	y=Y;
}
/**Prints x, which represents Doodlebug in the printed grid
 * @return void
 * */
void Doodlebug::print(){
	cout<<"x";
	return;
}
/**returns 2 if Doodlebug is not a Prey, which it never is
 * @return int 2
 * */
int Doodlebug::isPrey(){
	return 2;
}
/**returns 0 or -1 based on if the breadtime of the Doodlebug is equal or more than 8
 * @return int 0 0r -1
 * */
int Doodlebug::breedtime(){
	return(step>=8);
}
/**returns the new coordinates of Doodlebug after it makes an eat movement, (-1,-1) if Doodlebug disappears
 * updates new board
 * @param curBoard Pointer 2D array to current Board
 * @param newBoard Pointer 2D array to new Board
 * @return pair<int,int> new point of the DoodleBug
 * */
pair<int,int> Doodlebug::eat(Organism*** curBoard, Organism*** newBoard){


	random_shuffle(moving.begin(),moving.end());
	for(int i=0;i<4;i++){// check surroundings
		int newx=x+moving[i].first;
		int newy=y+moving[i].second;

		if(!check(newx,newy))continue;

		if(curBoard[newx][newy]->isPrey()==1 && newBoard[newx][newy]->isPrey()==0){
				newBoard[newx][newy]=new Doodlebug(newx,newy);
				newBoard[newx][newy]->step=step+1;
				newBoard[newx][newy]->timetoeat=0;

				return make_pair(x,y);
			}
		}


	return make_pair(-1,-1);
}
/**returns the new coordinates of Doodlebug after it makes a movement, (-1,-1) if Doodlebug disappears
 * Updates the new board
 * @param curBoard Pointer 2D array to current Board
 * @param newBoard Pointer 2D array to new Board
 * @return pair<int,int> new point of the DoodleBug
 * */
pair<int,int> Doodlebug::movement(Organism*** curBoard, Organism*** newBoard){

	pair<int, int>trial=this->eat(curBoard,newBoard);
	if(trial != make_pair(-1,-1)) {
		return trial;
	}


	random_shuffle(moving.begin(),moving.end());
	for(int i=0;i<4;i++){// checks surroundings
		int newx=x+moving[i].first;
		int newy=y+moving[i].second;

		if(!check(newx,newy))continue;

		if(curBoard[newx][newy]->isPrey()>0 ||
		   newBoard[newx][newy]->isPrey()!=0){
			continue;  // not empty
		}else{
				newBoard[newx][newy]=new Doodlebug(newx,newy);
				newBoard[newx][newy]->step=step+1;
				newBoard[newx][newy]->timetoeat=timetoeat+1;

				return make_pair(x,y);
			}
		}


	return make_pair(-1,-1);

}
/** updates the board according to the effects of Doodlebug making a breeding move
 * @param curBoard Pointer 2D array to current Board
 * @param newBoard Pointer 2D array to new Board
 * @return void
 * */
void Doodlebug::breed(Organism*** curBoard, Organism*** newBoard){
	random_shuffle(moving.begin(),moving.end());
		random_shuffle(moving.begin(),moving.end());
		for(int i=0;i<4;i++){// check surroundings
			int newx=x+moving[i].first;
			int newy=y+moving[i].second;

			if(!check(newx,newy))continue;

			if(newBoard[newx][newy]->isPrey()==0){
					newBoard[newx][newy]=new Doodlebug(newx,newy);
					newBoard[newx][newy]->step=0;
					step=0;
					return ;
				}
			}



		return;
}
/** getter for the Pointer to a new Organism with steps(number of steps it has taken) and timetoeat(number of times it has gone without eating)
 * @return Organism* Pointer to a new organism
 * */
Organism* Doodlebug::get(){
	Doodlebug* a=new Doodlebug(x,y);
	a->step=step;
	a->timetoeat=timetoeat;
	return a;
}
/**if the Doodlebug is starving the Doodlebug dies and space in the grid is freed
 * @param newBoard Pointer array to 2D array of Organisms
 * @return void
 * */
void Doodlebug::starving(Organism*** newBoard) {
	if(timetoeat >= 3) {
		newBoard[x][y] = new Organism();
		return ;
	}
}

