package Task_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Grade_Calculator {


    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
                scanner.nextLine();
            }
        }
    }//for error handling so if a user provides a mismatched input the program doesn't crash
    private static int getTheInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                if (input >= 0 && input <= 100) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 100.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }//for error handling so if a user provides a mismatched input the program doesn't crash

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }



    public static void main(String[] args){
        int numberSub;
        double sum=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number of subjects:");
        numberSub=getIntInput(scanner);

        for (int i=0;i<=numberSub;i++){

            int marks = getTheInput(scanner, "Enter marks for subject " + i + ": ");
            sum += marks;
        }
        double average=sum/numberSub;
        String grade=calculateGrade(average);
        System.out.println("Average : " + average + "%");
        System.out.println("Grade: " + grade);

        scanner.close();













    }
}
