#..............................................................
# CMakeList.txt : CMake project for CMakeProject1, include source and define
# project specific logic here.
#..............................................................

cmake_minimum_required (VERSION 3.8)

project ("Lab5")

# Add source to this project's executable.
add_library (Lab5 SHARED
	"main.cpp"	"Lab5.h"
)

target_include_directories(Lab5 PRIVATE
 "/Library/Java/JavaVirtualMachines/jdk1.8.0_301.jdk/Contents/Home/include"
   "/Library/Java/JavaVirtualMachines/jdk1.8.0_301.jdk/Contents/Home/include/darwin"
)


