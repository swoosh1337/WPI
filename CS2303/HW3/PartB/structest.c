#include <stdio.h>
#include "mystruct.h"

int main(int atgc, char *argv[]) {
	struct Employee *e;
     //test make employee and printemployee
	printf("test for make employee and print employee\n");
	e = makeEmployee(1952, 1999, "Mike Ciaraldi \n");
	printEmployee(e);

	//test for ranomd emloyee
	printf("test for random employee\n");
    struct Employee *a;
    a=randomEmployee();
    printEmployee(a);
    printf("\n");

 //test of sturctprint
 printf("testing structprint:\n");
 structprint(alloc(15),5);
 printf("\n");


 //test for my shallowcpy()
 printf("testing myshallowcpy:\n");

 struct Employee **b;

 	b= alloc(3);
 	structPrint(b,3);
 	printf("Shallow Copy of b \n");
 	structPrint(myshallowcpy(b, 3),3);   // since values are the same pointers were copied correctly
 	deallocate(b, 3);


 return 0;
}
