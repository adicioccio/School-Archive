@echo off
:menu
cls
echo Press 1 to run the ipconfig command
echo Press 2 to run the whoami /user command
echo Press 3 to run another cmd
echo Press 4 to flush dns cache. (ipconfig /flushdns)
echo Press 5 to change background color to red
echo Press 6 to change color to green
echo Press 7 to change color to yellow
echo:
echo Press q to quit program

set /p choice="Enter the number of the operation you wish to run: "

if "%choice%"=="1" goto one
if "%choice%"=="2" goto two
if "%choice%"=="3" goto three
if "%choice%"=="4" goto four
if "%choice%"=="5" goto five
if "%choice%"=="6" goto six
if "%choice%"=="7" goto seven

if "%choice%"=="q" exit

:one
ipconfig
pause
goto menu

:two
whoami /user
pause
goto menu

:three
start cmd.exe
goto menu

:four
ipconfig /flushdns
pause
goto menu

:five
color 47
goto menu

:six
color 2
goto menu

:seven
color 6
goto menu
