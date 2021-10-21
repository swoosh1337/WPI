#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <vector>
#include "Organism.h"

using namespace std;

extern int pause;
extern int gridsize;

/**checks if coordinates of a point are in the board range
 * @param x X coordinate of a point
 * @param y Y coordinate of a point
 * @return int 1 or 0. 1 if point is in the board range, 0 if out of range
 * */
int check(int x,int y){  // checks if (x,y) is in the range of board
	if(x<0 || y<0 || x>=gridsize || y>=gridsize)return 0;
	return 1;
}
/**Prints the configuration of organisms
 * @param gridsize Size of both sides of the grid
 * @param a Pointer array to 2D array of Organisms
 * @return void
 * */
void printStep(int gridsize, Organism*** a) {
	/*Double for loop
	 * for loop iterates between 0 and gridsize(excluded)
	 * 				for loop iterates from 0 and gridsize(excluded)
	 * 					prints every element of the array
	 * */
	for(int i = 0; i < gridsize; i++) {
		for(int j = 0; j < gridsize; j++) {
			a[i][j]->print();
		}
		cout<<endl;
	}
	cout<<endl;
}
/**
 * @param gridsize Size of both sides of the grid
 * @param curBoard Pointer array to current/most updated 2D array of Organisms
 * @param time_steps Number of steps/times the play/simulation will last
 * @param count Dummy int variable, originally equal to 1
 * @return void
 * */
void playOne(int gridsize, Organism*** curBoard, int time_steps,int count=1) {
	int rows,cols;
	rows=cols=gridsize;

	Organism ***newBoard = (Organism ***)malloc(sizeof(Organism**)*gridsize);

	if(time_steps == 0) {
		return;
	}
	/*for loop iterates from 0 until the number of rows of the grid
	 * 		allocates memory for a newBoard of the length of input of 2D array
	 * */
	for(int i = 0; i < rows; i++) {
		newBoard[i] = (Organism**)malloc(cols * sizeof(Organism*));
	}
	/*Double for loop
		 * for loop iterates between 0 and row length of current grid(excluded)
		 * 				for loop iterates from 0 and column length of current grid (excluded)
		 * 					adds every element of input grid to new board
		 * */
	for(int i = 0; i < rows; i++) {
		for(int j = 0; j < cols; j++) {
			newBoard[i][j] = new Organism();
		}
	}
	/*Double for loop
			 * for loop iterates between 0 and gridsize(excluded)
			 * 				for loop iterates from 0 and gridsize(excluded)
			 * 					adds
			 * */
	for(int i=0;i<gridsize;i++)
		for(int j=0;j<gridsize;j++)
			curBoard[i][j]->x=i,
			curBoard[i][j]->y=j;


	for(int i=0;i<gridsize;i++)
		for(int j=0;j<gridsize;j++){
			if(curBoard[i][j]->isPrey()==0)continue;

			if(curBoard[i][j]->isPrey()==2){

				pair<int,int>new_loc = curBoard[i][j]->movement(curBoard,newBoard);

				if(new_loc==make_pair(-1,-1)){

					newBoard[i][j]=curBoard[i][j]->get();
					newBoard[i][j]->step++;
				}
			}
		}

	for(int i=0;i<gridsize;i++)
		for(int j=0;j<gridsize;j++){
			if(curBoard[i][j]->isPrey()==0)continue;
			if(curBoard[i][j]->isPrey()==1 && newBoard[i][j]->isPrey()!=2){
				pair<int,int>new_loc = curBoard[i][j]->movement(curBoard,newBoard);

				if(new_loc==make_pair(-1,-1)){

					newBoard[i][j]=curBoard[i][j]->get();
					newBoard[i][j]->step++;
				}
			}
		}

	for(int i=0;i<gridsize;i++)
		for(int j=0;j<gridsize;j++){
			if(newBoard[i][j]->isPrey()==0)continue;
			if(newBoard[i][j]->isPrey()==2) {
				newBoard[i][j]->starving(newBoard);
			}
			if(newBoard[i][j]->breedtime()){
					newBoard[i][j]->breed(curBoard,newBoard);//cout<<"!!!"<<endl;
			}
		}


	int er3 = 0;

	for(int i=0;i<gridsize;i++)
		for(int j=0;j<gridsize;j++){
			if(newBoard[i][j]==NULL)newBoard[i][j]=new Organism();
		}

	for(int i = 0; i < rows; i++) {
		for(int j = 0; j < cols; j++) {
			if(newBoard[i][j]->isPrey() > 0) {
				er3 = 1;
			}
		}
	}

	printStep(gridsize, newBoard);

	if(!er3) {
		exit(0);
	}

	if(pause!=0 && count%pause==0) {
		//getchar();
	}

		for(int i = 0; i < rows; i++) {
			free(curBoard[i]);
		}
		free(curBoard);
		//recursion
	playOne(gridsize, newBoard, time_steps - 1,count+1);
}
