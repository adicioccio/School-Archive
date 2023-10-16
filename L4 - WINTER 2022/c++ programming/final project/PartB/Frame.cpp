// PART B
// CST8219 - C++ Programming
// Group: Adam Di Cioccio, Megan Machkouri, Sara Mehari
//@author: Surbhi Bahri

// includes
#include "framePart2.h"
#include <stdio.h>
#include <string.h>
#include <iostream>
#include <string>

using namespace std;

// frame constructor
Frame::Frame() {
	this->frameName = NULL;
	this->pNext = NULL;
}

// frame deconstructor
Frame::~Frame() {
	cout << "In frame deconstructor" << endl;
}
