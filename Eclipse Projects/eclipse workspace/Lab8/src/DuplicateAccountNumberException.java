public class DuplicateAccountNumberException extends Exception {

	public DuplicateAccountNumberException () {
		System.err.println("The number you entered is already in use!");
	}
}