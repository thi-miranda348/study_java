package day06;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the max number: ");
        int upperLimit = scanner.nextInt();

        System.out.print("Enter the attempt to guess: ");
        int maxAttempts = scanner.nextInt();

        Random random = new Random();
        int randomNum = random.nextInt(upperLimit) + 1;


        boolean won = false;

        for (int i = 0; i < maxAttempts; i++) {
            System.out.print("Enter your guess: ");
            int numGuess = scanner.nextInt();

            if (numGuess == randomNum) {
                System.out.println("Success! You guessed the secret number");
                won = true;
                break;

            } else {
                int remaining = maxAttempts - 1 - i;
                if (remaining > 0) {
                    System.out.println("Sorry, your guess is incorrect. You have " + remaining + " attempts left");
                }
            }


    } if (!won) {
            System.out.println("You did not win. The secret number was " + randomNum + ".");
        }

        scanner.close();
    }
}
