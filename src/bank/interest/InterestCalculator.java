package bank.interest;

public class InterestCalculator {

    public double calculate(String type, double balance) {
        if (type.equals("Savings")) {
            return balance * 0.04;
        } else if (type.equals("Current")) {
            return balance * 0.01;
        } else {
            return 0.0;
        }
    }
}
