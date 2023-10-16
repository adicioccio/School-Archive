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
* File name: mainBuffer.c
* Compiler: MS Visual Studio 2022
* Author: Paulo Sousa
* Course: CST 8152 – Compilers, Lab Section: [011, 012, 013, 014]
* Assignment: A12, A22, A32.
* Date: Jan 01 2022
* Professor: Paulo Sousa
* Purpose: This file contains all functionalities from Parser.
* Function list: (...).
************************************************************
*/

/* TODO: Adjust the function header */

#ifndef COMPILERS_H_
#include "Compilers.h"
#endif

#ifndef PARSER_H_
#include "Parser.h"
#endif

/*
************************************************************
 * Process Parser
 ***********************************************************
 */
/* TODO: This is the function to start the parser - check your program definition */

abr_nul startParser() {
	lookahead = tokenizer();
	if (lookahead.code != SEOF_T) {
		program();
	}
	matchToken(SEOF_T, NO_ATTR);
	printf("%s%s\n", STR_LANGNAME, ": Source file parsed");
}


/*
 ************************************************************
 * Match Token
 ***********************************************************
 */
/* TODO: This is the main code for match - check your definition */
abr_nul matchToken(abr_int tokenCode, abr_int tokenAttribute) {
	abr_int matchFlag = 1;
	switch (lookahead.code) {
	case KW_T:
	default:
		if (lookahead.code != tokenCode)
			matchFlag = 0;
	}
	if (matchFlag && lookahead.code == SEOF_T)
		return;
	if (matchFlag) {
		lookahead = tokenizer();
		if (lookahead.code == ERR_T) {
			printError();
			lookahead = tokenizer();
			syntaxErrorNumber++;
		}
	}
	else
		syncErrorHandler(tokenCode);
}

/*
 ************************************************************
 * Syncronize Error Handler
 ***********************************************************
 */
/* TODO: This is the function to handler error - adjust basically datatypes */
abr_nul syncErrorHandler(abr_int syncTokenCode) {
	printError();
	syntaxErrorNumber++;
	while (lookahead.code != syncTokenCode) {
		if (lookahead.code == SEOF_T)
			exit(syntaxErrorNumber);
		lookahead = tokenizer();
	}
	if (lookahead.code != SEOF_T)
		lookahead = tokenizer();
}

/*
 ************************************************************
 * Print Error
 ***********************************************************
 */
/* TODO: This is the function to error printing - adjust basically datatypes */
abr_nul printError() {
	Token t = lookahead;
	printf("%s%s%3d\n", STR_LANGNAME, ": Syntax error:  Line:", line);
	printf("*****  Token code:%3d Attribute: ", t.code);
	switch (t.code) {
	case ERR_T:
		printf("%s\n", t.attribute.errLexeme);
		break;
	case SEOF_T:
		printf("SEOF_T\t\t%d\t\n", t.attribute.seofType);
		break;
	case MVID_T:
		printf("%s\n", t.attribute.idLexeme);
		break;
	case STR_T:
		printf("%s\n", bGetContent(stringLiteralTable, t.attribute.contentString));
		break;
	case KW_T:
		printf("%s\n", keywordTable[t.attribute.codeType]);
		break;
	case LPR_T:
	case RPR_T:
	case LBR_T:
	case RBR_T:
	case EOS_T:
		printf("NA\n");
		break;
	default:
		printf("%s%s%d\n", STR_LANGNAME, ": Scanner error: invalid token code: ", t.code);
	}
}

/*
 ************************************************************
 * Program statement
 * BNF: <program> -> PLATYPUS { <opt_statements> }
 * FIRST(<program>)= {KW_T (MAIN)}.
 ***********************************************************
 */
abr_nul program() {
	switch (lookahead.code) {
	case MVID_T:
		if (strncmp(lookahead.attribute.idLexeme, "main$", 5) == 0) {
			matchToken(MVID_T, NO_ATTR);
			matchToken(LBR_T, NO_ATTR);
			dataSession();
			codeSession();
			matchToken(RBR_T, NO_ATTR);
			break;
		}
		else {
			printError();
		}
	case SEOF_T:
		; // Empty
		break;
	default:
		printError();
	}
	printf("%s%s\n", STR_LANGNAME, ": Program parsed");
}


/*
 ************************************************************
 * dataSession
 * BNF: <dataSession> -> DATA { <opt_varlist_declarations> }
 * FIRST(<program>)= {KW_T (DATA)}.
 ***********************************************************
 */
abr_nul dataSession() {
	matchToken(KW_T, abrDATA);
	matchToken(LBR_T, NO_ATTR);
	optVarListDeclarations();
	matchToken(RBR_T, NO_ATTR);
	printf("%s%s\n", STR_LANGNAME, ": Data Session parsed");
}

/*
 ************************************************************
 * Optional Var List Declarations
 * BNF: <opt_varlist_declarations> -> <varlist_declarations> | e
 * FIRST(<opt_varlist_declarations>) = { e, KW_T (INT), KW_T (FLOAT), KW_T (STRING)}.
 ***********************************************************
 */
abr_nul optVarListDeclarations() {
	switch (lookahead.code) {
	case(KW_T):
		if (lookahead.attribute.codeType == abrINT || lookahead.attribute.codeType == abrFLOAT || lookahead.attribute.codeType == abrCHR) {

		}		
		else {
			printError();
		}
		break;
	default:
		; // Empty
	}
	printf("%s%s\n", STR_LANGNAME, ": Optional Variable List Declarations parsed");
}




/*
 ************************************************************
 * codeSession statement
 * BNF: <codeSession> -> CODE { <opt_statements> }
 * FIRST(<codeSession>)= {KW_T (CODE)}.
 ***********************************************************
 */
abr_nul codeSession() {
	matchToken(KW_T, abrCODE);
	matchToken(LBR_T, NO_ATTR);
	optionalStatements();
	matchToken(RBR_T, NO_ATTR);
	printf("%s%s\n", STR_LANGNAME, ": Code Session parsed");
}

/* TODO_205: Continue the development (all non-terminal functions) */

/*
 ************************************************************
 * Optional statement
 * BNF: <opt_statements> -> <statements> | ϵ
 * FIRST(<opt_statements>) = { ϵ , IVID_T, FVID_T, SVID_T, KW_T(IF),
 *				KW_T(WHILE), KW_T(READ), KW_T(WRITE) }
 ***********************************************************
 */
abr_nul optionalStatements() {
	switch (lookahead.code) {
	case MVID_T:
		if ((strncmp(lookahead.attribute.idLexeme, "print&", 6) == 0)) {
			statements();
			break;
		}

		if ((strncmp(lookahead.attribute.idLexeme, "in&", 3) == 0)) {
			statements();
			break;
		}  
		printError();
		break;
    case KW_T:
		if (lookahead.attribute.codeType == abrIF || lookahead.attribute.codeType == abrWHILE ) {
			statements();
			break;
		}
		printError();
		break;
	case VAR_T:
		statements();
		break;
	default:
		; // Empty
	}
	printf("%s%s\n", STR_LANGNAME, ": Optional statements parsed");
}

/*
 ************************************************************
 * Statements
 * BNF: <statements> -> <statement><statementsPrime>
 * FIRST(<statements>) = { IVID_T, FVID_T, SVID_T, KW_T(IF),
 *		KW_T(WHILE), KW_T(READ), KW_T(WRITE) }
 ***********************************************************
 */
abr_nul statements() {
	statement();
	statementsPrime();
	printf("%s%s\n", STR_LANGNAME, ": Statements parsed");
}

/*
 ************************************************************
 * Statements Prime
 * BNF: <statementsPrime>  <statement><statementsPrime> | ϵ
 * FIRST(<statementsPrime>) = { ϵ , IVID_T, FVID_T, SVID_T, 
 *		KW_T(IF), KW_T(WHILE), KW_T(READ), KW_T(WRITE) }
 ***********************************************************
 */
abr_nul statementsPrime() {
	switch (lookahead.code) {
	case MVID_T:
		if ((strncmp(lookahead.attribute.idLexeme, "print&", 6) == 0)) {
			statements();
			break;
		}
		if ((strncmp(lookahead.attribute.idLexeme, "in&", 3) == 0)) {
			statements();
			break;
		}
		break;
	case KW_T :
		if (lookahead.attribute.codeType == abrIF || lookahead.attribute.codeType == abrWHILE) {
			statements();
			break;
		}
		break;
	case VAR_T:
		statements();
		break;
	default:
		; //empty string
	}
}

/*
 ************************************************************
 * Single statement
 * BNF: <statement> ->  <assignment statement> | <selection statement> |
 *	<iteration statement> | <input statement> | <output statement>
 * FIRST(<statement>) = { IVID_T, FVID_T, SVID_T, KW_T(IF), KW_T(WHILE),
 *			KW_T(READ), KW_T(WRITE) }
 ***********************************************************
 */
abr_nul statement() {
	switch (lookahead.code) {
	case KW_T:
		switch (lookahead.attribute.codeType) {
		case abrIF:
			break;
		case abrWHILE:
			break;
		default:
			printError();
		}
		break;
	case MVID_T:
		if (strncmp(lookahead.attribute.idLexeme, "print&", 6) == 0) {
			outputStatement();
		}
		if (strncmp(lookahead.attribute.idLexeme, "in&", 6) == 0) {
			
		}
		break;
	case VAR_T:
		assignmentStatement();
		break;
	default:
		printError();
	}
	printf("%s%s\n", STR_LANGNAME, ": Statement parsed");
}

/*
 ************************************************************
 * Assignment Statement
 * BNF: <assignment statement> -> <assignment expression>
 * FIRST(<assignment statement>) = { IVID_T, FVID_T, SVID_T, KW_T(IF),
 *		KW_T(WHILE), KW_T(READ), KW_T(WRITE) }
 ***********************************************************
 */
abr_nul assignmentStatement() {
	assignmentExpression();
	matchToken(EOS_T, NO_ATTR);
	printf("%s%s\n", STR_LANGNAME, ": Assignment statement parsed");
}


/*
 ************************************************************
 * Assignment Expression
 * BNF: <assignment expression> -> <integer_variable> = <arithmetic expression>
 *						| <float_variable> = <arithmetic expression>
 *						| <string_variable>= <string expression>
 * FIRST(<assignment expression>) = { IVID_T, FVID_T, SVID_T }
 ***********************************************************
 */
abr_nul assignmentExpression() {
	matchToken(VAR_T, NO_ATTR); 
	matchToken(ASN_T, NO_ATTR);
	matchToken(EOS_T, NO_ATTR);

	printf("%s%s\n", STR_LANGNAME, ": Assignment expression parsed");
}

/*
 ************************************************************
 * Output Statement
 * BNF: <output statement> -> WRITE (<output statementPrime>);
 * FIRST(<output statement>) = { KW_T(WRITE) }
 ***********************************************************
 */
abr_nul outputStatement() {
	matchToken(MVID_T, NO_ATTR);
	matchToken(LPR_T, NO_ATTR);
	outputVariableList();
	matchToken(RPR_T, NO_ATTR);
	matchToken(EOS_T, NO_ATTR);
	printf("%s%s\n", STR_LANGNAME, ": Output statement parsed");
}

/*
 ************************************************************
 * Output Variable List
 * BNF: <opt_variable list> -> <variable list> | ϵ
 * FIRST(<opt_variable_list>) = { IVID_T, FVID_T, SVID_T, ϵ }
 ***********************************************************
 */
abr_nul outputVariableList() {
	switch (lookahead.code) {
	case STR_T:
		matchToken(STR_T, NO_ATTR);
		//printf("%s\n", "SOFIA: Output list (string literal) parsed");
		break;
	case VAR_T:
		matchToken(VAR_T, NO_ATTR);
		break;
	default:
		//printf("%s\n", "SOFIA: Output list (empty) parsed");
		;
	}
	printf("%s%s\n", STR_LANGNAME, ": Output variable list parsed");
}

abr_nul selection_statement() {
	switch (lookahead.code) {
		case abrIF:
			conditional_expression();
			break;
		case abrTHEN:
			optionalStatements();
			break;
		case abrELSE:
			optionalStatements();
			break;
		default:
			break;
	}
	printf("%s%s\n", STR_LANGNAME, ": Selection statement parsed");
}

abr_nul iteration_statement() {
	switch (lookahead.code) {
		case abrWHILE:
			conditional_expression();
			break;
		case abrDO:
			statements();
			break;
		default:
			break;
	}
	printf("%s%s\n", STR_LANGNAME, ": Iteration statement parsed");
}

abr_nul input_statement() {
	if (strncmp(lookahead.attribute.idLexeme, "in", 2) == 0) {
            variable_list();
			printf("%s%s\n", STR_LANGNAME, ": Input statement parsed");
    } else {
		// defensive programming
		printError();
	}
}

abr_nul variable_list() {
	variable_identifier();
	variable_listPrime();
	printf("%s%s\n", STR_LANGNAME, ": Variable list parsed");
}

abr_nul variable_listPrime() {
	switch (lookahead.code) {
	case abrVAR:
		variable_list();
		break;
	default:
		break; 
	}
}

abr_nul variable_identifier() {
	matchToken(INT_T, NO_ATTR); 
	matchToken(DEC_T, NO_ATTR);
	matchToken(STR_T, NO_ATTR);

	printf("%s%s\n", STR_LANGNAME, ": Variable identifier parsed");
}

abr_nul conditional_expression() {
	logical_OR_expression();
	printf("%s%s\n", STR_LANGNAME, ": Conditional expression parsed");
}

abr_nul logical_OR_expression() {
	logical_AND_expression();
	logical_OR_expressionPrime();
	printf("%s%s\n", STR_LANGNAME, ": Logical OR parsed");
}
abr_nul logical_OR_expressionPrime() {
	switch (lookahead.code) {
	case abrOR:
		logical_OR_expression();
		break;
	case abrAND:
		logical_AND_expression();
		break;
	default:
		break; 
	}
}

abr_nul logical_AND_expression() {
	logical_NOT_expression();
	logical_AND_expressionPrime();
	printf("%s%s\n", STR_LANGNAME, ": Logical AND parsed");
}
abr_nul logical_AND_expressionPrime() {
	switch (lookahead.code) {
	case abrAND:
		logical_AND_expression();
		break;
	case abrNOT:
		logical_NOT_expression();
		break;
	default:
		break; 
	}
}

abr_nul logical_NOT_expression() {
	relational_Expression();
	printf("%s%s\n", STR_LANGNAME, ": Logical NOT parsed");
}

abr_nul relational_Expression() {
	relational_A_Expression();
	relational_S_Expression();
}
abr_nul relational_A_Expression() {
	switch(lookahead.code) {
		case INT_T:
			relational_A_Expression();
			operator();
			relational_A_Expression();
			break;
		case DEC_T:
			relational_A_Expression();
			operator();
			relational_A_Expression();
			break;
		case STR_T:
			relational_A_Expression();
			operator();
			relational_A_Expression();
			break;
		default:
			break;
	}
	printf("%s%s\n", STR_LANGNAME, ": Relational A expression parsed");
}
abr_nul relational_S_Expression() {
	switch(lookahead.code) {
		case INT_T:
			relational_S_Expression();
			operator();
			relational_S_Expression();
			break;
		case DEC_T:
			relational_S_Expression();
			operator();
			relational_S_Expression();
			break;
		case STR_T:
			relational_S_Expression();
			operator();
			relational_S_Expression();
			break;
		default:
			break;
	}
	printf("%s%s\n", STR_LANGNAME, ": Relational S expression parsed");
}

abr_nul primaryRelationalA() {
	integer_variable();
	decimal_variable();
}
abr_nul primaryRelationalS() {
	integer_variable();
	decimal_variable();
}

abr_nul primary_string_expression() {
	string_variable();
}

abr_nul string_variable() {
	if (lookahead.code == STR_T) {
		matchToken(STR_T, NO_ATTR);
	}
}

abr_nul integer_variable() {
	if (lookahead.code == INT_T) {
		matchToken(INT_T, NO_ATTR);
	}
}

abr_nul decimal_variable() {
	if (lookahead.code == DEC_T) {
		matchToken(DEC_T, NO_ATTR);
	}
}

abr_nul operator() {
	if (lookahead.code == OP_EQ) {
		matchToken(OP_EQ, lookahead.attribute.logicalOperator);
	}
	if (lookahead.code == OP_NE) {
		matchToken(OP_NE, lookahead.attribute.logicalOperator);
	}
	if (lookahead.code == OP_LT) {
		matchToken(OP_LT, lookahead.attribute.logicalOperator);
	}
	if (lookahead.code == OP_GT) {
		matchToken(OP_GT, lookahead.attribute.logicalOperator);
	} else {
		// defensive programming
		printError();
	}
}
