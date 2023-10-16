#..............................................................
# CMakeList.txt : CMake project for CMakeProject1, include source and define
# project specific logic here.
#..............................................................

cmake_minimum_required (VERSION 3.8)

project ("Lab2C++")

# Add source to this project's executable.
add_executable (Lab2C++
	"main.cpp"	"Vehicle.cpp"
	"Vehicle.h"
)


