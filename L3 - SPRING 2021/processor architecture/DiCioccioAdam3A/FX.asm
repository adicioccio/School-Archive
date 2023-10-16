; FX.asm
;
; Author: Adam Di Cioccio
; Course: CST8216
; Student Number: 041019241
; Date: Nov 17, 2021
;
; Purpose:      To illustrate how to solve an equation such as:
;               f(x) = 5x + 3 for x = 0 to 9, using 8-bit Multiplication
;               The calculated x in f(x) values will be placed into the X_Values array
;               The calculated f(x) values will be placed into the Results array
;


        org     $1000
count:    ds      1


ARRAY_LEN       equ     10      ; Number of values to calculate (10): x = 0 to 9
                                ; Need two arrays of length ARRAY_LEN
                                ; - one holds x = 0 to 9
                                ; - one holds f(x) results

        org        $1020           ; org as per assignment instructions
X_Values
        ds      ARRAY_LEN       ; Complete this line of code
                                ; Value of x used in calculation stored here
End_X_Values

        org     $1030           ; org as per assignment instructions
        
Results
        ds      ARRAY_LEN       ; Complete this line of code
                                ; Result of f(x) calculation stored here
End_Results

; Expected Results

;


        org     $2000           ; start the program at memory address 2000
        lds     #$2000          ; initialize stack pointer
        ldx     #X_Values       ; load X_Values into loader x
        
Loop    ldaa    count           ; start of loop / load count into accumulator a
        ldab    #$5             ; loads the hex value 5 into accumulator b
        mul                     ; mulitplys accumulators, results into acc b (acc a reset)
        addb    #$3             ; add hex 3 to accumulator b

	ldaa    count           ; load accumulator a with count
        staa    0,x             ; store from accumulator a with current x value
        stab    16,x            ; store from accumulator b with offset of 16 into x_values
        inx                     ; increase x by 1

        ldaa    count           ; load count into a
        inca                    ; increment by 1
        staa    count           ; update count value

        cpx     #End_X_Values   ; check if x_values has next
        bne     Loop            ; loop


        swi                     ; end program
        end