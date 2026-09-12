package bank.account;

import bank.capability.Depositable;
import bank.capability.StatementProvider;
import bank.capability.Transferable;
import bank.capability.Withdrawable;

public class SavingsAccount extends Account implements Depositable, Withdrawable, Transferable, StatementProvider {

    public SavingsAccount(int accNo, String name, int age, double balance) {
        super(accNo, name, age, balance, "Savings", 500.0);
    }

    public boolean withdraw(double amount) {
        return take(amount);
    }

    public boolean transfer(Depositable to, double amount) {
        if (!take(amount)) {
            return false;
        }
        return to.deposit(amount);
    }
}
