; Exam.asm
;
; Name:                 < Your name goes here >
; Student Number:       < Your student number goes here >
;
; NOTE:                 No credit will be given if the above information is missing
;
; Final Exam Quiz instructions and this starter code
; provides instructions on what this program must do

; Program Constants

OFFSET          equ     20             ; <== Calculate Constant Offset Addressing Mode
                                        ;     offset value from the Array to Index_Number_Array
                                        ;     using the appropriate adddresses.
                                        ;      You may HARD CODE this value.

DIVISOR         equ     18             ; <== Determine the divisor used with the
                                        ;     idiv instruction from Final Exam Quiz instructions
ARRAY_LEN       equ     End_Array-Array ; dynamic array size calculation
Index           equ     $00             ; Starting Array index
ORIG_ZERO       equ     $CC             ; if original Array value = 0, store this value
NON_ZERO        equ     $FF             ; if idiv results not equal to zero, store this value


        org     $1000
Array   db      0,18,35,55,72,0,0,126,144,0,0,198,215,235,252,0        ; cut and paste the array provided to you
                                        ; in the Final Exam Quiz instructions here
End_Array

        org	$1020                   ; <== Final Exam Quiz instructions contains
                                        ;     this value. Use this address to
                                        ;     calculate your offset for
                                        ;     CONSTANT OFFSET ADDRESSING mode
Index_Number_Array
                ds      End_Array-Array
End_Index_Number_Array

        org     $2000
        lds     #$2000
        ldy     #Array
; your code goes here
Loop    ldaa    Index,y
        cmpa    #$00
        beq     IsZero
        staa    Index,ARRAY_LEN


IsZero  ldab    Index
        stab    Index,ARRAY_LEN
        
        cmpb    ARRAY_LEN
	beq     EndProg
        ldab    Index
	incb
        stab    Index
	bra     Loop

EndProg	swi
        end