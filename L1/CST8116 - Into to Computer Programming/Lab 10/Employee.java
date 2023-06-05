/*
 * Author: Stanley Pieda
 * Date: Nov 16, 2020
 * Description: This class abstracts an Employee with fields for id and name.
 */
public class Employee {
	private int id;
	private String name;
	
	/*
	 * Default constructor, sets id to zero, name to empty String
	 */
	public Employee() {
		this(0, "");
	}
	
	/*
	 * Overloaded constructor, accepts id and name
	 */
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/*
	 * Accessor for id field
	 */
	public int getId() {
		return id;
	}

	/*
	 * Mutator for id field
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * Accessor for name field
	 */
	public String getName() {
		return name;
	}

	/*
	 * Mutator for name field
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Generates a String based on the fields with format:
	 * "Employee: id, name"
	 */
	public String createReport() {
		return String.format("Employee: %d, %s", id, name);
	}
	
}
