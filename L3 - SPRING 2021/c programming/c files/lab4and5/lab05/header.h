/*  
* Title: Lab Assessment 4 and 6
* Course: CST8234 C Language 
* @Author: Adam Di Cioccio (041019241) and Mike Zhigun(040999914)
* Lab Section: 011 
* Professor: Surbhi Bahri 
* Due date: 11/29/21
* Submission date: 11/26/21  
*/

/*imports*/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#include <time.h>

/*macros*/
#define WON 1
#define LOST 0

/*functions*/
int display(char face, char suit);
int playGame();
bool compare();

/*variables*/
char *input;
int i, j;
int game;
int win;
int lose;

