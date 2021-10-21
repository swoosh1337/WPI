/** mystruct.c
 * @author Mike Ciaraldi
*/


#include <string.h>
#include <stdlib.h>
#include "mystruct.h"

/** Allocates an Employee struct and fills in its fields
 * @param birth Year the emploee was born.
 * @param start Year the employee started with the company.
 * @param name String containing employee's name
 * @return Pointer to Employee struct, newly allocated from the heap.
 */
struct Employee* makeEmployee(int birth, int start, const char *name) {
 struct Employee *x =malloc(sizeof(struct Employee));
   x->birth_year=birth;
   x->start_year=start;
   strcpy(x->name,name);
   return x;

}

/**
 *Prints the components of the struct
 */
void printEmployee(struct Employee *e) {

	printf("birth year: %d, start year is: %d, name of the emloyee: %s \n",  (*e).birth_year,(*e).start_year,(*e).name);
}

/**
 * randomly generates the struct Employee
 * @return newly generated Employee
 */
struct Employee* randomEmployee(){

	struct Employee *d;

	int randbirth=randomint();
	int randstart=randomint();
	char* s=randomstring(randomint());
	d = makeEmployee(randbirth,randstart,s);

	return d;

}
/**
 * generates random int
 * @return int
 */

int randomint(){
	int a=rand();
 	int b=a%10;
return b;
}

/**
 * generates random String
 * @param length is length of the string
 * @return randomly  generated string
 */
char *randomstring(size_t length) {

    char *randomString = malloc(sizeof(char)* (length+1));

    for(int i=0;i<length;i++)
    	randomString[i] = 'a'+rand()%26;


    return randomString;
}
/**
 * @allocates an array that can hold count number of pointers
 * @param count number of pointers to hold
 * @return allocated array field with randomly generated employees
 */

struct Employee** alloc(int count){
	struct Employee ** ptr=malloc(sizeof (struct Employee)*count);
	for(int i=0;i<count;i++){
		ptr[i] = randomEmployee();
	}
return ptr;
}
/**
 * Prints the components of the allocated array
 * @param pointers allocated array
 * @param count number of employees to print from array
 * @return nothing (void function)
 */
void structprint(struct Employee ** pointers,int count){
	for(int i=0;i<count;i++){
		printEmployee(pointers[i]);
	}
}


/**
 * Duplicates the pointers of array to struct of this type
 * @param g array of pointers to struct
 * @param c size of array
 * @return duplicated array
 */
 struct Employee* myshallowcpy(struct Employee** g,int c){
	struct Employee ** a=malloc(sizeof (struct Employee*)*c);

	for(int i=0;i<c;i++){ // goes from 0 to the size of array and duplicates pointer
a[i]=g[i];

	}
return a;
}

 /**
  * frees all the structs pointed to
  * @param g array of pointers of type struct Employees
  * @param s size of array
  * @return nothing(void fucntion)
  */

 void deallocate(struct Employee** g,int s){

	 for(int i=0;i<s;i++){               //goes from 0 to the size of the pointer and frees the allocated memoty


		 free(g[i]);
	 }



 }
 /** Prints the struct
  * @param e Pointer to allocated array
  * @param c Number of Employee to print
  * @return (nothing void)
  */
 void printPtr(struct Employee* e, int c){
 	for(int i=0; i< c; i++){
 		printEmployee(e++);
 	}
 	printf("\n");
 }


 /** Prints struct
  * @param a Pointer to allocated array
  * @param c Number of Employee to print
  * @return (nothing vvoid)
  */
 void structPrint(struct Employee** a, int c){
 	for(int i=0; i< c; i++){
 		printEmployee(a[i]);
 	}
 	printf("\n");
 }










