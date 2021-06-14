package interfaces;

public class TaxReport {
    private ITaxCalculator calculator;

    // Constructor injection
    public TaxReport(ITaxCalculator calculator) {
        this.calculator = calculator;
    }

    public void show() {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

    // Method injection
    public void show(TaxCalculator calculator) {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

    // Field injection
    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }

}
