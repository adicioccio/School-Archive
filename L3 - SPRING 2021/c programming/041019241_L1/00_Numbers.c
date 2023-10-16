//Student name: Adam Di Cioccio
//Student Number: 041019241
//class name: C Language
// Professor(s): Surbhi Bahri

#include <stdio.h>
//main code
int main () {

    //for loop that repeats it self 100 times
    for (int i = 1; i <= 100; i++) {
        
        //print out the index
        printf("%d", i);
        
        //create new variable for index
        int index = i;

        //if there is no remainder when divided by 3 and 5
        if ((index % 3 ==0) && (index % 5 == 0)){
            printf(" -> This is a multiple of 3 and 5.");
        //if there is no remainder when divided by 3
        }else if (index % 3 == 0) {
            printf(" -> This is a multiple of 3.");
        //if there is no remainder when divided by 5
        } else if (index % 5 ==0) {
            printf(" -> This is a multiple of 5.");
        }
        //new line
        printf("\n");
    }
    return 0;
}