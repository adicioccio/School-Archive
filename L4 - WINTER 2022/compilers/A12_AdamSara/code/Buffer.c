/*
************************************************************
* COMPILERS COURSE - Algonquin College
* Code version: Winter, 2022
* Author: Svillen Ranev - Paulo Sousa
* Professors: Paulo Sousa / George Kriger / Abdullah Kadri
************************************************************
*/

/*
***********************************************************
* File name: buffer.c
* Compiler: MS Visual Studio 2022
* Author: Paulo Sousa
* Course: CST 8152 � Compilers, Lab Section: [011, 012, 013, 014]
* Assignment: A12.
* Date: Jan 01 2022
* Professor: Paulo Sousa
* Purpose: This file is the main code for Buffer (A12)
************************************************************
*/

#ifndef COMPILERS_H_
#include "Compilers.h"
#endif

#ifndef BUFFER_H_
#include "Buffer.h"
#endif

/*
***********************************************************
* Function name: bCreate
* Purpose: Creates the buffer according to capacity, increment
	factor and operational mode ('f', 'a', 'm')
* Author: Svillen Ranev / Paulo Sousa
* History/Versions: Ver 2.1
* Called functions: calloc(), malloc()
* Parameters:
*   size = initial capacity
*   increment = increment factor
*   mode = operational mode
* Return value: bPointer (pointer to Buffer)
* Algorithm: Allocation of memory according to inicial (default) values.
* TO_DO: 
*	- Adjust datatypes for your LANGUAGE.
*   - Use defensive programming
*	- Check boundary conditions
*	- Check flags.
*************************************************************
*/

BufferPointer bCreate(abr_shrt size, abr_shrt increment, abr_shrt mode) {
	BufferPointer b;

	/* TO_DO: Defensive programming */
	if (size > MAX_SIZE || size < 0 ) {
		return NULL;

	}

	if (!size) {
		size = BUFFER_DEFAULT_SIZE;
		increment = BUFFER_DEFAULT_INCREMENT;
	}

	if (!increment) {
		mode = MODE_FIXED;
	}

	b = (BufferPointer)calloc(1, sizeof(Buffer)); // 

	if (b == NULL) {
		return NULL;
	}

	
	b->string = (abr_chr*)malloc(size);

	if (b->string == NULL) {
		free(b); //releasing and saving memory
		return NULL;
	}

	/* TO_DO: Adjust properties */
	//assigning the values in the parameter list to the attributes of buffer 
	b->mode = mode; 
	b->size = size;
	b->increment = increment;
	b->flags = BUFFER_DEFAULT_FLAG;
	return b;
}


/*
***********************************************************
* Function name: bAddChar
* Purpose: Adds a char to buffer
* Parameters:
*   pBuffer = pointer to Buffer Entity
*   ch = char to be added
* Return value:
*	bPointer (pointer to Buffer)
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/

BufferPointer bAddChar(BufferPointer const pBuffer, abr_chr ch) {
	abr_shrt newSize = 0;
	/* TO_DO: Defensive programming */

	if (!pBuffer ){
		return NULL;
	}
	//-> to access the attribute of the a struct(buffer)

	//reset the relocation byte for adding a char
	pBuffer->flags = pBuffer->flags & ABR_RST_FLAG_REL;


	if (bIsFull(pBuffer) == ABR_TRUE) {
		switch (pBuffer->mode) {
		case MODE_FIXED:
			/* TO_DO: Adjust the fixed mode */
			return NULL;

		case MODE_ADDIT:
			
			/* TO_DO: Adjust the additive mode */
			newSize = pBuffer->size + pBuffer->increment;
			break;
		case MODE_MULTI:
			
			/* TO_DO: Adjust the multiplicative mode */
			newSize = pBuffer->size * pBuffer->increment;
			break;;
		default:
			return NULL;
		}

		abr_chr* tempBuffer = (char*)realloc(pBuffer->string, newSize);
		if (!tempBuffer) {
			return NULL;
		}

		if (tempBuffer != pBuffer->string) {
			pBuffer->flags = pBuffer->flags & ABR_SET_FLAG_REL;
			pBuffer->string = tempBuffer;
		}

		pBuffer->size = newSize;
	}
	
	/* TO_DO: Defensive programming */
	/* TO_DO: Adjust the buffer */
	pBuffer->string[pBuffer->position.writePos++] = ch;
	return pBuffer;
}

/*
***********************************************************
* Function name: bClear
* Purpose: Clears the buffer
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Boolean value about operation success
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_bol bClear(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	pBuffer->position.writePos = pBuffer->position.markPos = pBuffer->position.readPos = 0;
	/* TO_DO: Adjust flags original */
	pBuffer->flags = pBuffer->flags & ABR_RST_FLAG_EMP;
	pBuffer->flags = pBuffer->flags & ABR_RST_FLAG_REL;
	pBuffer->flags = pBuffer->flags & ABR_RST_FLAG_FUL;
	pBuffer->flags = pBuffer->flags & ABR_RST_FLAG_EOB;

	return ABR_TRUE;
}

/*
***********************************************************
* Function name: bDestroy
* Purpose: Releases the buffer address
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Boolean value about operation success
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_bol bDestroy(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	/* TO_DO: Clear buffer data */
	free(pBuffer->string);
	free(pBuffer);
	return ABR_TRUE;
}

/*
***********************************************************
* Function name: bIsFull
* Purpose: Checks if buffer is full
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Boolean value about operation success
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_bol bIsFull(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	/* TO_DO: Check flag if buffer is FUL */
	return pBuffer->flags & ABR_CHK_FLAG_FUL; //ASK
	return ABR_TRUE;
}

/*
***********************************************************
* Function name: bGetWritePos
* Purpose: Returns the position of char to be added
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	addcPosition value
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_shrt bGetWritePos(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	return pBuffer->position.writePos;
}



/*
***********************************************************
* Function name: bGetSize
* Purpose: Returns the current buffer capacity
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Size of buffer.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_shrt bGetSize(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	return pBuffer->size;
}

/*
***********************************************************
* Function name: bGetMode
* Purpose: Returns the operational mode
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	operational mode.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_shrt bGetMode(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	return pBuffer->mode;
}


/*
***********************************************************
* Function name: bGetMarkPos
* Purpose: Returns the position of mark in the buffer
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	mark offset.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_shrt bGetMarkPos(BufferPointer const pBuffer) {
	if (!pBuffer) {
		return NULL;
	}
	/* TO_DO: Defensive programming */
	return pBuffer->position.markPos;
}


/*
***********************************************************
* Function name: bSetMark
* Purpose: Adjust the position of mark in the buffer
* Parameters:
*   pBuffer = pointer to Buffer Entity
*   mark = mark position for char
* Return value:
*	Boolean value about operation success
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_bol bSetMark(BufferPointer const pBuffer, abr_shrt mark) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	/* TO_DO: Adjust the mark */
	pBuffer->position.markPos = mark;
	return ABR_TRUE;
}

/*
***********************************************************
* Function name: bPrint
* Purpose: Prints the string in the buffer.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Number of chars printed.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_shrt bPrint(BufferPointer const pBuffer) {
	abr_shrt size = 1;
	abr_chr c;
	/* TO_DO: Defensive programming */
	if (!pBuffer || !pBuffer->string) {
		return NULL;
	}
	c = bGetChar(pBuffer);
	/* TO_DO: Check flag if buffer EOB has achieved */
	while (c>0) {
		/* TO_DO: Adjust size */
		printf("%c", c);
		c = bGetChar(pBuffer);
	}
	return size;
}

/*
***********************************************************
* Function name: bLoad
* Purpose: Loads the string in the buffer with the content of
	an specific file.
* Parameters:
*   pBuffer = pointer to Buffer Entity
*   fi = pointer to file descriptor
* Return value:
*	Number of chars read and put in buffer.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_shrt bLoad(BufferPointer const pBuffer, FILE* const fi) {
	abr_shrt size = 1;
	abr_chr c;
	/* TO_DO: Defensive programming */
	if (!pBuffer || !fi) {
		return NULL;
	}
	c = (abr_chr)fgetc(fi);
	while (!feof(fi)) {
		if (!bAddChar(pBuffer, c)) {
			ungetc(c, fi);
			return BUFFER_ERROR;
		}
		c = (char)fgetc(fi);
		/* Adjust size */
	}
	/* TO_DO: Defensive programming */
	return size;
}

/*
***********************************************************
* Function name: bIsEmpty
* Purpose: Checks if buffer is empty.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Boolean value about operation success
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_bol bIsEmpty(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	/* TO_DO: Check if it is empty */
	return ABR_FALSE;
}

/*
***********************************************************
* Function name: bGetChar
* Purpose: Returns the char in the getC position.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Char in the getC position.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_chr bGetChar(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	/* TO_DO: Adjust EOB flag */
	return pBuffer->string[pBuffer->position.readPos++];
}


/*
***********************************************************
* Function name: bRecover
* Purpose: Rewinds the buffer.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value
*	Boolean value about operation success
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_bol bRecover(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	pBuffer->position.readPos = 0;
	pBuffer->position.markPos = 0;
	return ABR_TRUE;
}


/*
***********************************************************
* Function name: bRetract
* Purpose: Retracts the buffer to put back the char in buffer.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Boolean value about operation success
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_bol bRetract(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	pBuffer->position.readPos--;
	return ABR_TRUE;
}


/*
***********************************************************
* Function name: bRestore
* Purpose: Resets the buffer.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Boolean value about operation success
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_bol bRestore(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	pBuffer->position.readPos = pBuffer->position.markPos;
	return ABR_TRUE;
}


/*
***********************************************************
* Function name: bGetReadPos
* Purpose: Returns the value of getCPosition.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	The readPos offset.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_shrt bGetReadPos(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	return pBuffer->position.readPos;
}


/*
***********************************************************
* Function name: bGetIncrement
* Purpose: Returns the buffer increment.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	The Buffer increment.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_shrt bGetIncrement(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	return pBuffer->increment;
}


/*
***********************************************************
* Function name: bGetContent
* Purpose: Returns the pointer to String.
* Parameters:
*   pBuffer = pointer to Buffer Entity
*   pos = position to get the pointer
* Return value:
*	Position of string char.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
abr_chr* bGetContent(BufferPointer const pBuffer, abr_shrt pos) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	return pBuffer->string + pos;
}


/*
***********************************************************
* Function name: bGetFlags
* Purpose: Returns the entire flags of Buffer.
* Parameters:
*   pBuffer = pointer to Buffer Entity
* Return value:
*	Flags from Buffer.
* TO_DO:
*   - Use defensive programming
*	- Check boundary conditions
*	- Adjust for your LANGUAGE.
*************************************************************
*/
#define FLAGS_
#undef FLAGS_
#ifndef FLAGS_
abr_flg bGetFlags(BufferPointer const pBuffer) {
	/* TO_DO: Defensive programming */
	if (!pBuffer) {
		return NULL;
	}
	return pBuffer->flags;
}
#else
#define bGetFlags(pBuffer) ((pBuffer)?(pBuffer->flags):(RT_FAIL_1))
#endif
