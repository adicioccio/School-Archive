/*  
* Title: Lab Assessment 4 and 6
* Course: CST8234 C Language 
* @Author: Adam Di Cioccio (041019241) and Mike Zhigun(040999914)
* Lab Section: 011 
* Professor: Surbhi Bahri 
* Due date: 11/29/21
* Submission date: 11/26/21  
*/

/*include header*/
#include "header.h"

/*define a struct for a playing card*/
typedef struct {
    char face;
    char suit;
} card;

/*create a deck with 52 cards*/
card deck[52];
/*create temp card for swap*/
card temp;

/*declare two arrays with suits and faces*/
char name[] = {'H', 'D', 'C', 'S'};
char num[] = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

/***************************************************************************** 
Function Name: display 
Purpose: takes in card symbols and prints in full
Function in parameters: card face, card suit 
Function out parameter: 1
Version: 1 
Author: Adam Di Cioccio (041019241) and Mike Zhigun(040999914)
*****************************************************************************/
int display(char face, char suit) {
    switch(face) {
        case 'A':
            printf("Ace");
            break;
        case '2':
            printf("Two");
            break;
        case '3':
            printf("Three");
            break;
        case '4':
            printf("Four");
            break;
        case '5':
            printf("Five");
            break;
        case '6':
            printf("Six");
            break;
        case '7':
            printf("Seven");
            break;
        case '8':
            printf("Eight");
            break;
        case '9':
            printf("Nine");
            break;
        case 'T':
            printf("Ten");
            break;
        case 'J':
            printf("Jack");
            break;
        case 'Q':
            printf("Queen");
            break;
        case 'K':
            printf("King");
            break;
        default:
            printf("Invalid");
            break;
    }

    printf(" of ");

    switch(suit) {
        case 'H':
            printf("Hearts");
            break;
        case 'D':
            printf("Diamonds");
            break;
        case 'C':
            printf("Clubs");
            break;
        case 'S':
            printf("Spades");
            break;
        
    }
    
    return 1;            

}

/***************************************************************************** 
Function Name: playGame 
Purpose: runs the entire game 
Function in parameters: void 
Function out parameter: 1
Version: 1 
Author: Adam Di Cioccio (041019241) and Mike Zhigun(040999914)
*****************************************************************************/
int playGame() {
    /*fix infinite loop*/
    srand(time(NULL));
    
    /*header for generated deck*/
    printf("----------------\n");
    printf(" GENERATED DECK \n");
    printf("----------------\n");
    
    /*set the deck elements face and suit for the every deck index*/
    for (i = 0; i < 52; i++) {
        deck[i].face = num[i % 13];
        deck[i].suit = name[i % 4];
    }
    
    /*call the display function in order to display card at index*/
    for (i = 0; i < 52; i++) {
        char face2 = deck[i].face;
        char suit2 = deck[i].suit;
        
        display(face2, suit2);
        printf("\n");
    }

    /*header for shuffled deck*/
    printf("----------------\n");
    printf(" SHUFFLED  DECK \n");
    printf("----------------\n");

    /*randomize order of the deck using temp card for the swap*/
    for (i = 0; i < 52; i++) {
        j = rand() % 52;
        
        temp = deck[i];
        deck[i] = deck[j];
        deck[j] = temp;
    }

    /*call the display function in order to display card at index*/
    for (i = 0; i < 52; i++) {
        char face2 = deck[i].face;
        char suit2 = deck[i].suit;
        
        display(face2, suit2);
        printf("\n");
    }
    
    /*return 1*/
    return 1;
}