public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(101, "Ravi", 17, 200, "Savings");

        AccountRepository repository = new AccountRepository();
        NotificationService notifier = new NotificationService();
        StatementGenerator statementGenerator = new StatementGenerator();

        if (account.deposit(1000)) {
            notifier.send("Deposit of Rs. 1000 was successful");
            repository.save(account);
        }

        if (account.withdraw(500)) {
            notifier.send("Withdrawal of Rs. 500 was successful");
            repository.save(account);
        }

        if (account.withdraw(5000)) {
            notifier.send("Withdrawal of Rs. 5000 was successful");
            repository.save(account);
        }

        System.out.println(statementGenerator.generate(account));
    }
}
