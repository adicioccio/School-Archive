

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Hashtable;

/**
 * Starter file for Lab6 for CST8130-Fall2021
 * @author George Kriger
 */

public class PostalCodeSearchTest {

	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		
		// create hash table using java generics
		Hashtable<Object,Object> table = new Hashtable<>();
		
		String filename = "ottawa_postal_codes_prefix_only.csv";
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			while ((line = input.readLine()) != null) {
				//set postal code into value
				String value = line;
				
				//set h to the postal codes hash code
				int h = value.hashCode(); 
				h = h % 25; //tableSize is the size of the table (e.g. 25) 
				if (h < 0) { 
					h = -h; 
				}
				//set into the hash map
				table.put(h, value);
				
			}//while
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();

		} 
		// no need to close input. Used try-with-resources above
		
		System.out.println("Generating random prefixes...\n");
		
		for(int i=0; i<10; i++) {
			//get random prefix and set into prefix
			String prefix = getRandomPrefix();
		
			System.out.print("Retrieving: " + prefix);
			
			//if found
			if (table.contains(prefix)) {
				System.out.print(" FOUND");		
			//not found
			} else {
				System.out.print(" NOT FOUND");
			}
			
			System.out.println();
		}
	}// main()

	// create random generator once. To be used for the life of main(). Global
	// visibility
	// provide a seed value to get same random sequence
	// remove seed after testing
//	final static SecureRandom rand = new SecureRandom("abcdefghijklmnop".getBytes());
	
	final static SecureRandom rand = new SecureRandom();
	final static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String number = "0123456789";

	/**
	 * randomly generate a prefix using the correct format for Canadian postal codes
	 * 
	 * @return randomly generated prefix of the postal code
	 */
	public static String getRandomPrefix() {
		int randA = rand.nextInt(alpha.length());
		int randN = rand.nextInt(number.length());

		return "K" + number.charAt(randN) + alpha.charAt(randA);
	}// getRandomPrefix()

}// class
