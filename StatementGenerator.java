public class StatementGenerator {

    public String generate(BankAccount account) {
        String statement = "---- Account Statement ----\n";
        statement = statement + "Account Number: " + account.getAccountNumber() + "\n";
        statement = statement + "Name: " + account.getName() + "\n";
        statement = statement + "Age: " + account.getAge() + "\n";
        statement = statement + "Account Type: " + account.getAccountType() + "\n";
        statement = statement + "Current Balance: Rs. " + account.getBalance() + "\n";
        statement = statement + "---------------------------";
        return statement;
    }
}
