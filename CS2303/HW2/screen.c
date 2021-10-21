/*
 * screen.c Irakli Grigolia
 * 
 */

#include<stdlib.h>
#include<stdio.h>
#include"life.h"



/** Print function.
 * @param rows Number rows
 * @param columns Number of columns
 * @param *S[] array
 * @return nothing because it is a void function
 * */                                               
 void Print(int rows,int columns,int *S[]){// prints the output from the file
	for(int i=0;i<columns;i++){
      printf("                                         ");
			for(int j=0;j<rows;j++)
				if(S[i][j])printf("x");else
						printf("o");
			printf("\n");
		}
	return;
} 

/** PlayOne function.
 * @param rows Number rows
 * @param columns Number of columns
 * @param *A[] old generation
 * @param *B[] current generation
 * @param doPrint indicates whether or not every new generation should be printed
 * @param doPause indicates where or not a keystroke is needed between generations  
 * @return nothing because it is a void function
 * */  
void PlayOne(int rows,int columns,int *A[],int *B[],int gens,char doPrint,char doPause){
if(gens==0){ return; } // if there are not genereation the program will exit 





int **new_array  = (int **)malloc(sizeof(int*)*rows); //new array
int **neighbor = (int **)malloc(sizeof(int*)*rows); // array for neighbor
for (int i = 0; i < rows; i++) {
new_array[i] = (int *)malloc(columns * sizeof (int));
	}
	for (int i = 0; i < rows; i++) {
	neighbor[i] = (int*)malloc(columns * sizeof (int));
	}

        // initialize new_array and neighbor_array
	for(int i=0;i<rows;i++)
		for(int j=0;j<columns;j++)new_array[i][j]=neighbor[i][j]=0;

         // checks if cell is alive and adds to neighbor if so
	for(int i=0;i<rows;i++)
	for(int j=0;j<columns;j++){
       if(B[i][j]){
	if(i>0)neighbor[i-1][j]++;
if(j>0)neighbor[i][j-1]++;
if(i+1<rows)neighbor[i+1][j]++;
if(j+1<columns)neighbor[i][j+1]++;

if(i && j)neighbor[i-1][j-1]++;
if(i && j+1<columns)neighbor[i-1][j+1]++;
if(i+1<rows && j)neighbor[i+1][j-1]++;
if(i+1<rows && j+1<columns)neighbor[i+1][j+1]++;
			}
		}
        // determines who lives and dies 
	for(int i=0;i<rows;i++)
	for(int j=0;j<columns;j++){
		if(neighbor[i][j]<=1 || neighbor[i][j]>=4){ new_array[i][j]=0;}  else
		if(!B[i][j] && neighbor[i][j]==3){ new_array[i][j]=1;} else
		if(B[i][j]){ new_array[i][j]=1;}  else new_array[i][j]=0;
		}

if(doPause=='y')getchar();
	if(doPrint=='y'){
		Print(rows,columns,new_array);
		if(doPause=='n')printf("\n");
	}


	int Case1=0,Case2=0,Case3=0; // we need this to check whether or not the old array is equal to new one  and to search  for a cycle 

	for(int i=0;i<rows;i++)
			    for(int j=0;j<columns;j++){
				if(B[i][j]!=new_array[i][j])Case1=1;// checks if B is equal to new_array, and if so sets Case1 to be equal to 1
				if(A[i][j]!=new_array[i][j])Case2=1;// checks if new_Array is equal to A, and if so sets Case2 to be equal to 1
				if(new_array[i][j]>0)Case3=1;// tells whether all cells are dead or not, and if so sets Case3 to be equal to 1
        		    }

				
    // releases the memory of 2D array
    for(int i=0;i<rows;i++){
    	free(neighbor[i]);
    }
    free(neighbor);

    if(Case1==0){
printf("no change was made\n");
exit(0);
}

if(Case2==0){

printf("found a cycle\n");
exit(0);

}

if(Case3==0){
printf("all cells are dead\n");
exit(0);

}
    // it starts again  and does the same thing except   executes (gens-1) number of generations 
    PlayOne(rows,columns,B,new_array,gens-1,doPrint,doPause);

    for(int i=0;i<rows;i++){
    	free(new_array[i]);
    }
    free(new_array);

    return;
}
