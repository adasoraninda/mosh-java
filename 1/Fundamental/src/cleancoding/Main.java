package cleancoding;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static void main(String[] args) {
        final int PRINCIPAL_MINIMUM = 1000;
        final int PRINCIPAL_MAXIMUM = 1_000_000;
        final float ANNUAL_INTEREST_MINIMUM = 1F;
        final float ANNUAL_INTEREST_MAXIMUM = 30F;
        final byte YEARS_MINIMUM = 1;
        final byte YEARS_MAXIMUM = 30;

        int principal = (int) readNumber("Principal ($1K - $1M): ", PRINCIPAL_MINIMUM, PRINCIPAL_MAXIMUM);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", ANNUAL_INTEREST_MINIMUM,
                ANNUAL_INTEREST_MAXIMUM);
        byte years = (byte) readNumber("Period (Years): ", YEARS_MINIMUM, YEARS_MAXIMUM);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
        return value;
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return mortgage;
    }

    public static void printMortgage(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");

        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        short numberOfPayments = (short) (years * MONTHS_IN_YEAR);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayments)
                        - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }

    }

}
