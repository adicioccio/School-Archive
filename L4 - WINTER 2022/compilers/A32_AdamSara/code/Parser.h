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
* File name: parser.h
* Compiler: MS Visual Studio 2022
* Author: Paulo Sousa
* Course: CST 8152 � Compilers, Lab Section: [011, 012, 013, 014]
* Assignment: A12, A22, A32.
* Date: Jan 01 2022
* Professor: Paulo Sousa
* Purpose: This file is the main header for Parser (.h)
*************************************************************/

#ifndef PARSER_H_
#define PARSER_H_

/* Inclusion section */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdarg.h>

#ifndef COMPILERS_H_
#include "Compilers.h"
#endif
#ifndef BUFFER_H_
#include "Buffer.h"
#endif
#ifndef SCANNER_H_
#include "Scanner.h"
#endif

/* Global vars */
static Token lookahead;
abr_int syntaxErrorNumber = 0;
extern Buffer* stringLiteralTable;
extern abr_int line;
extern Token tokenizer();
extern abr_chr* keywordTable[];

#define STR_LANGNAME "abr"

/* TO_DO: Create ALL constants for keywords (sequence given in table.h) */


/* Constants */
enum KEYWORDS {
	NO_ATTR = -1,
	abrCODE,
	abrDATA,
	abrINT,
	abrFLOAT,
	abrCHR,
	abrIF,
	abrTHEN,
	abrELSE,
	abrWHILE,
	abrDO,
	abrVAR,
	abrOR,
	abrAND,
	abrNOT,
	abrEQ
};

/* Function definitions */
abr_nul startParser();
abr_nul matchToken(abr_int, abr_int);
abr_nul syncErrorHandler(abr_int);
abr_nul printError();

/* TODO: Place ALL non-terminal function declarations */
abr_nul assignmentExpression();
abr_nul assignmentStatement();
abr_nul codeSession();
abr_nul dataSession();
abr_nul optVarListDeclarations();
abr_nul varListDeclaration();
abr_nul optionalStatements();
abr_nul outputStatement();
abr_nul outputVariableList();
abr_nul program();
abr_nul statement();
abr_nul statements();
abr_nul statementsPrime();

abr_nul selection_statement();
abr_nul iteration_statement();
abr_nul input_statement();
abr_nul variable_list();
abr_nul variable_listPrime();
abr_nul variable_identifier();
abr_nul conditional_expression();
abr_nul logical_OR_expression();
abr_nul logical_OR_expressionPrime();
abr_nul logical_AND_expression();
abr_nul logical_AND_expressionPrime();
abr_nul logical_NOT_expression();
abr_nul relational_Expression();
abr_nul relational_A_Expression();
abr_nul relational_S_Expression();
abr_nul primaryRelationalA();
abr_nul primaryRelationalS();
abr_nul primary_string_expression();
abr_nul string_variable();
abr_nul integer_variable();
abr_nul decimal_variable();
abr_nul operator();






#endif
