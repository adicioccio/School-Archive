; First.asm
;
; Author:       	Adam Di Cioccio
; Student Number:       041019241
; Date:                 October 12, 2021

 ; Purpose:             Program that adds up the following values: $25 + $37 - $01
 ;
        org     $1000   ;Origin for Program Data
p:      db      $25     ;First addend is at memory location p
q:      db      $37     ;Second addend is at memory location q
r:      ds      1       ;Sum will be stored at memory location r

        org     $2000   ;Origin for program instructions
        ldaa    p       ;Load value at p into accumulator a
        adda    q       ;Add value at q into accumulator a
        deca            ;Subtract 1: A = A - 1
        staa    r       ;Store accumulator A at location r
        swi             ;Stop program
        end