package controlflow;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        final int PRINCIPAL_MINIMUM = 1000;
        final int PRINCIPAL_MAXIMUM = 1_000_000;
        final float ANNUAL_INTEREST_MINIMUM = 1F;
        final float ANNUAL_INTEREST_MAXIMUM = 30F;
        final byte YEARS_MINIMUM = 1;
        final byte YEARS_MAXIMUM = 30;

        Scanner scanner = new Scanner(System.in);

        int principal = 0;
        float annualInterest = 0F;
        float monthlyInterest = 0F;
        byte years = 0;
        int numberOfPayments = 0;

        // Principal
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if (principal >= PRINCIPAL_MINIMUM && principal <= PRINCIPAL_MAXIMUM) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        // Annual Interest
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= ANNUAL_INTEREST_MINIMUM && annualInterest <= ANNUAL_INTEREST_MAXIMUM) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value greater than " + (int) ANNUAL_INTEREST_MINIMUM
                    + " and less than or equal to " + (int) ANNUAL_INTEREST_MAXIMUM + ".");
        }

        // Years
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >= YEARS_MINIMUM && years <= YEARS_MAXIMUM) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between " + YEARS_MINIMUM + " and " + YEARS_MAXIMUM + ".");
        }

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);


        System.out.println("Mortgage: " + mortgageFormatted);

        scanner.close();

    }

}
