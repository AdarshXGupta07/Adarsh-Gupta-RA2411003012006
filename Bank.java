public class Bank {

    private NotificationService notifier;
    private AccountRepository repository;

    public Bank(NotificationService notifier, AccountRepository repository) {
        this.notifier = notifier;
        this.repository = repository;
    }

    public void deposit(BankAccount account, double amount) {
        if (account.deposit(amount)) {
            notifier.send("Deposit of Rs. " + amount + " was successful");
            repository.save(account);
        }
    }

    public void withdraw(BankAccount account, double amount) {
        if (account.withdraw(amount)) {
            notifier.send("Withdrawal of Rs. " + amount + " was successful");
            repository.save(account);
        }
    }

    public void showInterest(BankAccount account, InterestPolicy policy) {
        double interest = policy.calculate(account.getBalance());
        System.out.println("Interest for account " + account.getAccountNumber() + " is Rs. " + interest);
    }
}
