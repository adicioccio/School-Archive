:: COMPILERS COURSE - SCRIPT ---------------------------------------------
:: SCRIPT A22 - CST8152 - Winter 2022

CLS
SET COMPILER=Compiler.exe

SET FILE1=SOFIA_Empty
SET FILE2=SOFIA_Hello
SET FILE3=SOFIA_Volume
SET FILE4=SOFIA_Factorial
SET FILE5=SOFIA_Datatypes
SET FILE6=SOFIA_General

SET EXTENSION=sof
SET OUTPUT=out
SET ERROR=err

SET PARAM=2

:: ---------------------------------------------------------------------
:: Begin of Tests (A22 - W22) ------------------------------------------
:: ---------------------------------------------------------------------

ren *.exe %COMPILER%

::
:: BASIC TESTS  ----------------------------------------------------------
::
:: Basic Tests (A22 - W22) - - - - - - - - - - - - - - - - - - - - - -

%COMPILER% %PARAM% %FILE1%.%EXTENSION%	> %FILE1%.%OUTPUT%	2> %FILE1%.%ERROR%
%COMPILER% %PARAM% %FILE2%.%EXTENSION%	> %FILE2%.%OUTPUT%	2> %FILE2%.%ERROR%
%COMPILER% %PARAM% %FILE3%.%EXTENSION%	> %FILE3%.%OUTPUT%	2> %FILE3%.%ERROR%
%COMPILER% %PARAM% %FILE4%.%EXTENSION%	> %FILE4%.%OUTPUT%	2> %FILE4%.%ERROR%
%COMPILER% %PARAM% %FILE5%.%EXTENSION%	> %FILE5%.%OUTPUT%	2> %FILE5%.%ERROR%
%COMPILER% %PARAM% %FILE6%.%EXTENSION%	> %FILE6%.%OUTPUT%	2> %FILE6%.%ERROR%

:: SHOW OUTPUTS - - - - - - - - - - - - - - - - - - - - - - - - - - -
DIR *.OUT
DIR *.ERR

:: ---------------------------------------------------------------------
:: End of Tests (A22 - W22) --------------------------------------------
:: ---------------------------------------------------------------------
