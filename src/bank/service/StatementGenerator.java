package bank.service;

import bank.capability.StatementProvider;

public class StatementGenerator {

    public String generate(StatementProvider acc) {
        String s = "---- Statement ----\n";
        s += "Account: " + acc.getAccNo() + "\n";
        s += "Name: " + acc.getName() + "\n";
        s += "Age: " + acc.getAge() + "\n";
        s += "Type: " + acc.getType() + "\n";
        s += "Balance: Rs. " + acc.getBalance() + "\n";
        s += "-------------------";
        return s;
    }
}
