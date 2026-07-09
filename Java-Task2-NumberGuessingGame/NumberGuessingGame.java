import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> scoreBoard = new ArrayList<>();

        int round = 1;
        boolean playAgain = true;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        while (playAgain) {

            int maxNumber = 100;
            int maxAttempts = 7;

            // Difficulty Selection
            System.out.println("\nChoose Difficulty:");
            System.out.println("1. Easy (1-50, 10 Attempts)");
            System.out.println("2. Medium (1-100, 7 Attempts)");
            System.out.println("3. Hard (1-200, 5 Attempts)");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    break;

                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    break;

                case 3:
                    maxNumber = 200;
                    maxAttempts = 5;
                    break;

                default:
                    System.out.println("Invalid choice. Medium selected.");
                    maxNumber = 100;
                    maxAttempts = 7;
            }

            int secretNumber = random.nextInt(maxNumber) + 1;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("Guess the number between 1 and " + maxNumber);

            while (attempts < maxAttempts) {

                System.out.println("\nAttempts Left: " + (maxAttempts - attempts));
                System.out.print("Enter your guess: ");

                int guess = sc.nextInt();
                attempts++;

                if (guess > secretNumber) {
                    System.out.println("Too High!");
                } else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Correct!");
                    System.out.println("You guessed the number in " + attempts + " attempt(s).");
                    guessed = true;
                    break;
                }
            }

            if (!guessed) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + secretNumber);
                scoreBoard.add("Round " + round + " - Lost");
            } else {
                scoreBoard.add("Round " + round + " - Guessed in " + attempts + " attempts");
            }

            // Display Scoreboard
            System.out.println("\n========== SCOREBOARD ==========");
            for (String score : scoreBoard) {
                System.out.println(score);
            }

            // Play Again
            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = sc.next();

            if (!answer.equalsIgnoreCase("yes")) {
                playAgain = false;
            }

            round++;
        }

        System.out.println("\n=================================");
        System.out.println("Thanks for playing!");
        System.out.println("Final Scoreboard:");

        for (String score : scoreBoard) {
            System.out.println(score);
        }

        sc.close();
    }
}
