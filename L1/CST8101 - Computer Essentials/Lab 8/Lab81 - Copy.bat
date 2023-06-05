@echo off
:menu
cls
echo Press 1 to run the ipconfig command
echo Press 2 to run the ipconfig /all
echo Press 3 to release current ip address
echo Press 4 to renew network ip address
echo Press 5 to flush dns
echo Press 6 to stop printer spooler
echo Press 7 to start pritner spooler
echo Press 8 to display user id (whoami /user)
echo Press 9 to create directory
echo Press 10 to check hardrive
echo Press 11 to change letters to green
echo Press 12 to change letters to yellow
echo Press 13 to change background to red
echo Press 14 to open paintbrush app
echo Press 15 to open cmd
echo Press 16 to stop batch file from running
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
if "%choice%"=="8" goto eight
if "%choice%"=="9" goto nine
if "%choice%"=="10" goto ten
if "%choice%"=="11" goto eleven
if "%choice%"=="12" goto twelve
if "%choice%"=="13" goto thirteen
if "%choice%"=="14" goto fourteen
if "%choice%"=="15" goto fifteen
if "%choice%"=="16" exit

if "%choice%"=="q" exit

:one
ipconfig
pause
goto menu

:two
ipconfig /all
pause
goto menu

:three
ipconfig /release
pause
goto menu

:four
ipconfig /renew
pause
goto menu

:five
ipconfig /flushdns
pause
goto menu

:six
net stop spooler
pause
goto menu

:seven
net start spooler
pause
goto menu

:eight
whoami /user
pause
goto menu

:nine
D:
md hello
pause
goto menu

:ten
CHKDSK D
pause
goto menu

:eleven
color 2
pause
goto menu

:twelve
color 6
pause
goto menu

:thirteen
color 4f
pause
goto menu

:fourteen
mspaint
pause
goto menu

:fifteen
start cmd.exe
pause
goto menu
