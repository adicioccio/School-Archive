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
Function Name: compare 
Purpose: compares two cards based on face then suit
Function in parameters: void
Function out parameter: true or false
Version: 1 
Author: Adam Di Cioccio (041019241) and Mike Zhigun(040999914)
*****************************************************************************/
bool compare(){
    /*setting all the values of Jack,King,Queen,Ace,Ten*/
    int A = 14;
    int T = 10;
    int J = 11;
    int Q = 12;
    int K = 13;
    
    /*setting all the values for Hearts,Diamonds,Clubs,Spades*/
    int S = 4;
    int H = 3;
    int D = 2;
    int C = 1;
    
    /*checking if the face you drew if higher value*/
    if (deck[i].face > deck[i+1].face) {
        printf("You Win! Your card face had a higher value.\n");
        return true;
    
    /*checking if the face you drew is lower value*/
    } else if (deck[i].face < deck[i+1].face) {
        printf ("You lose! Your card face had a lower value.\n");
        return false;

    /*checking if the face values are equal*/
    } else if(deck[i].face == deck[i+1].face) {
        /*checking if the suit of the player is higher then the one the machine drew*/
        if(deck[i].suit > deck[i+1].suit ) {
            printf ("You Win! Your faces were equal but your suit is superior.\n");
            return true;
        
        /*checking if the suit of the player is lower then the one the machine drew */
        } else if (deck[i].suit < deck[i+1].suit ) {
            printf ("You lose! Your faces were equal but your suit is lower.\n");
            return false;
        }
    
    /*this should never happen. checking if the card are identical*/
    } else {
        printf("Error.");
    }
    return false;
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
    
    /*set the deck elements face and suit for the every deck index*/
    for (i = 0; i < 52; i++) {
        deck[i].face = num[i % 13];
        deck[i].suit = name[i % 4];
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

    /*loop thru deck of cards*/
    for (i = 0; i < 52; i++) {
        /*draw users card, set into variables, display it*/
        char face1 = deck[i].face;
        char suit1 = deck[i].suit;
        printf("You draw a ");
        display(face1, suit1);
        printf("\n");
        
        /*draw opponents card, set into variables, display it*/
        char face2 = deck[i+1].face;
        char suit2 = deck[i+1].suit;
        printf("Opponent draws a ");
        display(face2, suit2);
        printf("\n");

        /*call the compare function that returns true or false and add to counters accordinly*/
        if (compare() == true) {
            /*game won*/
            win++;
            game = WON;
        } else {
            /*game lost*/
            lose++;
            game = LOST;
        }

        printf("----------------\n");

        /*go to next set of cards (no reuse of cards)*/
        i++;

    }
    
    /*end the deck - print out the final message*/
    printf("  END OF GAME!  \n");
    printf("    WINS:%d\n", win);
    printf("    LOSES:%d\n", lose);
    printf("----------------\n");

    /*return 1*/
    return 1;
}