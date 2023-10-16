#..............................................................
# CMakeList.txt : CMake project for CMakeProject1, include source and define
# project specific logic here.
#..............................................................

cmake_minimum_required (VERSION 3.8)

project ("CompilersMake")

# Add source to this project's executable.
add_executable (Compiler
	"Compilers.h" "Compilers.c"
	  
	  
	"Parser.h" "Parser.c" "MainParser.c"
 "Buffer.c" "Buffer.h" "MainBuffer.c" "MainScanner.c" "Scanner.c" "Scanner.h")

# TODO: Add tests and install targets if needed.
