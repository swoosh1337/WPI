/** mystring.c
 * @author Mike Ciaraldi
 * My own versions of some of the C-style string functions
*/

#include <string.h>
#include <stdlib.h>
// Have to #include stdlib.h because it is needed to use malloc()
#include "mystring.h"

/** Duplicates a C-style string.
 @param src Pointer to string to be copied
 @return Pointer to freshly-allocated string containing a duplicate of src
         or null if no memory is available
*/
char* mystrdup1(const char* src) {
  int length; // Length of the source string
  char* newstr; // Pointer to memory which will hold new string

  length = mystrlen1(src) + 1;  // Leave space for the terminator
  newstr = (char*) malloc(length); // Must cast!

  // If no memory was available, return null pointer immediately
  if (newstr == 0) return (char *) 0;

  // Otherwise, copy the string and return pointer to new string
  strcpy(newstr, src);
  return newstr;
}

char* mystrdup2(const char* src) {
  int length; // Length of the source string
  char* newstr; // Pointer to memory which will hold new string

  length = mystrlen2(src) + 1;  // Leave space for the terminator
  newstr = (char*) malloc(length); // Must cast!

  // If no memory was available, return null pointer immediately
  if (newstr == 0) return (char *) 0;

  // Otherwise, copy the string and return pointer to new string
  strcpy(newstr, src);
  return newstr;
}
/**
 * Calculates string length
 * @param i holds length of the string
 * @return length of the String
 */
size_t
mystrlen1(const char *str)
{
		int i;
        for (i = 0; str[i]; ++i);

        return (i);
}

/**
 * Calculates string length
 * @param s pointer to the 0th element of the array in the beginning(finally holds the  null terminator)
 * @return length of the String
 */
size_t
mystrlen2(const char *string)
{
        const char *t;

        for (t = string; *t; ++t);

        return (t - string);
}

/**
 * Copies string from source to target
 * @return String which is copied to target
 * @param t target
 * @param s source
 * @return string that is copied
 */
char  *mystrcpy(char* t, char* s){
    while(*t=*s){             // while  loop works while it reaches the null terminator
        *t++;                // and it copies first character every time and then pointers get iterated  and copies the next character
        *s++;               // and so on

    }
    return t;
}
/**
 * Appends two Strings
 * @param t target string
 * @param s  source string
 * @return appended string
 */

char *mystrcat(char *s,char *t)
{
    char *g=malloc(strlen(s)+strlen(t)+1);    /* :we need memory to hold the appended string. +1 for the null terminator  */
    int p =0, j = 0;          //some helper parameter that helps us to go through the second string

    while(s[j]){ g[p++] = s[j++]; //p Some helper parameter  that helps us  us to go through first string
    }
    j=0;
    while(t[j]){ g[p++]=t[j++];
    }
    return g;

}
/**
 * Appends first n characters of source string to destination string
 * @param destination  destination string
 * @param source source string from which  n character are appended to destination
 * @return  pointer to appended String
 */
char* mystrncat(char* destination, const char* source, size_t n)
{
	int a, b;
	for (a = 0; destination[a] != '\0'; a++); // go through the destination string
                                              // i point to the null terminator

	for (b = 0; source[b] != '\0' && b < n; b++){ // Appends first n characters of source to the destination string
	  destination[a + b] = source[b]; }
	  destination[a + b] = '\0';   // null terminator for destination string

	return destination;
}

/**
 * @ copies first n characters from src string to dest string
 * @ param dest destination string
 * @ param src source string from which first n characters get coppied to dest
 * @ return  pointer to the destination string
 */
char* mystrncpy(char* dest, const char* src, size_t n){
	if (dest == NULL){ // in case if there is no memory allocated
		return NULL;}


	char* p = dest; //pointer that point to the beginning of the string
	while(n -- && (*dest++ =*src ++)); //copies character form source to destination

		*dest = '\0'; // null terminator for destination


		return p;
	}
/**
 *@ copies at most n character from source string
 *@param source string
 *@param n number of character to copied
 *@return  a pointer to a null-terminated byte string
 */
char *mystrndup (const char *s, size_t n)
{
  size_t len = strnlen (s, n); // length of the source string
  char *size = malloc (len + 1); //size allocated memory size of length of source string +1 for terminator

  if (size== NULL) // if  allocated memory is null
    return NULL;

  size[len] = '\0'; // null termiantor
  return strncpy(size, s, len);
}
