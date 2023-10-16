//Student name: Adam Di Cioccio
//Student Number: 041019241
//class name: C Language
// Professor(s): Surbhi Bahri

#include <stdio.h> //input output
#include <string.h> //stringLen()
#include <stdbool.h> //boolean
#include <stdlib.h> //library
#include <ctype.h> //digit variations

//main function
int main(void) {
    
    //declare variables
    char key;
    char userInput[80];
    
    //promt user for the message
    printf("Enter the message to decrypt: ");
    //set the input including whitespaces
    scanf("%[^\n]s", userInput);
    //ask user for key
    printf("Enter the key: ");
    scanf("%s", &key);
    //check to see if user entered integer
    if (isdigit(key)) {
        int key1 = (int)(key - '0');
        //check to see if key is in range
        if (key1 > 0 && key1 < 26) {
            //repeat amount of times there is chars
            for (int i = 0; i < strlen(userInput); i++) {
                //if letter is uppercase
                if (isupper(userInput[i])) {
                    //decrpyt using ASCII value shift
                    userInput[i] = ((userInput[i] - 65 - key1) % 26) + 65;
                //if letter is lower case
                } else if (islower(userInput[i])) {
                    //decrpyt using ASCII value shift
                    userInput[i] = ((userInput[i] - 97 - key1) % 26) + 97;
                }

            }
            printf("Decrypted Text -> %s", userInput);

        } else {
            printf("Invalid input");
        }
    } else {
        printf("Invalid input!");
    }
    
}


