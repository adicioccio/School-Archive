//Student name: Adam Di Cioccio
//Student Number: 041019241
//class name: C Language
// Professor(s): Surbhi Bahri

#include <stdio.h>
#include <stdbool.h>

int main () {
    //boolean for main while loop
    bool programQuit = false;

    //main while loop
    while (programQuit == false) {
        //declare vairables
        int userInput, firstDigit = 0;
        int count = 1;
        //ask user for input
        printf("\nPlease enter a phone number: ");
        //set into variable
        scanf("%d", &userInput);
        //show users input
        printf("You entered %d.\n", userInput);

        //calculate the first digit of the users input
        firstDigit = userInput;
        while ((firstDigit > 10) && (firstDigit != 0)) {
            //take off one integer each time
            firstDigit = firstDigit / 10;
            count++;
        }

        if (userInput == 0) {
            //quit the program
            printf("Quitting program...");
            programQuit = true;
        
        } else if (count > 7) {
            //if more than 7 digits
            printf("Invalid input: More than 7 digits");
        
        } else if (count < 7) {
            //if less than 7 digits
            printf("Invalid input: Less than 7 digits");

        } else if (firstDigit == 1) {
            //if number starts with 1
            printf("Invalid central office code: 1");
        
        } else if (firstDigit == 0) {
            //if number starts with 0
            printf("Invalid central office code: 0");
        
        } else {
            //declare variables
            int power = 1;
            int insertDash = 0;

            //extract digits one by one from array
            while(userInput > power)
            power*=10;
            power/=10;
            //keeps repeating until userInput empties
            while(userInput != 0) {
                //declare variables
                int digit = userInput / power;
                //print out digit
                printf("%d", digit);
                
                //after 3 numbers are printed insert the dash
                if(insertDash == 2) {
                    printf("-"); 
                }

                if (digit != 0) {
                    userInput = userInput - digit * power;
                }
                if(power != 1) {
                    power /= 10;
                }
                //add 1 to the dash counter
                insertDash++;
            }
        }
    }
    return 0;
}