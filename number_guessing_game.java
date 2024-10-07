//Task 1 - Number Guess Game

import java.util.Random; // For generating random numbers
import java.util.*; // For getting input from the user

public class number_game {

    // Method to play one round of the game with a fixed 3 attempts
    public static int playRound() {
        Random random = new Random(); // Create a random number generator
        int randomNumber = random.nextInt(1,101); // Generate a number between 1 and 100
        Scanner scanner = new Scanner(System.in); // Create a scanner to get user input

        int maxAttempts = 3; // The number of guesses allowed is fixed to 3
        System.out.println("Guess a number between 1 and 100:");

        // The user has exactly 3 attempts to guess the number
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int guess = scanner.nextInt(); // Get the user's guess

            // Check if the guess is correct
            if (guess == randomNumber) {
                System.out.println("Correct! You guessed the number.");
                return attempt; // Return the number of attempts taken
            }
            // If the guess is lower than the random number
            else if (guess < randomNumber) {
                System.out.println("Your guess is too low.");
            }
            // If the guess is higher than the random number
            else {
                System.out.println("Your guess is too high.");
            }
        }

        // If the user runs out of attempts, reveal the correct number
        System.out.println("Out of attempts! The correct number was: " + randomNumber);
        return maxAttempts; // Return maxAttempts when the user didn't guess correctly
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner to get user input

        int totalScore = 0; // Keep track of the user's score
        int roundsWon = 0; // Track how many rounds the user wins
        boolean playAgain = true; // Boolean to control if the user wants to play again

        // Welcome the player to the game
        System.out.println("Welcome to the Number Guessing Game!");

        // Main game loop: keep playing rounds as long as the user wants
        while (playAgain) {
            System.out.println("\nStarting a new round...");
            // Play one round of the game
            int attemptsTaken = playRound(); // Fixed to 3 attempts per round

            // If the user won the round
            if (attemptsTaken < 3) {
                roundsWon++; // Increase the number of rounds won
                totalScore += (3 - attemptsTaken) * 10; // Calculate score (fewer attempts = higher score)
                System.out.println("You won this round in " + attemptsTaken + " attempts.");
            } else {
                System.out.println("You lost this round.");
            }

            // Ask the user if they want to play another round
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next(); // Get the user's answer

            // If the user says no, end the game
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }

        // Game over, display the final score
        System.out.println("\nGame Over!");
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Your final score: " + totalScore);
    }
}
