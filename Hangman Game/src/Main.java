import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static String drawHangman(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """
                    |
                    |
                    |
                    |
                    |
                    |
                    """;
            case 1 -> """
                    |---|
                    |
                    |
                    |
                    |
                    |
                    """;
            case 2 -> """
                    |---|
                    |   O
                    |
                    |
                    |
                    |
                    """;
            case 3 -> """
                    |---|
                    |   O
                    |   |
                    |
                    |
                    |
                    """;
            case 4 -> """
                    |---|
                    |   O
                    |  /|
                    |
                    |
                    |
                    """;
            case 5 -> """
                    |---|
                    |   O
                    |  /|\\
                    |
                    |
                    |
                    """;
            case 6 -> """
                    |---|
                    |   O
                    |  /|\\
                    |  / \\
                    |
                    |
                    """;
            default -> "Invalid state";
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        ArrayList<Character> guessedLetters = new ArrayList<>();

        String word = "watermelon"; //Or use scanner to take user input
        int wrongGuesses = 0;

        // Initialize word state
        for(int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("Welcome to Hangman!");

        while(wrongGuesses < 6) {
            // Display current state
            System.out.println("\nCurrent word: " + String.join(" ", wordState.toString()));
            System.out.println(drawHangman(wrongGuesses));
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.println("Guess a letter: ");

            // Get and validate input
            char guess = scanner.next().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter!");
                continue;
            }

            guessedLetters.add(guess);
            boolean correctGuess = false;

            // Check guess
            for(int i = 0; i < word.length(); i++) {
                if(word.charAt(i) == guess) {
                    wordState.set(i, guess);
                    correctGuess = true;
                }
            }

            if(!correctGuess) {
                wrongGuesses++;
                System.out.println("Wrong guess! You have " + (6 - wrongGuesses) + " guesses left.");
            } else {
                System.out.println("Correct guess!");
            }

            // Check win condition
            if(!wordState.contains('_')) {
                System.out.println("\nCongratulations! You win!");
                System.out.println("The word was: " + word);
                break;
            }

            // Check lose condition
            if(wrongGuesses == 6) {
                System.out.println("\nGame Over! You lost!");
                System.out.println("The word was: " + word);
                System.out.println(drawHangman(wrongGuesses));
            }
        }

        scanner.close();
    }
}
