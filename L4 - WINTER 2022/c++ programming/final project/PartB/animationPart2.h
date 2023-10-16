// PART B
// CST8219 - C++ Programming
// Group: Adam Di Cioccio, Megan Machkouri, Sara Mehari
//@author: Surbhi Bahri
#include "framePart2.h"
#pragma once

// animation class
class Animation {
	// private animation variables
	char* animationName;
	Frame* frames;
public:
	// public animation method declarations
	Animation();
	~Animation();
	void InsertFrame();
	void EditFrame();
	void DeleteFrame();
	void ReportAnimation();
};
