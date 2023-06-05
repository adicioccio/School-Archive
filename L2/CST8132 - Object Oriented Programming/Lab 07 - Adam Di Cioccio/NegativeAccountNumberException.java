
public class NegativeAccountNumberException extends Exception {

	public NegativeAccountNumberException() {
		System.err.println("Your input value cannot be a negative number!");
	}
}
