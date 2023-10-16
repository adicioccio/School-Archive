# CMakeList.txt : CMake project for Compiler_A12, include source and define
# project specific logic here.
#
cmake_minimum_required (VERSION 3.8)

project ("Compiler_A12")

# Add source to this project's executable.
add_executable (Compiler_A12        "Buffer.c" "Buffer.h" "Compilers.c" "Compilers.h" "MainBuffer.c")

# TODO: Add tests and install targets if needed.
