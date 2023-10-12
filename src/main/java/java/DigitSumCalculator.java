package java;

import java.util.Scanner;

public class DigitSumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for an integer input
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // Calculate the sum of digits
        int digitSum = calculateDigitSum(number);

        // Ensure that the result is an 8-digit string
        String result = String.format("%08d", digitSum);

        // Print the result
        System.out.println("8-digit Sum of digits: " + result);

        scanner.close();
    }

    public static int calculateDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10; // Add the last digit to the sum
            n /= 10;      // Remove the last digit
        }
        return sum;
    }
}
