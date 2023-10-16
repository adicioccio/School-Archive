; GradesII.asm
;
; Author: Adam Di Cioccio
; Course: CST8216
; Student Number: 041019241
; Date: Nov 17, 2021
;
; Purpose:              To Tally up the number of As, Bs, Cs, Ds and Fs
;                       from a Grades Array as per 21F Flowchart for GradesII
;                       which uses a Nested-IF structure

        org        $1000             ; as per assignment instructions
Grades
#include Grades.txt     ; Grades file supplied for assignment
End_Grades

; Expected Result

;
        org     $1020   ; store counters at memory address 1020
countA  ds      1       ; counter for 'A'
countB  ds      1       ; counter for 'B'
countC  ds      1       ; counter for 'C'
countD  ds      1       ; counter for 'D'
countF  ds      1       ; counter for 'F'

        org     $2000   ; start program at memory address 2000
        ldx     #Grades ; load into x the Grades array
        lds     #$2000  ; initialize stack pointer

Loop    ldaa    1,x+    ; goes to next value in Grades everytime looped

        cmpa    #$41    ; compare the value to ASCII 'A'
        beq     aa      ; if it is equal call 'aa'
        
        cmpa    #$42    ; compare the value to ASCII 'B'
        beq     bb      ; if it is equal call 'bb'
        
        cmpa    #$43    ; compare the value to ASCII 'C'
        beq     cc      ; if it is equal call 'cc'
        
        cmpa    #$44    ; compare the value to ASCII 'D'
        beq     dd      ; if it is equal call 'dd'
        
        cmpa    #$46    ; compare the value to ASCII 'F'
        beq     ff      ; if it is equal call 'ff'

aa      ldab    countA  ; 'aa' / set accumulator b to countA
        incb            ; increment accumulator b
        stab    countA  ; set new value
        bra     P       ; goto P

bb      ldab    countB  ; 'bb' / set accumulator b to countB
        incb            ; increment accumulator b
        stab    countB  ; set new value
        bra     P       ; goto P
        
cc      ldab    countC  ; 'cc' / set accumulator b to countC
        incb            ; increment accumulator b
        stab    countC  ; set new value
        bra     P       ; goto P

dd      ldab    countD  ; 'dd' / set accumulator b to countD
        incb            ; increment accumulator b
        stab    countD  ; set new value
        bra     P       ; goto P

ff      ldab    countF  ; 'ff' / set accumulator b to countF
        incb            ; increment accumulator b
        stab    countF  ; set new value
        bra     P       ; goto P

P       cpx     #End_Grades     ; check if Grades has next value(P)
        bne     Loop            ; restart loop

        swi     ; end program
        end