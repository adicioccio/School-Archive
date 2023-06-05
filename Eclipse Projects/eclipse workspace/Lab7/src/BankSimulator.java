import java.util.Scanner;

/*
Adam Di Cioccio
41019241 - Lab 07 
Bank simulator w exceptions 
Rejaul Chowdhury - 3/21/2021
*/

//interface
interface BankSimulator {

	// interface methods to be implemented
	public String toString();
	public void addBankAccount(Scanner input);
	public void updateBalance(double d);

}
