#ifndef BOARD_H_
#define BOARD_H_


void printStep(int gridsize, Organism*** a);
int check(int x,int y);

void playOne(int gridsize, Organism*** curBoard, int time_steps,int count=1);
#endif /* BOARD_H_ */
