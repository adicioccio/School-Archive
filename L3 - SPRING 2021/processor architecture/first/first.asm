; first.asm

; Author:       Adam Di Cioccio
; Student Num:  041019241
; Date:         Nov 11, 2021

; Purpose: Add $15 and $16 then subtract one

; Start data (origin) at memory address $1000
	org     $1000
; Store numbers to be added in memory
p:      db      $15
q:      db      $16
; Free up a slot in memory for the answer to go into
r:      ds      1
; Start importing program at memory address $2000
        org     $2000
        ldaa    p
        adda    q
        deca
        staa    r
        end