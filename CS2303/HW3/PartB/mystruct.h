/** mystruct.h
 * @author Mike Ciaraldi
 * Sample structs
*/

// Struct definition:

// Maximum number of characters in an employee name
#define MAX_NAME (99)

struct Employee {
	int birth_year; // Year the employee was born
	int start_year; // When employee started with the company.
	char name[MAX_NAME + 1];
};

// Function prototype(s):
struct Employee *makeEmployee(int birth, int start, const char* name);
void printEmployee(struct Employee *e);
char *randomstring(size_t length);
void printEmployee(struct Employee *e);
struct Employee** alloc(int count);
void structPrint(struct Employee ** pointers,int c);
struct Employee* myshallowcpy(struct Employee** g,int c);
void printPtr(struct Employee* p, int c);
