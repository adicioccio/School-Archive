/*
************************************************************
* COMPILERS COURSE - Algonquin College
* Code version: Winter, 2022
* Author: Svillen Ranev - Paulo Sousa
* Professors: Paulo Sousa / George Kriger / Abdullah Kadri
************************************************************
*/

/*
************************************************************
* File name: Buffer.h
* Compiler: MS Visual Studio 2022
* Author: Paulo Sousa
* Course: CST 8152 � Compilers, Lab Section: [011, 012, 013, 014]
* Assignment: A12.
* Date: Jan 01 2022
* Professor: Paulo Sousa
* Purpose: This file is the main header for Parser (.h)
************************************************************
*/

#ifndef COMPILERS_H_
#include "Compilers.h"
#endif

#ifndef BUFFER_H_
#define BUFFER_H_

/*#pragma warning(1:4001) *//*to enforce C89 type comments  - to make //comments an warning */

/*#pragma warning(error:4001)*//* to enforce C89 comments - to make // comments an error */

/* standard header files */
#include <stdio.h>  /* standard input/output */
#include <malloc.h> /* for dynamic memory allocation*/
#include <limits.h> /* implementation-defined data type ranges and limits */

/* CONSTANTS DEFINITION: GENERAL (NOT LANGUAGE DEPENDENT) .................................. */

/* Modes (used to create buffer) */
enum BUFFERMODES {
	MODE_FIXED = 'f',
	MODE_ADDIT = 'a',
	MODE_MULTI = 'm'
};

/* TO_DO: Adjust all constants to your Language */

#define BUFFER_ERROR (-1)						/* General error message */
#define BUFFER_EOF '\0'							/* General EOF */

/* CONSTANTS DEFINITION: PREFIXED BY LANGUAGE NAME (SOFIA) .................................. */

#define BUFFER_DEFAULT_SIZE			2000			/* default initial buffer capacity */
#define BUFFER_DEFAULT_INCREMENT	100			/* default increment factor */

/* Add your bit-masks constant definitions here - Defined for SOFIA */
/* BITS                                (7654.3210) */
#define BUFFER_DEFAULT_FLAG 0x0F 	/* (0000.1111)_2 = (015)_10 */

//declared the hexadecimal for the bytes(the purpose of it was that to defense the program)

/* TO_DO: BIT 7: REL = Relocation */
#define ABR_SET_FLAG_REL 0x80
#define ABR_CHK_FLAG_REL 0x80
#define ABR_RST_FLAG_REL 0x7F



/* TO_DO: BIT 6: EOB = EndOfBuffer */
#define ABR_SET_FLAG_EOB 0x40
#define ABR_CHK_FLAG_EOB 0x40
#define ABR_RST_FLAG_EOB 0xBF
// //  //control k and c to comment 
 // uncomment control k and u 
//8421 8421
//1101 0000

/* TO_DO: BIT 5: FUL = Full */
#define ABR_SET_FLAG_FUL 0x20
#define ABR_CHK_FLAG_FUL 0x20
#define ABR_RST_FLAG_FUL 0xDF



/* TO_DO: BIT 4: EMP = Empty */
#define ABR_SET_FLAG_EMP 0x10
#define ABR_CHK_FLAG_EMP 0x10
#define ABR_RST_FLAG_EMP 0xEF

/* STRUCTURES DEFINITION: SUFIXED BY LANGUAGE NAME (SOFIA) .................................. */

/* TO_DO: Adjust datatypes */
 
 

/* Offset declaration */
typedef struct position {
	abr_shrt markPos;			/* the offset (in chars) to the mark location */
	abr_shrt readPos;			/* the offset (in chars) to the get-character location */
	abr_shrt writePos;			/* the offset (in chars) to the add-character location */
} Position;

/* Buffer structure */
typedef struct buffer {
	abr_chr*		string;		/* pointer to the beginning of character array (character buffer) */
	abr_shrt		size;		    /* current dynamic memory size (in bytes) allocated to character buffer */
	abr_shrt		increment;		/* character array increment factor */
	abr_shrt		mode;			/* operational mode indicator */
	abr_flg			flags;			/* contains character array reallocation flag and end-of-buffer flag */
	Position	position;		/* Offset / position field */
} Buffer, * BufferPointer;




/* FUNCTIONS DECLARATION:  .................................. */
/* TO_DO: Define your function declarations using your language specification */

/* FUNCTIONS DECLARATION:  .................................. */
/* General Operations */
BufferPointer	bCreate(abr_shrt, abr_shrt, abr_shrt);
BufferPointer	bAddChar(BufferPointer const, abr_chr);
abr_bol				bRetract(BufferPointer const);
abr_bol				bRestore(BufferPointer const);
abr_bol				bRecover(BufferPointer const);
abr_bol				bClear(BufferPointer const);
abr_bol				bDestroy(BufferPointer const);
abr_bol				bSetMark(BufferPointer const, abr_shrt);
abr_bol				bIsEmpty(BufferPointer const);
abr_bol				bIsFull(BufferPointer const);
abr_bol				bIsRealocated(BufferPointer const);
abr_shrt			bPrint(BufferPointer const);
abr_shrt			bLoad(BufferPointer const, FILE* const);
/* Getters */
abr_shrt			bGetSize(BufferPointer const);
abr_shrt			bGetWritePos(BufferPointer const);
abr_shrt			bGetMarkPos(BufferPointer const);
abr_shrt			bGetReadPos(BufferPointer const);
abr_shrt			bGetIncrement(BufferPointer const);
abr_shrt			bGetMode(BufferPointer const);
abr_chr				bGetChar(BufferPointer const);
abr_chr*			bGetContent(BufferPointer const, abr_shrt);
abr_flg				bGetFlags(BufferPointer const);

#endif
