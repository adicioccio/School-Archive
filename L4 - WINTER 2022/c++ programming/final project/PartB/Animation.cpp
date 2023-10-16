// PART B
// CST8219 - C++ Programming
// Group: Adam Di Cioccio, Megan Machkouri, Sara Mehari
//@author: Surbhi Bahri

// includes
#include "animationPart2.h"
#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

// animation constructor
Animation::Animation() {
	// declare variables
	char* fName;
	string name;
	
	// ask user for input
	cout << "Please enter the Animation Name" << endl;
	// loop until valid input
	while (!getline(cin, name)) {
		cout << "Error... Please enter Valid Animation Name!";
		cin.clear();
		cin.ignore(256, '\n');
	}
	// get total characters in users input
	int n = name.length();
	// allocate bytes of memory based on length of chars user entered
	this->animationName = (char*)malloc(n);
	// initialize frame node at head
	this->frames = new Frame();
	// initialize next node in list to null
	this->frames->GetpNext() = NULL;	
	// copy name into animation name
	strcpy(animationName, name.c_str());
	// print out animation name character by character
	for (int i = 0; i < n; i++) {
		cout << animationName[i];
	}
}

// animation deconstructor
Animation::~Animation() {
	// set temporary node of list head to current
	Frame* current = frames;
	// loop through entire list
	while (current->GetFrameName() != NULL) {
		// create temp node and set it equal to current
		Frame* tmp = current;
		// set current to next node
		current = current->GetpNext();
		// free frame name memory
		free(tmp->GetFrameName());
		// delete temp node
		delete tmp;
	}
	free(animationName);
	cout << "In deconstructor" << endl;
}


// insert frame method that inserts frame at head
void Animation::InsertFrame() {
	// clear input
	getchar();
	// create new temp node
	Frame* temp = new Frame();

	// get user input
	string name;
	cout << "Please enter the name of the frame" << endl;
	// loop and check if valid input
	while (!getline(cin, name)) {
		cout << "Error... Please enter Valid Frame Name!";
		cin.clear();
		cin.ignore(256, '\n');
	}
	
	//set n equal to characters of user input
	int n = name.length();
	// allocate memory in temp node
	temp->GetFrameName() = (char*)malloc(n+1);
	// copy user input name into temp node frame name
	strcpy(temp->GetFrameName(), name.c_str());
	// set temp nodes next node equal to the head of the animations frames (insert it at start)
	temp->GetpNext() = frames;
	// set new head of animation to temp
	frames = temp;
}

// delete frame method that deletes frame at tail
void Animation::DeleteFrame() {
	// clear input
	getchar();
	// check if animation is empty
	if (frames->GetFrameName() == NULL) {
		cout << "Animation is Empty" << endl;
		// exit as animation is empty
		return;
	}

	// set current frame equal to head of list
	Frame* current = frames;
	// if list is empty
	if (current->GetpNext() == NULL) {
		delete current;
	}

	// loop thru the list until it gets to second last
	while (current->GetpNext() != NULL) {
		if (current->GetpNext()->GetpNext() == NULL) {
			break;
		}
		current = current->GetpNext();
	}
	// set last node equal to NULL
	current->GetpNext() = NULL;
	// free memory for current frame name
	free(current->GetFrameName());
	// delete pNext from memory
	delete current->GetpNext();
}

// report animation method that prints out all frames in animation
void Animation::ReportAnimation() {
	//clear input
	getchar();

	// check if animation is empty
	if (frames->GetFrameName() == NULL) {
		cout << "Animation is Empty" << endl;
		// exit as animation is empty
		return;
	}

	// print animation name
	cout << "Animation Name is " << animationName << endl;

	// set current equal to animation head
	Frame* current = frames;
	// counter
	int z = 0;
	cout << "Report the animation" << endl;
	// loop thru list and print out all frames
	while (current->GetpNext() != NULL) {
		cout << "Image #" << z << ", file name =" << current->GetFrameName() << endl;
		z++;
		current = current->GetpNext();
	}
}

// edit frame method that allows user to edit the name of a frame
void Animation::EditFrame() {
	// clear input
	getchar();

	cout << "Edit a Frame in the Animation" << endl;

	// set current frame equal to head of list
	Frame* current = frames;
	//counter and user input
	int z = 0;
	int d = -1;

	// set counter variable equal to nodes in the list
	while (current->GetpNext() != NULL) {
		z++;
		current = current->GetpNext();
	}

	// if list is empty return to main menu
	if ((z == 0)) {
		cout << "List is Empty nothing to Edit Here... " << endl;
		return;
	}

	// tell user how many indexes there are and what they can edit
	cout << "There are " << z << " frame(s) in the list. Please specify the index (<= " << z << ") to edit at: " << endl;

	// take in an integer within valid range of list
	while (!(cin >> d) || (d < 0) || (d > z)) {
		cout << "Please enter a valid index" << endl;
		cin.clear();
		cin.ignore(256, '\n');
	}
	// reset current back to head
	current = frames;
	// reset counter
	z = 0;
	// loop until current reaches correct node to edit
	while (z != d) {
		z++;
		current = current->GetpNext();
	}
	// ask user what they would like to replace frame name with
	cout << "The name of the frame is " << current->GetFrameName() << endl;
	cout << "What do you wish to replace it with? " << endl;
	// clera input
	cin.clear();
	cin.ignore(256, '\n');
	
	// loop until user gives valid name
	string name;
	while (!getline(cin, name)){
		cout << "Error... Please enter Valid Frame Name!";
		cin.clear();
		cin.ignore(256, '\n');
	}
	
	//set n equal to characters of user input
	int n = name.length();
	// reallocate the frame name memory to new user input
	current->GetFrameName() = (char*)realloc(current->GetFrameName(), n);
	// copy name into the frame name of selected node
	strcpy(current->GetFrameName(), name.c_str());

}


