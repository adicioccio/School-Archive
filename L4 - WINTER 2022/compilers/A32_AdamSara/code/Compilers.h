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
* File name: compilers.h
* Compiler: MS Visual Studio 2022
* Author: Paulo Sousa
* Course: CST 8152 – Compilers, Lab Section: [011, 012, 013, 014]
* Assignment: A12, A22, A32.
* Date: Jan 01 2022
* Professor: Paulo Sousa
* Purpose: This file defines the functions called by main function.
* Function list: mainBuffer(), mainScanner(), mainParser().
*************************************************************/

#ifndef COMPILERS_H_
#define COMPILERS_H_

#define DEBUG 0

/* Logical constants - adapt for your language */
#define ABR_TRUE	1
#define ABR_FALSE 0

/*
------------------------------------------------------------
Programs:
1: Buffer - invokes MainBuffer code
2: Scanner - invokes MainScanner code
3: Parser - invokes MainParser code
------------------------------------------------------------
*/
enum PROGRAMS {
	PGM_BUFFER	= '1',
	PGM_SCANNER = '2',
	PGM_PARSER	= '3'
};

/*
------------------------------------------------------------
Data types definitions
------------------------------------------------------------
*/

/* TO_DO: Define your typedefs */

typedef short			abr_int;
typedef long			abr_lng;
typedef char			abr_chr;
typedef unsigned char	abr_flg;
typedef char			abr_bol;
typedef float			abr_flt;
typedef double			abr_dbl;
typedef void			abr_nul;

/*
------------------------------------------------------------
Main functions signatures
(Codes will be updated during next assignments)
------------------------------------------------------------
*/
abr_int mainBuffer(abr_int argc, abr_chr** argv);
abr_int mainScanner(abr_int argc, abr_chr** argv);
abr_int mainParser(abr_int argc, abr_chr** argv);

#endif
