package refactor;

public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    public static final int PRINCIPAL_MINIMUM = 1000;
    public static final int PRINCIPAL_MAXIMUM = 1_000_000;
    public static final float ANNUAL_INTEREST_MINIMUM = 1F;
    public static final float ANNUAL_INTEREST_MAXIMUM = 30F;
    public static final byte YEARS_MINIMUM = 1;
    public static final byte YEARS_MAXIMUM = 30;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public int getPrincipal() {
        return principal;
    }

    public float getAnnualInterest() {
        return annualInterest;
    }

    public byte getYears() {
        return years;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }

    public double[] getRemainingBalance() {
        double[] balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    public double calculateMortgage() {
        double mortgage = principal * (getMonthlyInterest() * Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);

        return mortgage;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        double balance = principal
                * (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments())
                        - Math.pow(1 + getMonthlyInterest(), numberOfPaymentsMade))
                / (Math.pow(1 + getMonthlyInterest(), getNumberOfPayments()) - 1);

        return balance;
    }

}