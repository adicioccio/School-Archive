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
* File name: scanner.h
* Compiler: MS Visual Studio 2022
* Author: Paulo Sousa
* Course: CST 8152 � Compilers, Lab Section: [011, 012, 013, 014]
* Assignment: A22, A32.
* Date: Feb 21 2022
* Purpose: This file is the main header for Scanner (.h)
* Function list: (...).
*************************************************************/
#include "Compilers.h"
#ifndef COMPILERS_H_
#include "Compilers.h"
#endif

#ifndef SCANNER_H_
#define SCANNER_H_

#ifndef NULL
#include <_null.h> /* NULL pointer constant is defined there */
#endif

/*#pragma warning(1:4001) */	/*to enforce C89 type comments  - to make //comments an warning */

/*#pragma warning(error:4001)*/	/* to enforce C89 comments - to make // comments an error */

/* Constants */
#define VID_LEN 20   /* variable identifier length */
#define ERR_LEN 20  /* error message length */
#define NUM_LEN 20   /* maximum number of digits for IL */

#define RTE_CODE 1   /* Value for run-time error */

/* TO_DO: Define Token codes - Create your token classes */
enum TOKENS {
	ERR_T,		/*  0: Error token */
	MVID_T,		/*  1: Method name identifier token (start: &) */
	KW_T,		/*  2: Keyword token */
	VAR_T,		/*  3: Variable token */
	INT_T,		/*  4: Integer token */
	DEC_T,		/*  5: Decimal token */
	STR_T,		/*  6: String literal token */
	COM_T,		/*  7: Comment token */
	ARI_T,		/*  8: Arithmetic operator token */
	REL_T,		/*  9: Relational operator token */
	LPR_T,		/*  10: Left parenthesis token */
	RPR_T,		/*  11: Right parenthesis token */
	LBR_T,		/*  12: Left brace token */
	RBR_T,		/*  13: Right brace token */
	EOS_T,		/*  14: End of statement (semicolon) */
	RTE_T,		/*  15: Run-time error token */
	SEOF_T		/*  16: Source end-of-file token */

};

/* TO_DO: Operators token attributes */
typedef enum ArithmeticOperators { OP_ADD, OP_SUB, OP_MUL, OP_DIV } AriOperator;
typedef enum RelationalOperators { OP_EQ, OP_NE, OP_GT, OP_LT } RelOperator;
typedef enum LogicalOperators { OP_AND, OP_OR, OP_NOT } LogOperator;
typedef enum SourceEndOfFile { SEOF_0, SEOF_255 } EofOperator;

/* TO_DO: Data structures for declaring the token and its attributes */
typedef union TokenAttribute {
	abr_int codeType;      /* integer attributes accessor */
	AriOperator arithmeticOperator;		/* arithmetic operator attribute code */
	RelOperator relationalOperator;		/* relational operator attribute code */
	LogOperator logicalOperator;		/* logical operator attribute code */
	EofOperator seofType;				/* source-end-of-file attribute code */
	abr_int intValue;						/* integer literal attribute (value) */
	abr_int keywordIndex;					/* keyword index in the keyword table */
	abr_int contentString;				/* string literal offset from the beginning of the string literal buffer (stringLiteralTable->content) */
	abr_flt floatValue;					/* floating-point literal attribute (value) */
	abr_chr idLexeme[VID_LEN + 1];		/* variable identifier token attribute */
	abr_chr errLexeme[ERR_LEN + 1];		/* error token attribite */
} TokenAttribute;

/* TO_DO: Should be used if no symbol table is implemented */
typedef struct idAttibutes {
	abr_flg flags;			/* Flags information */
	union {
		abr_int intValue;				/* Integer value */
		abr_flt floatValue;			/* Float value */
		abr_null* stringContent;		/* String value */
	} values;
} IdAttibutes;

/* Token declaration */
typedef struct Token {
	abr_int code;				/* token code */
	TokenAttribute attribute;	/* token attribute */
	IdAttibutes   idAttribute;	/* not used in this scanner implementation - for further use */
} Token;

///////////////////////////////////////////////////////////////////////////////////////////////////////

/* EOF definitions */
#define CHARSEOF0 '\0'
#define CHARSEOF255 0xFF

/*  Special case tokens processed separately one by one in the token-driven part of the scanner
 *  '=' , ' ' , '(' , ')' , '{' , '}' , == , <> , '>' , '<' , ';', 
 *  white space, @comment@ , ',' , ';' , '-' , '+' , '*' , '/', ## , 
 *  .&., .|. , .!. , SEOF.
 */

/* TO_DO: Error states and illegal state */
#define ES  6		/* Error state with no retract */
#define ER  7		/* Error state with retract */
#define IS -1		/* Illegal state */

 /* TO_DO: State transition table definition */
#define TABLE_COLUMNS 11

/* TO_DO: Define lexeme FIXED classes */
/* These constants will be used on nextClass */
#define CHRCOL2 '_'
#define CHRCOL3 '$'
#define CHRCOL4 '\"'

/* These constants will be used on VID / MID function */
#define MNIDPREFIX '$'

/* TO_DO: Transition table - type of states defined in separate table */
static abr_int transitionTable[][TABLE_COLUMNS] = {
/*   [A-z] , [0-9],    _,    .,   $",    #,    "",other,
	   L(0),  D(1), U(2), P(3), B(4), C(5),  Q(6), O(7), */
	{     1,     6,    4,   ES,    4,   12,   10,	ES}, // S0: NOAS
	{     1,    ES,    3,   ES,    2,   ES,   ES,	 1}, // S1: NOAS
	{    IS,    IS,   IS,   IS,   IS,   IS,   IS,	ES}, // S2: ASNR (MVID)
	{    IS,    IS,   IS,   IS,   IS,   IS,   IS,	ES}, // S3: ASWR (KEY)
	{     4,     4,    5,   ES,   ES,   ES,   ES,	 4}, // S4: NOAS
	{    IS,    IS,   IS,   IS,   IS,   IS,   IS,	ES}, // S5: ASWR (VARIABLE)
	{    ES,     6,    7,    8,   ES,   ES,    3,	ES}, // S6: NOAS
	{    IS,    IS,   IS,   IS,   IS,   IS,   IS,	ES}, // S7: ASWR (INT)
	{    ES,     8,    9,   ES,   ES,   ES,   ES,	ES}, // S8: NOAS
	{    IS,    IS,   IS,   IS,   IS,   IS,   IS,	ES}, // S9: ASWR (DECIMAL)
	{    10,    10,   10,   10,   10,   10,   11,	10}, // S10: NOAS
	{    IS,    IS,   IS,   IS,   IS,   IS,   IS,	ES}, // S11: ASNR (SL)
	{    12,    12,   12,   12,   12,   12,   13,	12}, // S12: NOAS
	{    IS,    IS,   IS,   IS,   IS,   IS,   IS,	ES}  // S13: ASNR (COMMENT)
};

/* Define accepting states types */
#define NOAS	0		/* not accepting state */
#define ASNR	1		/* accepting state with no retract */
#define ASWR	2		/* accepting state with retract */

/* TO_DO: Define list of acceptable states */
static abr_int stateType[] = {
	NOAS, /* 00 */
	NOAS, /* 01 */
	ASNR, /* 02 (MID) - Methods */
	ASWR, /* 03 (KEY) - Key */
	NOAS, /* 04 */
	ASWR, /* 05 (VARIABLE) */
	NOAS, /* 06 */
	ASWR, /* 07 (INT) */
	NOAS, /* 08 */
	ASWR, /* 09 (DECIMAL) */
	NOAS, /* 10 */
	ASNR, /* 11 (SL) */
	NOAS, /* 12 */
	ASNR, /* 13 (COMMENT) */
	ASNR, /* 14 (Err1 - no retract) */
	ASWR  /* 15 (Err2 - retract) */
};

/*
-------------------------------------------------
TO_DO: Adjust your functions'definitions
-------------------------------------------------
*/

/* Static (local) function  prototypes */
abr_int startScanner(BufferPointer psc_buf);
static abr_int nextClass(abr_chr c);			/* character class function */
static abr_int nextState(abr_int, abr_chr);		/* state machine function */

/*
-------------------------------------------------
Automata definitions
-------------------------------------------------
*/

/* TO_DO: Pointer to function (of one char * argument) returning Token */
typedef Token(*PTR_ACCFUN)(abr_chr* lexeme);

/* Declare accepting states functions */
Token funcID	(abr_chr lexeme[]);
Token funcKEY	(abr_chr lexeme[]);
Token funcVAR	(abr_chr lexeme[]); // <-
Token funcINT	(abr_chr lexeme[]); // <-
Token funcDEC	(abr_chr lexeme[]); // <-
Token funcSL	(abr_chr lexeme[]);
Token funcErr	(abr_chr lexeme[]);

/* 
 * Accepting function (action) callback table (array) definition 
 * If you do not want to use the typedef, the equvalent declaration is:
 */

/* TO_DO: Define final state table */
static PTR_ACCFUN finalStateTable[] = {
	NULL,		/* -    [00] */
	NULL,		/* -    [01] */
	funcID,		/* MNID	[02] */
	funcKEY,	/* KEY  [03] */
	NULL,		/* -    [04] */
	funcVAR,	/* VAR   [05] */
	NULL,		/* -    [06] */
	funcINT,	/* INT   [07] */
	NULL,		/* -    [08] */
	funcDEC,	/* DEC   [09] */
	NULL,		/* -    [10] */
	funcSL,		/* SL   [11] */
	NULL,		/* -    [12] */
	funcErr,	/* ERR1 [14] */
	funcErr		/* ERR2 [15] */
};

/*
-------------------------------------------------
Language keywords
-------------------------------------------------
*/

/* TO_DO: Define the number of Keywords from the language */
#define KWT_SIZE 9

/* TO_DO: Define the list of keywords */
static abr_chr* keywordTable[KWT_SIZE] = {
	"main",
	"int",
	"decimal",
	"string",
	"if",
	"then",
	"else",
	"while",
	"do"
};

#endif
