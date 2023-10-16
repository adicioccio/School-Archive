; Grades.asm
; Assignment 2B
; Author:               Adam
; Sudent Number:        041006277
; Date:                 11 Nov 2021
; purpose:              Assignment 2B
NINETY        equ        90              ; Constant variables
EIGHTY        equ        80
SEVENTY equ        70
SIXTY        equ        60
        org        $1000
        
Marks
#include        Marks.txt       ; Get the data from the text file called Marks
EndMarks         ; org cannot have comments
        org        $1030
        
GradeA        ds        EndMarks-Marks
        org        $2000
        ldx        #Marks          ; pointer x gets set to the start of the Marks array
        ldy        #GradeA         ; pointer y gets set to memory that stores the result
        
Loop        ldaa        1,x+            ; load register with pointer, then post-increment x by 1
        cmpa        #NINETY          ; is it 90?
        bhs        aa              ; if aa is higher or the same as
        cmpa        #EIGHTY          ; is it 80?
        bhs        bb              ; if bb is higher or the same as
        cmpa        #SEVENTY         ; is it 70?
        bhs        cc              ; if cc is higher or the same as
        cmpa        #SIXTY           ; is it 60?
        bhs        dd              ; if dd is higher or the same as
        cmpa        #SIXTY           ; is it 60?
        blo        ff              ; if ff is below
        
aa        ldab        #'A'
        bra        Read
bb        ldab        #'B'
        bra        Read
cc        ldab        #'C'
        bra        Read
dd        ldab        #'D'
        bra        Read
ff      ldab        #'F'
        bra        Read
        
Read        stab        1,y+            ; increment b
        cpx        #EndMarks
        bne        Loop            ; go go back to Read (line 33)
        swi                             ; program quit
        end