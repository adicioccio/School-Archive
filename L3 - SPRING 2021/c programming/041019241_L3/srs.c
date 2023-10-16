/*imports*/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

/*
* Title: Lab Assessment #3 - Student Registration System * Course: CST8234 C Language
* @Author: <<< Adam Di Cioccio (041019241) >>>
* Lab Section: 011
* Professor: Surbhi Bahri
* Due date: 10/19/21
* Submission date: 10/19/21
*/

/*declare the functions*/
void registrationTable(int *students,char *courses[8], int **table, int numOfStudents, int numOfCourses);

/*main*/
int main(void) {
    /*declare variables*/
    int *students;
    char **courses;
    int **table;
    int numOfStudents = 0;
    int numOfCourses, id;
    /*print header*/
    printf("--- Welcome to the Student Register System (SRS) ---\n\n");
    /*while loop that checks for valid input*/
    while (numOfStudents == 0) {
        /*ask user for input*/
        printf("How many students would you like to enter:\n");
        scanf("%d", &numOfStudents);

        if (numOfStudents > 0) {
            /*valid input*/
        } else if (numOfStudents < 0) {
            /*negative input*/
            printf("Please enter a positive integer.\n");
            numOfStudents = 0;
        } else {
            /*not integer*/
            printf("Please enter a valid integer.\n");
            while (getchar() != '\n');
        }
    }
    /*allocate memory for size user inputted*/
    students = (int*) malloc(sizeof(int) * numOfStudents);
    /*get user input for each students id*/
    for (int i = 0; i < numOfStudents; i++) {
        printf("Enter student %d's id:\n", i+1);
        scanf("%d", &id);
        students[i] = id;
    }
    /*print out students*/
    for (int i = 0; i < numOfStudents; i++) {
        printf("Student -> %d\n", students[i]);
    }
    /*while loop that checks for valid input*/
    while (numOfCourses == 0) {
        /*ask user for input*/
        printf("How many courses would you like to enter:\n");
        scanf("%d", &numOfCourses);

        if (numOfCourses > 0) {
            /*valid input*/
        } else if (numOfCourses < 0) {
            /*negative integer*/
            printf("Please enter a positive integer.\n");
            numOfCourses = 0;
        } else {
            /*not integer*/
            printf("Please enter a valid integer.\n");
            while (getchar() != '\n');
        }
    }
    /*allocate memory for size user inputted*/
    courses = (char**) malloc(sizeof(char) * numOfCourses);
    /*get course codes from user*/
    for (int i = 0; i < numOfCourses; i++) {
        /*allocate max size for each course code*/
        courses[i] = (char*) malloc(sizeof(char) * 8);
        /*ask user for input*/
        printf("Enter course %d's course code:\n", i+1);
        scanf(" %7c",courses[i]);
    }
    /*print out course codes*/
    for (int i = 0; i < numOfCourses; i++) {
        printf("Course -> %s\n", courses[i]);
    }
    /*allocate memory for table*/
    table = (int**)malloc(sizeof(int*) * numOfStudents);
    
    for(int i = 0; i < numOfStudents; i++) {
        /*allocate courses for student*/
        table[i] = (int*)malloc(sizeof(int) * numOfCourses);
        for(int j = 0; j < numOfCourses; j++) 
            table[i][j] = 0;
    }
    /*while loop that keeps looping menu until 4 is entered*/
    bool programQuit = false;
    while (programQuit == false) {
        /*declare variables*/
        int userInput;
        /*print out menu header and get users input*/
        printf("---------- MENU ----------\nPlease choose of the following...\n1. Register student into a course.\n2. Withdraw student from a course.\n3. Display registration table.\n4. Exit program.\n");
        scanf("\n%d", &userInput);
        /*register new student*/
        if (userInput == 1) {
            printf("1");
        /*withdraw a student from course*/
        } else if (userInput == 2) {
            printf("2");
        /*display the registation table*/
        } else if (userInput == 3) {
            registrationTable(students, courses, table, numOfStudents, numOfCourses);
        /*quit the program*/
        } else if (userInput == 4) {
            printf("Quitting...");
            programQuit = true;
        /*integer but not right menu option*/
        } else {
            printf("Wrong input! Please try again.\n");
        }
    }
    /*free up memory*/
    free(students);
    free(courses);
    free(table);
}
/*
* Function Name: registrationTable
* Purpose: display the registration table
* Function in parameters: students array, courses array, table multi dimensional array, number of students and number of courses
* Function out parameter: EXIT_SUCCESS
* Version: 1
* Author: Adam Di Cioccio
*/
void registrationTable (int *students,char *courses[8], int **table, int numOfStudents, int numOfCourses) {
    /*header*/
    printf("###################### REGISTRATION TABLE ######################\n");
    /*student id header*/
    printf("%-10s", "Student(ID)");
    /*course codes in header*/
    for(int i = 0; i < numOfCourses; i++) {
       printf("\t%-10s", courses[i]);
    }
    /*students*/
    for(int i = 0; i < numOfStudents; i++) {
        /*index which is student id*/
        printf("\n%-10d ", students[i]);
       /*print out yes or no if student is taking course*/
        for(int j = 0; j < numOfCourses; j++) {
            /*if value was set to 1*/
            if(table[i][j] == 1) {
                /*yes*/
                printf("\t%-10s", "[Y]");
            } else {
                /*no*/
                printf("\t%-10s", "[N]");
            }    
        }
    }
    /*new line*/
    printf("\n");
}
