package day01;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // Concatenation example
        String productName = "iPhone 16 Pro";
        int quantity = 1;
        double price = 599.99;

        System.out.println("Product: " + productName + " | Stock: " + quantity + " | Price: $" + price);

        // Formatting Floating Point Numbers
        double oneNumber = 9982345675.88;

        // %.2f: number should be formatted as a (f) floating number with (2) digits to right of decimal point
        String formattedNumber = String.format("%.2f", oneNumber);
        System.out.println("Formatted Number: " + formattedNumber); // 9982345675.88
    }
}