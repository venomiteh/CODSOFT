package Task_1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Number_Game {




    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 0 && input <= 100) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 100:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }




    public static boolean guessCheck(int guess, int number) {
        if (guess > number) {
            System.out.println("Too High!");
            return false;
        } else if (guess < number) {
            System.out.println("Too Low!");
            return false;
        } else {
            System.out.println("You got it right!!");
            return true;
        }
    }


    public static void playGame(Random rand, Scanner scanner) {
        int numberToGuess = rand.nextInt(101); // Generate the number once per game generates a number between 0 and 100
        int guess;
        int number_OF_Tries = 3;//this is the limited nb of tries

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + number_OF_Tries + " attempts to guess the number between 0 and 100.");

        for (int i = 0; i < number_OF_Tries; i++) {
            System.out.println("Enter your guess:");
            guess = getIntInput(scanner);
            boolean result = guessCheck(guess, numberToGuess);

            if (result) {
                break;
            } else {
                if (i < number_OF_Tries - 1) {
                    System.out.println("Try again!");
                } else {
                    System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
                }
            }
        }
    }












    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            playGame(rand, scanner);

            // Ask if the player wants to play again
            System.out.println("Do you want to play again? (yes/no)");
            String response = scanner.next().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        scanner.close();
        System.out.println("Thank you for playing!");
    }

}














