/*imports*/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#include <time.h>

/*macros*/
#define MAX_NAME_LENGTH 100 
#define MAX_JOB_LENGTH 100

/* Employee structure*/
typedef struct Employee {
/* Employee details */
char *name;
char gender;
int age;
char *job;
/* pointers to next employee structures in the linked list*/
struct Employee *next; 
} Employee;

/*head of list*/
Employee *head = NULL;

/*declare variables*/
int input;
int choice;
char *eName;
char eGender;
int eAge;
char *eJob;
