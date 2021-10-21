#include <stdio.h>
#include <string.h>
// string.h covers the C-style string functions.
#include "mystring.h"
#include <stdlib.h>
/** ctest.c
 * Program to demonstrate character arrays and
 * dynamically-allocated memory.
 * @author Mike Ciaraldi
 * Add your own @author line below.
 */

const int MAX_CHARS = 20; // Maximum number of characters in array

int main()
{
	char a1[MAX_CHARS + 1]; // Character array--initially empty
	char a2[] = "Hello"; // Character array--unsized but initialized
	char a3[MAX_CHARS + 1]; // Character array--we will underfill it
	char* p1 = "Hello"; // Pointer to constant string
	char* p2 = NULL;           // Will be a pointer to dynamically-allocated string
	char* p3 = "Hi"; // Pointer to another constant string
	int copy_limit;     // Maximum characters to copy.

	  // testing of mystrcpy();
	 char src1[30]="C/C++!";
	 char trgt[30]={0};

	    //copy string
	     mystrcpy(trgt, src1);
	    printf("testing of mystrcpy \n");
	    printf("Source String: %s\n",src1);
	    printf("Target String: %s\n",trgt);



        //testing mystrcat
           printf("Testing mystrcat\n");
           char *s="Worcester";
           char *t="Polytechnic";
            //appending Strings
           char *q=mystrcat(s,t);
           printf("appended string ->: %s\n", q);
           free(q);

        //testing my strncat test#1
           printf("testing mystrncat \n");
             char dest[15];
             strcpy(dest, "WP ");
             char src2[] = "I";
             mystrncat(dest, src2, 1); //when n equals to size of source string
            printf("appended string ->: %s \n",dest);
            //test#2
            char dest1[15];
             strcpy(dest1, "WP ");
            char src3[] = "I";
              mystrncat(dest1, src3, 10); //when n is greater then soruce string
              printf("appended string ->: %s \n",dest1);
          //test#3
             char dest3[15];
           strcpy(dest3, "WP ");
         char src4[] = "I";
        mystrncat(dest3, src4, 0); // when n is smaller the source string
            printf("appended string ->: %s \n",dest3);


            //testing of mystrncpy test #1

        	char* source = "Worcester Polytechnic";
        	char destination[10];

        	size_t n = 9;
        	printf("%s \n", strncpy(destination, source, n));

        	//test#2
        	char* source1 = "Worcester ";
        	        	char destination1[10];

        	        	size_t n1 = 11; //when n is greater than source string
        	        	printf("%s \n", strncpy(destination1, source1, n1));
                    //test#3
        	        	char* source2 = "Worcester Polytechnic";
        	        	        	char destination2[10];

        	        	        	size_t n2 = 21; //when n is equal to the size of the source string
        	        	        	printf("%s \n", strncpy(destination2, source2, n2));



            //testing of mystrndup()#1
        	     printf("testing my strncpy:\n");
        	char source10[] = "Worcester";


        	   char* target5 = mystrndup(source10,6); //when n is smaller then size of source string
                printf("%s \n", target5);

        	        	 //test#2
        	     char source11[] = "Worcester";
    char* target6 = mystrndup(source11,10); //when n is greater then size of source string

    printf("%s \n", target6);
              //test#3

char source12[] = "Worcester";
char* target7 = mystrndup(source12,9); //when n is equal of size of source string

printf("%s \n", target7);


strcpy(a3, "Hello, one more time."); // Initialize underfilled character array


	strcpy(a3, "Hello, one more time.");

	/* Print the pointers.
     Note: this example prints
     the values of the pointers themselves, not the targets.
	 */
	printf("Initial state:\n");
	printf("Pointers: a1 = %p, a2 = %p, a3 = %p\n", a1, a2, a3);
	printf("          p1 = %p p2 = %p\n", p1, p2);

	strcpy(a1, p3); // Initialize character array

	printf("a1 = %s\n", a1);
	printf("a2 = %s\n", a2);
	printf("a3 = %s\n", a3);

	// Note that strlen() returns size_t, which is typedef'd to
	//   unsigned long, so we need to print it with %ld instead of just %d.
	printf("For string /%s/, strlen() returns %ld\n", p1, strlen(p1));
	//printf("For string /%s/, mystrlen1() returns %ld\n", p1, mystrlen1(p1));

	// Duplicate a string, using strdup(), then print
	printf("\nBefore calling strdup(), pointer a2 = %p, contents = %s\n", a2, a2);
	p2 = strdup(a2);
	printf("Duplicated string: \n");
	printf("Pointer p2 = %p, contents = %s\n", p2, p2);

	// Duplicate a string, using my function, then print
	printf("\nBefore calling mystrdup1(), pointer a2 = %p, contents = %s\n", a2, a2);
	p2 = mystrdup1(a2);
	printf("Duplicated string: \n");
	printf("Pointer p2 = %p, contents = %s\n", p2, p2);


	// Be sure there is a terminator character in the last element of the array
	a1[MAX_CHARS] = '\0';

	// Concatenate two character arrays, then print.
	strcpy(a1, p3); // Reset character array
	strcat(a1, a2);
	printf("Using strcat() to concatenate a2 to the end of a1\n");
	printf("a1 = %s\n", a1);

	// Concatenate two character arrays safely, then print.
	strcpy(a1, p3); // Reset character array
	a1[MAX_CHARS] = 'A'; // Remove terminator, to prove strncat() puts it back in.
	copy_limit = MAX_CHARS - strlen(a1); // How much space is left?
	printf("Using strncat() to concatenate to the end of a1, with copy_limit = %d\n",
			copy_limit);
	if (copy_limit > 0) strncat(a1, a3, copy_limit);
	printf("a1 = %s\n", a1);

	return 0;
}
