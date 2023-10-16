; assignment2B.asm

; Author: Adam Di Cioccio
; StudentNum: 041019241
; Date: Nov 11, 2021

; Purpose: Grading system made in assembly language.

; declare constants
NINETY        equ        90
EIGHTY        equ        80
SEVENTY        equ        70
SIXTY        equ        60

        ; store marks.txt at memory address 1000
        org        $1000

; get input fro marks.txt file and store into marks
Marks
#include        Marks.txt
EndofMarks

        ; store Grades array from marks.txt into memory
        org        $1030

Grades        ds        EndofMarks-Marks

        ; start program
        org        $2000
        ; pointer x that points to marks.txt memory address
        ldx        #Marks
        ; pointer y that goes to grades memory address
        ldy        #Grades

; load accumulator A with value(increment x each call calling next value)
Goto        ldaa        1,x+
        ; compare value to constant 90
        cmpa        #NINETY
        ; check if value (branch) is higher or same then call nine
	bhs        nine

        ; compare value to constant 80
        cmpa        #EIGHTY
        ; check if value (branch) is higher or same then call eight
	bhs     eight
        
        ; compare value to constant 70
        cmpa        #SEVENTY
        ; check if value (branch) is higher or same then call seven
	bhs     seven

        ; compare value to constant 60
        cmpa        #SIXTY
        ; check if value (branch) is higher or same then call six
	bhs     six

        ; compare value to constant 60
        cmpa        #SIXTY
        ; check if value (branch) is lower then call fail
	blo     fail

; load char 'A' into accumulator B
nine        ldab        #'A'
        ; jump to Read memory address
	bra        Read

; load char 'B' into accumulator B
eight        ldab        #'B'
        ; jump to Read memory address
	bra        Read

; load char 'C' into accumulator B
seven        ldab        #'C'
        ; jump to Read memory address
	bra        Read

; load char 'D' into accumulator B
six        ldab        #'D'
        ; jump to Read memory address
	bra        Read

; load char 'F' into accumulator B
fail        ldab        #'F'
        ; jump to Read memory address
	bra        Read

; read memory address
Read        stab        1,y+
        cpx        #EndofMarks
        ; go to 'Goto' / restart loop
	bne        Goto
        ; end program
	swi
        end