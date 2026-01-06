package day01;
import java.util.Scanner;


public class PracticeTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String Practice
        System.out.print("Enter your name: ");

        String myName = scanner.nextLine();
        System.out.println("Length of your name: " + myName.length());

        System.out.println("Uppercase: " + myName.toUpperCase());
        System.out.println("Lowercase: " + myName.toLowerCase());


        // Integer practice
        System.out.print("Enter your year of birth (yyyy): ");

        int birthYear = scanner.nextInt();
        // Calculate the age
        int age = 2026 - birthYear;
        System.out.println("-> You are " + age + " years old.");

        //Double Practice
        System.out.print("Enter your desired salary (e.g., 5000.50): ");
        double salary = scanner.nextDouble();


        // Implicit Casting (Convert a number of smaller type to a larger type)
        // Explicit Casting ( Covert a larger type to smaller type
        int roundedSalary = (int) salary;

        System.out.println("-> Exact Salary: " + salary);
        System.out.println("-> Rounded Salary (Casted): " + roundedSalary);
        scanner.nextLine();

        //Convert String to Int
        String number = "48";
        int count = Integer.parseInt(number);
        System.out.println(count);

        scanner.close();
    }

}
