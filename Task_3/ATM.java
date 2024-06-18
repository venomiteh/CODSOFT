package Task_3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {

    ArrayList<Cards> cards;
    private Cards currentCard;

    public ATM(ArrayList<Cards> cards) {
        this.cards = cards;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        if (!login(scanner)) {
            System.out.println("Invalid login. Exiting.");
            return;
        }

        boolean exit = false;
        while (!exit) {
            displayMenu();
            System.out.print("Choose an option: ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = getDoubleInput(scanner);
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = getDoubleInput(scanner);
                    withdraw(withdrawalAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private boolean login(Scanner scanner) {
        System.out.print("Enter card number: ");
        int cardNumber = getIntInput(scanner);
        System.out.print("Enter PIN: ");
        int pin = getIntInput(scanner);

        for (Cards card : cards) {
            if (card.getCardNumber() == cardNumber && card.getPin() == pin) {
                currentCard = card;
                return true;
            }
        }
        return false;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", currentCard.getAccount().getBalance());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            currentCard.getAccount().deposit(amount);
            System.out.printf("You have successfully deposited $%.2f%n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (currentCard.getAccount().withdraw(amount)) {
            System.out.printf("You have successfully withdrawn $%.2f%n", amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                int input = scanner.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
                scanner.nextLine();
            }
        }
    }//for error handling so the program doesn't crash if we have an input mismatch

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                double input = scanner.nextDouble();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number:");
                scanner.nextLine();
            }
        }
    }//for error handling so the program doesn't crash if we have an input mismatch

    public static void main(String[] args) {
        ArrayList<Cards> cardsList = new ArrayList<>();
        cardsList.add(new Cards(1234, 567, 1000.0, 0.05, 111222333));
        cardsList.add(new Cards(2345, 678, 2000.0, 0.05, 111222334));

        ATM atm = new ATM(cardsList);
        atm.run();
    }
}
