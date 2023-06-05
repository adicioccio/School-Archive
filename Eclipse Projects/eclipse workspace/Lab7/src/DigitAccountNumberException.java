
public class DigitAccountNumberException extends Exception {

	public DigitAccountNumberException () {
		System.err.println("Your input must consist of 8 digits or less!");
	}
}
