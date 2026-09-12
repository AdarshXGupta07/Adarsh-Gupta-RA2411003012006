package bank.interest;

public class FixedDepositInterestPolicy implements InterestPolicy {

    public double calculate(double balance) {
        return balance * 0.07;
    }
}
