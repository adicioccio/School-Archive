import java.util.Scanner;

public class Lab5 {

    public static native double calculateSTDDev( int [] numbers );
    public static native double calculateMean(int [] numbers );

    public static void main(String args[]) {
        program();
    }

    public static void program() {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of samples to generate");
        do {
            System.out.print(">");
            while (!scan.hasNextInt()) {
                System.out.print(">");
                scan.next();
            }
            input = scan.nextInt();
        } while (input <= 0);

        System.out.println("Generating array...");

        int [] array = new int[input];

        for(int i = 0; i <= array.length-1; i++) {
            array[i] = (int) (Math.random() * (100 - 0));
            System.out.println(array[i]);
        }

        System.out.println("calculateSTDDev output: " + calculateSTDDev(array));
        System.out.println("calculateMean output: " + calculateMean(array));
    }
}
