import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            System.out.println("\nLet's Start the Game!");
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            final int MAX_ATTEMPTS = 5;
            boolean guessedCorrectly = false;
            System.out.println("Guess the number (between 1 and 100). You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + ": Your guess: ");
                int userGuess;
                try {
                    userGuess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter a number between 1 to 100.");
                    scanner.next();
                    continue;
                }
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've run out of attempts! The correct number was " + numberToGuess + ".");
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine();
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("Game over! Your total score: " + score);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}