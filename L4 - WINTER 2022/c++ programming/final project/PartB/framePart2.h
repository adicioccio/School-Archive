// PART B
// CST8219 - C++ Programming
// Group: Adam Di Cioccio, Megan Machkouri, Sara Mehari
//@author: Surbhi Bahri

#pragma once

// frame class
class Frame {
	// private frame variables
	char* frameName;
	Frame* pNext;
public:
	// public frame method declarations
	Frame();
	~Frame();
	char*& GetFrameName() { return frameName; };
	Frame*& GetpNext() { return pNext; };
};
