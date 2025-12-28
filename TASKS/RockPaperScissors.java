import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String getChoice(int choice) {
        switch (choice) {
            case 0: return "Rock";
            case 1: return "Paper";
            case 2: return "Scissors";
            default: return "Invalid Choice";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int userScore = 0;
        int computerScore = 0;
        int totalRounds = 0;

        char playAgain;

        System.out.println("Welcome to Rock Paper Scissors Game!");

        do {
            System.out.println("Choose:");
            System.out.println("0 - Rock");
            System.out.println("1 - Paper");
            System.out.println("2 - Scissors");

            System.out.print("Enter your choice: ");
            int userChoice = sc.nextInt();

            int computerChoice = random.nextInt(3);
            totalRounds++;

            System.out.println("\nYou chose: " + getChoice(userChoice));
            System.out.println("Computer chose: " + getChoice(computerChoice));

            if (userChoice == computerChoice) {
                System.out.println("It's a Draw!");
            } 
            else if (
                (userChoice == 0 && computerChoice == 2) ||
                (userChoice == 1 && computerChoice == 0) ||
                (userChoice == 2 && computerChoice == 1)
            ) {
                System.out.println("You Win this round!");
                userScore++;
            } 
            else {
                System.out.println("Computer Wins this round!");
                computerScore++;
            }

            System.out.print("\nDo you want to play again? (y/n): ");
            playAgain = sc.next().toLowerCase().charAt(0);

        } while (playAgain == 'y');

        System.out.println("\nGame Over!");
        System.out.println("Your Score is: " + userScore + "/" + totalRounds);

        sc.close();
    }
}