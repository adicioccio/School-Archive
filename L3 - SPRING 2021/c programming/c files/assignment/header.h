/*imports*/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
#include <time.h>
#define WON 1
#define LOST 0

int printRoll();
int rollDice();
int playGame();

bool programQuit;
int game;
int wins;
int loses;
int balance;
int i;

char input;
int betAmount;
bool bet;

int bills;
bool loop;

int dice1;
int dice2;
int totalroll;
int rollnum;

int roll;