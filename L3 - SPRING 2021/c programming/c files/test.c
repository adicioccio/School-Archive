// C program to simulate student registration system
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// function declaration
void registration(int **registration_table,int *studentId,char *courseId[8], int sid, char cid[8], int num_student, int num_course );
void withdraw(int **registration_table,int *studentId,char *courseId[8], int sid, char cid[8],int num_student, int num_course );
void display(int **registration_table,int *studentId,char *courseId[8], int sid, char cid[8],int num_student, int num_course );

int main(void) {

   int *studentId = NULL;
   char **courseId = NULL;
   int **registration_table = NULL;

   int num_course, num_student;
   int choice;
   int i,j;

   int sid;               /// 
   char cid[8];           ///

   printf("\nEnter number of students : ");
   fflush(stdout);
   scanf("%d",&num_student);
   studentId = (int*) malloc(sizeof(int)*num_student);
   if(studentId != NULL)
   {
       for(i=0;i<num_student;i++)
       {
           printf("\tEnter student ID for student %d : ",i+1);
           fflush(stdout);
           scanf("%d",&studentId[i]);
       }

       printf("\nEnter number of courses offered : ");
       fflush(stdout);
       scanf("%d",&num_course);

       courseId = (char**)malloc(sizeof(char)*num_course);
       if(courseId != NULL){
           for(i=0;i<num_course;i++)
           {
               courseId[i] = (char*)malloc(sizeof(char)*8);
               printf("\tEnter name of course %d : ",(i+1));
               fflush(stdout);
               scanf(" %7c",courseId[i]);
           }

           registration_table = (int**)malloc(num_student*sizeof(int*));
           for(i=0;i<num_student;i++)
           {
               registration_table[i] = (int*)malloc(num_course*sizeof(int));
               for(j=0;j<num_course;j++)
                   registration_table[i][j] = 0;
           }

           // loop that continues till the user exits the application
           while(choice != 4)
           {
               printf("\n-----------------Main Menu----------------");
               printf("\n1. Register a student in a course");
               printf("\n2. Withdraw a student from a course");
               printf("\n3. Display registration table");
               printf("\n4. Exit");
               printf("\n\nEnter an option : ");
               fflush(stdout);
               scanf(" %d",&choice);

               if(choice == 1)
               {
                   printf("\nEnter student id : ");
                   fflush(stdout);
                   scanf(" %d",&sid);
                   printf("Enter course code : ");
                   fflush(stdout);
                   scanf(" %7c",cid);
                   registration(registration_table,studentId,courseId, sid, cid, num_student, num_course );

               }else if(choice == 2)
               {
                   printf("\nEnter student id : ");
                   fflush(stdout);
                   scanf(" %d",&sid);
                   printf("Enter course code : ");
                   fflush(stdout);
                   scanf(" %7c",cid);
                   withdraw(registration_table,studentId,courseId, sid, cid, num_student, num_course );

               }else if(choice ==3)
               {
                   display(registration_table,studentId,courseId, sid, cid, num_student, num_course );
               }

           }
       }

   }


   if(studentId != NULL)
       free(studentId);
   if(courseId != NULL)
       free(courseId);

   if(registration_table != NULL)
   {
       for(i=0;i<num_student;i++)
           free(registration_table[i]);

       free(registration_table);
   }


   return EXIT_SUCCESS;
}


// function that register a student for a given course
void registration(int **registration_table,int *studentId,char *courseId[8], int sid, char cid[8], int num_student, int num_course )
{
   int s_index = -1, c_index = -1;
   int i;

   for(i=0;i<num_student;i++)
   {   if(studentId[i] == sid)
       {
           s_index = i;
           break;
       }
   }

   for(i=0;i<num_course;i++)
   {
       if(strcmp(cid,courseId[i]) == 0)
       {
           c_index = i;
           break;
       }
   }

   if(s_index != -1 && c_index != -1)
   {
       registration_table[s_index][c_index] = 1;
   }
}

// function that withdraw a student from a given course
void withdraw(int **registration_table,int *studentId,char *courseId[8], int sid, char cid[8],int num_student, int num_course )
{
   int s_index = -1, c_index = -1;
   int i;

   for(i=0;i<num_student;i++)
   {   if(studentId[i] == sid)
       {
           s_index = i;
           break;
       }
   }

   for(i=0;i<num_course;i++)
   {
       if(strcmp(cid,courseId[i]) == 0)
       {
           c_index = i;
           break;
       }
   }

   if(s_index != -1 && c_index != -1)
   {
       registration_table[s_index][c_index] = 0;
   }
}

// function that displays the registration table
void display(int **registration_table,int *studentId,char *courseId[8], int sid, char cid[8],int num_student, int num_course )
{
   int i,j;
   printf("\n***************** registration table ************************");
   printf("\n\t%-20s|","Student Id");
   for(i=0;i<num_course;i++)
   {
       printf("%-10s|",courseId[i]);
   }

   for(i=0;i<num_student;i++)
   {
       printf("\n\t%-20d ",studentId[i]);
       for(j=0;j<num_course;j++)
       {
           if(registration_table[i][j] == 1)
               printf("%-12s"," Yes");
           else
               printf("%-12s"," No");
       }
   }

   printf("\n");
}