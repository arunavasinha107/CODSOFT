import java.util.Scanner;
import java.util.Random;

public class Number_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min_Range = 1;
        int max_Range = 100;
        int max_Attempts = 10;
        int score = 0;

        System.out.println("!!!!!!! Welcome to the Number Guessing Game !!!!!!!");

        do {
            int secretNumber = random.nextInt(max_Range - min_Range + 1) + min_Range;
            int attempts = 0;
            boolean Correctguess = false;

            System.out.println("I have chosen a number between " + min_Range + " and " + max_Range + ".");
            System.out.println("Can you guess the secret no?");

            while (attempts < max_Attempts && !Correctguess) {
                int guess = getValidGuess(scanner, min_Range, max_Range);
                attempts = attempts + 1;

                if (guess == secretNumber) {
                    Correctguess = true;
                    score += max_Attempts - attempts + 1;
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                } else if (guess > secretNumber) {
                    System.out.println("You guessed it wrong, Guess a smaller no");
                } else {
                    System.out.println("You guessed it wrong, Guess a higher no");
                }
            }

            if (!Correctguess) {
                System.out.println("Sorry, you have reached the maximum number of attempts.");
                System.out.println("The secret number was: " + secretNumber);
            }

            System.out.print("Do you want to play again? (y/n): ");
        } while (scanner.next().equalsIgnoreCase("y"));

        System.out.println("Your total score: " + score);
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static int getValidGuess(Scanner scanner, int min, int max) {
        int user_guess;

        while (true) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                user_guess = scanner.nextInt();
                if (user_guess >= min && user_guess <= max) {
                    break;
                } else {
                    System.out.println("Your guess should be between " + min + " and " + max + ".");
                }
            } else {
                scanner.next();
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return user_guess;
    }
}