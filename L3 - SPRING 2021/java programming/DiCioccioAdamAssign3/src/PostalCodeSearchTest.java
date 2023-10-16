

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Starter file for Assigment3 for CST8130-Fall2021
 * @author George Kriger
 */

public class PostalCodeSearchTest {
	
	/**
	 * main() which opens and read CSV file of Canadian postal codes
	 * @param args command line arguments (not used)
	 */
	public static void main(String[] args) {
		
		//create hash map
		HashMap<String, String> map = new HashMap<>();
		
		String filename = "ottawa_postal_codes.csv";
		Path file = Paths.get(filename);
		try (BufferedReader input = Files.newBufferedReader(file)) {
			String line = null;
			while ((line = input.readLine()) != null) {
				//create array of strings split by commas
				String[] stringArray = line.split(",");
				
				//set the key and value into variables
				String postalCode = stringArray[0];
				String information = stringArray[1] + " " + stringArray[2] + " " + stringArray[3] + " " + stringArray[4];
				
				//put into hash map
				map.put(postalCode, information);
				  
			}//while
		}
		catch (IOException ioException) {
			System.err.println("Error opening file");
			ioException.printStackTrace();

		}
		
		//repeat 10 times
		for (int i = 0; i < 10; i++) {
			//call output with hash map and the random prefix
			output(map, PostalCodeEntry.getRandomPrefix());
		}
		
		// no need to close input. Used try-with-resources above
	}// main()
	
	/**
	 * output method that prints out the key and the information related to it
	 * @param map is the hash map
	 * @param key is the randomly generated prefix
	 */
	public static void output(HashMap<String, String> map, String key) {
		
		System.out.println("Retrieving: " + key);
		
		if (map.containsKey(key)) {
			System.out.println("\t" + map.get(key));
		} else {
			System.out.println("\t NOT FOUND");
		}
	}
	
}// class


