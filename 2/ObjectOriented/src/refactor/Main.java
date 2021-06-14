package refactor;

import static refactor.MortgageCalculator.*;

public class Main {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", PRINCIPAL_MINIMUM, PRINCIPAL_MAXIMUM);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", ANNUAL_INTEREST_MINIMUM,
                ANNUAL_INTEREST_MAXIMUM);
        byte years = (byte) Console.readNumber("Period (Years): ", YEARS_MINIMUM, YEARS_MAXIMUM);

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterest, years);
        MortgageReport report = new MortgageReport(calculator);

        report.printMortgage();
        report.printPaymentSchedule();
    }

}
