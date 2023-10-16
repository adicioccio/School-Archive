// PART A
// CST8219 - C++ Programming
// Group: Adam Di Cioccio, Megan Machkouri, Sara Mehari
// @author: Surbhi Bahri

#define _CRT_SECURE_NO_WARNINGS
#define _CRTDBG_MAP_ALLOC	// need this to get the line identification

//includes
#include <crtdbg.h>
#include <stdio.h>
#include <iostream>
#include <string.h>
#include <string>

using namespace std;

// created boolean
typedef enum { 
	FALSE = 0, TRUE 
} BOOL;

// frame struct
struct Frame {
	char* frameName;
	struct Frame* pNext;
};

// animation struct
typedef struct {
	char* animationName;
	struct Frame* frames;
} Animation;

// Forward declarations

void InitAnimation(Animation*); // get animation name and allocate memory

void InsertFrame(Animation*); // Insert frame at start of list

void DeleteFrame(Animation*); // Delete frame at the end of list

void EditFrame(Animation*); // Print message indicating how many frames exist. Search by Index (<=1).

void ReportAnimation(Animation*); // Print Function

void CleanUp(Animation*); // clean up

int main(void) {
	
	// declare variables
	char response;
	BOOL RUNNING = TRUE;
	Animation RG;
	_CrtSetDbgFlag(_CRTDBG_ALLOC_MEM_DF | _CRTDBG_LEAK_CHECK_DF);
	
	// initialize animation
	InitAnimation(&RG);

	// keep the program looping until running is set to false
	while (RUNNING) {

		//print out menu and gather user input using scanf
		printf("MENU\n 1. Insert a Frame at the front\n 2. Delete last Frame\n 3. Edit a Frame\n 4. Report the Animation\n 5. Quit\n"); 
		scanf("%c", &response);

		// menu options (1-5)
		switch (response) {
			case '1': 
				InsertFrame(&RG); 
				break;
			case '2': 
				DeleteFrame(&RG); 
				break;
			case '3':
				EditFrame(&RG); 
				break;
			case '4':
				ReportAnimation(&RG); 
				break;
			case '5':
				printf("Quitting...\n");
				CleanUp(&RG);
				RUNNING = FALSE;  
				break;
			default:
				//if user selects invalid option
				printf("Please enter a valid option\n");
		}
	}
	return 0;
}

// void function that takes in an animation, gets animation name and allocates memory
void InitAnimation(Animation* animation) {
	// initialize name and ask user
	string name;
	cout << "Please enter the Animation Name:" << endl;
	
	// loop until user inputs valid string
	while (!getline(cin, name)) {
		cout << "Error... Please enter Valid Animation Name!";
		cin.clear();
		cin.ignore(256, '\n');
	}

	// set n equal to amount of chars in name
	int n = name.length();
	
	// allocate memory for animation name and the frames
	animation->animationName = (char*)malloc(n);
	animation->frames = (Frame*)malloc(sizeof(Frame*));
	
	// set frames pNext equal to null
	animation->frames->pNext = NULL;
	
	// copy the string from the user input into the animation name
	strcpy(animation->animationName, name.c_str());
	
	// loop thru the animation name characters printing them out
	for (int i = 0; i < n; i++) {
		cout << animation->animationName[i];
	}
	// new line
	cout << endl;
};

// void function that takes in animation and inserts a frame at start of list
void InsertFrame(Animation* animation) {
	// clear input
	getchar();
	
	// allocate a temporary node
	Frame* temp=(Frame*)malloc(sizeof(struct Frame));
	
	// get valid user input and set into variable
	string name;
	cout << "Please enter the name of the frame" << endl;
	while (!getline(cin, name))
	{
		cout << "Error... Please enter Valid Frame Name!";
		cin.clear();
		cin.ignore(256, '\n');
	}

	// set n equal to amount of chars in name
	int n = name.length();
	
	// allocate memory for temp node frame name
	temp->frameName = (char*)malloc(n);
	// copy string from user input into temp node
	strcpy(temp->frameName, name.c_str());
	
	// set the next node of temp equal to the node that was previously at head
	temp->pNext = animation->frames;
	// set the new head of the list equal to temp node
	animation->frames = temp;
	
	// loop thru the frame name characters printing them out
	for (int i = 0; i < n; i++) {
		cout << animation->frames->frameName[i];
	}
	// new line
	cout << endl;


};

// void function that takes in animation and deletes the last frame from the list
void DeleteFrame(Animation* animation) {
	// clear input
	getchar();

	// checks if animation has no frames (equal to NULL)
	if (animation->frames->pNext == NULL) {
		cout << "Animation is Empty" << endl;
		// exit out of delete function as there is nothing to delete
		return;
	}

	// initialize current frame and set to the head of list
	Frame* current = animation->frames;

	// loop thru the list to get to the second last element in list
	while (current->pNext != NULL) {
		if (current->pNext->pNext == NULL) {
			break;	
		}
		current = current->pNext;
	}
	// delete pNext node
	current->pNext = NULL;
	free(current->pNext);
	
}

// void function that takes in animation and prints out all the frames in the given animation
void ReportAnimation(Animation* animation) {
	// clear input
	getchar();

	// checks if animation has no frames (equal to NULL)
	if (animation->frames->pNext == NULL) {
		cout << "Animation is Empty" << endl;
		// exit out of delete function as there is nothing to delete
		return;
	}

	// print out name of animation
	cout << "Animation Name is " << animation->animationName << endl;

	// initialize current frame and set to the head of list
	Frame* current = animation->frames;
	// counter
	int z = 0;

	cout << "Reporting the animation..." << endl;
	// loop thru list and print out frame name
	while (current->pNext != NULL) {
		cout << "Image #" << z <<", frame name = " << current->frameName << endl;
		z++;
		current = current->pNext;
	}
}

// void function that takes in animation and prints message indicating how many frames exist. Search by Index (<=1).
void EditFrame(Animation* animation) {
	// clear input
	getchar();


	// checks if animation has no frames (equal to NULL)
	if (animation->frames->pNext == NULL) {
		cout << "Animation is Empty" << endl;
		// exit out of delete function as there is nothing to delete
		return;
	}

	cout << "Edit a Frame in the Animation" << endl;

	// initialize current frame and set to the head of list
	Frame* current = animation->frames;
	// counter
	int z = 0;
	// input
	int d = -1;

	// set z equal to amount of nodes in list
	while (current->pNext != NULL) {
		z++;
		current = current->pNext;
	}
	// ask user for input
	cout << "There are " << z << " frame(s) in the list. Please specify the index (<= " << z-1 << ") to edit at: " << endl;

	// valid input checker
	while (!(cin >> d) || (d < 0) || (d >= z)) {
		cout << "Please enter a valid index" << endl;
		cin.clear();
		cin.ignore(256, '\n');
	}
	// set current equal to the head of list
	current = animation->frames;
	
	// reset counter
	z = 0;
	// loop until current is set to the target node the user wants to edit
	while (z != d) {
		z++;
		current = current->pNext;
	}
	
	// make sure user selected right node and ask what they want to replace
	cout << "The name of the frame is " << current->frameName << endl;
	cout << "What do you wish to replace it with? " << endl;
	// clear input
	cin.clear();
	cin.ignore(256, '\n');
	string name;
	// check for valid input
	while (!getline(cin, name))
	{
		cout << "Error... Please enter Valid Frame Name!";
		cin.clear();
		cin.ignore(256, '\n');
	}
	
	// set n equal to new frame name characters
	int n = name.length();
	// reallocate the memory for the name
	current->frameName = (char*)realloc(current->frameName, n);
	// copy new name into node
	strcpy(current->frameName, name.c_str());

}

// clean up function on exit
void CleanUp(Animation* animation) {
	// initialize current frame and set to the head of list
	Frame* current = animation->frames;
	Frame* temp;
	// set z equal to amount of nodes in list
	while (current->pNext != NULL) {
		temp = current;
		current = current->pNext;
		free(temp);
		cout << "DELETED" << endl;
		
	}
	free(animation->animationName);
}
