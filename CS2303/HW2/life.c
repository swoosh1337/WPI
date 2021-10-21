/* Game of Life

life.c Irakli Grigolia
*/

#include <stdio.h>
#include <stdlib.h>
#include "twoD.h"
#include "life.h"



/** Main function.
 * @param argc Number of words on the command line.
 * @param argv Array of pointers to character strings containing the
 *    words on the command line.
 * @return 0 if success, 1 if invalid command line or unable to open file.
 * */
int main(int argc, char **argv) {
	printf("Game of Life\n");

	char *inputFileName; // Name of file containing initial grid
	FILE *input; // Stream descriptor for file containing initial grid
	int rows; // Number of rows in the grid
	int columns; // Number of columns in the grid
	int gens; // Number of generations to produce
	int doPrint; // 1 if user wants to print each generation, 0 if not
	int doPause; // 1 if user wants to pause after each generation, 0 if not

        rows = atoi(argv[1]); // Convert from character string to integer.
	columns = atoi(argv[2]);
	gens = atoi(argv[3]);
	inputFileName = argv[4];
        doPrint = argv[5][0];
        doPause = argv[6][0];

	// check if there are the right number of arguments on the command line
	if ((argc < 5) || (argc > 7)) {
	printf("wrong number of arguments\n");
		printf("Usage:\n");
		printf("  ./life rows columns generations inputFile [print] [pause]\n");
		return EXIT_FAILURE;
	}


               if(rows<=0 || columns<=0){
		printf("Wrong dimensions\n");
		return 0;
	}
	
	
	if(doPrint !='y' && doPrint !='n'){
			printf("Wrong character for print\n");
			return 0;
	}
	if(doPause !='y' && doPause !='n'){
			printf("Wrong character for pause\n");
			return 0;
	}
     
          

	
	
	
	int **S  = (int **)malloc(sizeof(int*)*rows);

	for (int i = 0; i < rows; i++) { // creates a row
		S[i] = (int*)malloc(columns * sizeof (int));
	}
           
   

	input = fopen(inputFileName, "r");
	if (!input) {
		printf("Unable to open input file: %s\n", inputFileName);
		return EXIT_FAILURE;
	}
         int st_row=0; // starting  number of rows which is eaqual to 0 in the beginning 
	 int st_col=0;// staring  number columns which is eqaul to 0 in the beginning
 
	while(1){// read characters until eof
		char d=fgetc(input);
		if(feof(input))break;
	
		if(d==13)continue;
		if(d=='\n'){
			st_col=0;
			st_row++;
		}else
		if(d!='x' && d!='o'){
			printf("Wrong Character\n");
			return 0;
		}else{

			S[st_row][st_col]=(d=='x');// stores 'x' as 1
			st_col++;// stores 'o'as 0
		}

	} 
	
	Print(rows,columns,S); 
        PlayOne(rows,columns,S,S,gens,doPrint,doPause);
	
	printf("All generations displayed\n");

	return EXIT_SUCCESS;
}
