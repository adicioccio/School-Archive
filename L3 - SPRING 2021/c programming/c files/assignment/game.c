#include "header.h"

int printRoll(rollnum, dice1, dice2, totalroll) {
    printf("  %d           %d          %d          %d\n", rollnum, dice1, dice2, totalroll);
}

int rollDice(void) {
    roll = (rand() % 6) + 1;
    return roll;
}

int playGame() {
    programQuit = false;
    balance = 50;
    
    while (programQuit == false) {
        betAmount = 0;
        
        loop = false;
        while (loop == false) {
            printf("Would you like to bet? [y/n]\n>");
            
            input = fgetc(stdin);

            if (input == 'y' && isalpha(input)) {
                bet = true;
                i = getchar();
                loop = true;
            } else if (input == 'n' && isalpha(input)) {
                bet = false;
                i = getchar();
                loop = true;
            } else {
                printf("Invalid input.\n");
                while (isalpha(input) || isdigit(input)) {
                    input = getchar();
                }
            }
        }

        if (bet == true) {
            /*get bills by dividing balance by 5*/
            bills = balance / 5;
            
            /*print out betting menu*/
            printf("BETTING MODE: ON\n");
            printf("-----\nYou have $%d. (%dx $5 bills)\n", balance, bills);
            
            /*ask user how much they want to bet*/
            loop = false;
            while (loop == false) {
                if (bills == 0) {
                    /*user has ran out of money*/
                    printf("Bankrupt ;(\n");
                    break;
                } else {
                    /*user has funds greater than 0*/
                    printf("How many bills would you like to bet? (1 - %d)\n>", bills);
                }
                
                /*only accept integer input from user*/
                if (scanf("%2d", &betAmount) != 1) {
                    while ((getchar()) != '\n');
                    continue;
                }

                if (betAmount > 0 && betAmount <= bills) {
                    /*correct input from user*/
                    i = getchar();
                    loop = true;
                } else if (betAmount < 0) {
                    /*if user enters negative integer*/
                    printf("Please enter a positive number.\n");
                } else if (betAmount > bills) {
                    /*if user bets more than they have*/
                    printf("Insuffecient funds.\n");
                }
            }
        
        } else if (bet == false) {
           /*if user did not select betting mode*/
           printf("BETTING MODE: OFF\n");
        }

        printf("----- ROLL THE DICE GAME. [ENTER] TO BEGIN OR [Q] to quit. -----\n");
        
        input = fgetc(stdin);

        if (input == 'q') {
            printf("-----\nWINS: %d | LOSES: %d\n", wins, loses);
            printf("Quitting the program...\n");
            return EXIT_SUCCESS;
        
        } else if (input == 0x0A) {
            printf("----------------------------------------------------------------\n");
            printf("  ROLL NUM    DICE #1    DICE #2    TOTAL ROLL    POINT MATCH   \n");
            printf("----------------------------------------------------------------\n");
            
          
            rollnum = 0;

            srand(time(NULL));

            CONT:
            rollnum++;

            dice1 = rollDice();
            dice2 = rollDice();
            totalroll = dice1 + dice2;

            printRoll(rollnum, dice1, dice2, totalroll);

            switch(totalroll) {
                case 11:
                case 7:
                    printf("\nGAME WON\n");
                    game = WON;
                    wins++;
                    balance = balance + (betAmount*15);
                    break;
                case 2:
                case 3:
                case 12:
                    printf("\nGAME LOST\n");
                    game = LOST;
                    loses++;
                    balance = balance - (betAmount*5);
                    break;
                default:
                    goto CONT;
                    break;
            }


            printf("----------------------------------------------------------------\n");

        } else {
            printf("Wrong input.\n");
            input = getchar();
        }
    }
}