import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String name = null;
		int age = 0;
		Scanner scan = new Scanner(System.in);
		
		Cat c1 = new Cat();
		
		System.out.println("Create a new Cat!");
		
		System.out.print("Enter name\n>");
		name = scan.next();
		c1.setName(name);
		
		System.out.print("Enter age\n>");
		age = scan.nextInt();
		c1.setAge(age);
		
		c1.printInfo();
		
		scan.close();
		
	}

}
