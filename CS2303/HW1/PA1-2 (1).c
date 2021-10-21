// PA1.c Irakli Grigolia

#include <stdio.h>
#include <stdlib.h>

int day;    // which day to print ,monday is 1
int y=2018; // starting year for which we know what the first day of January is 
int newyear; // input year 
  
/*prints out the prompt for the user to type the year  */
void screen(){
    printf("   Monthly CALENDAR  \n");
    printf("Enter what year you wish to see the calendar for: ");
    scanf("%d",&newyear);
       if(newyear >0){
printf("*** CALENDAR for %d ***\n",newyear);}
else {
printf("Warning! you can not type negative year or 0! \n"); exit(0); }
           
} 
/* prints the names of days in a week */
void print(){
     printf("Sun Mon Tue Wed Thu Fri Sat\n");     
} 

/** 
 * checks whether the input year is leap or not 
 * @return 1 if year is leap ,0 if year is not leap.

*/ 
int isleap(int x){
  if (( x % 4 == 0 && x % 100 != 0) || x % 400 == 0){
return 1;}
else return 0;
} 

/**
 * determines the starting day of the year 
 * @param day Represents day of the week
 * @param newyear Represents the input year
 * @return numbers from 1 to 7,which represent days of the week

*/
int firstday(){

    int day=1; //monday is labled as 1
    while(newyear<y){
y--;

   day-=1+isleap(y);
   day=(day+7)%7;

 /*  This loop works for years that are less than 2018 .y=2018 is the starting year and monday is the first day of January 
 loop works while input year is less than y.We know that 365%7==1 so  each  time,day is decreased by one and is  decreased one more time if previous year is leap year
*/
    } 

	
    while(newyear>y){ day+=1+isleap(y);
y++;
     day=(day+7)%7;
/*
	This loop works for years that are greater than y=2018. It checks whether or not the input year is leap and finds the starting day. (monday=1,tuesday=2....sunday=7)
	
*/
    }


    return day;
    
} 

/**
 * finds the number of days for particular month considering whether or not y(year) is leap
 * @param i Represents month
 * @param y Represents  year
 * @return number of days in a month 

*/
int numofdays(int i,int y){ 
	switch (i){

case 0:case 2:case 4:case 6:  case 7:case 9:case 11:

			return 31;

  case 3:case 5:case 8:case 10:

			return 30;
	}
if(isleap(y) && i==1)   return 29;

	           else return 28;
	
}
/**
 * prints out month names and spaces in between
 * @param d Represents number of days in a month
 * @return the number of day next month starts
*/
int printmonth(int y,int i,int day){

     for(int k=0;k<day;k++){printf("   ");
		if(k){
printf(" ");}	
	}
/*
		it prints blank spaces. for example is day is 2(tuesday) it  will print blank space for monday
*/


        int d=numofdays(i,y);

        for(int k=1;k<=d;k++){
/*
		it goes form 1 to number of days in a month ,prints k and prints additional '\n' if all days are already printed 
		
*/
if(day)printf(" ");

printf("%3d",k);
                
                
           day++;
       if(day==7){
     printf("\n") ;              
 day=0;
                }
        }
        
       printf("\n");  printf("\n");

	return day;
} /* prints the names of the month */
void printMonthName(int x){
switch(x){
case 0:printf("January");
	    break;
case 1: printf("February");
            break;
case 2:	printf("March");
	    break;
case 3: printf("April");
	    break;
case 4:printf("May");
	    break;
case 5:printf("June");
	    break;
case 6:printf("July");
	    break;
case 7:printf("August");
	    break;
case 8:printf("September");
	    break;
case 9:printf("October");
	    break;
case 10:printf("November");
	    break;
case 11:printf("December");
	    break;
	}
printf(" %d\n",y);
}

/* prints calendar */
void printCalendar(int y,int day){

for(int i=0;i<12;i++){ // It loops through the year and calls the function printMonth() print()  twelve times, once for each month.

printMonthName(i); print(); day=printmonth(y,i,day);
    }
}
/* executes all other functions  */
int main(void){  
    screen(); day=firstday();  printCalendar(newyear,day);
      
} 
