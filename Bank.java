public class Bank {

    private NotificationService notifier;
    private AccountRepository repo;

    public Bank(NotificationService notifier, AccountRepository repo) {
        this.notifier = notifier;
        this.repo = repo;
    }

    public void deposit(Account acc, double amount) {
        if (acc.deposit(amount)) {
            notifier.send("Deposited Rs. " + amount + " in account " + acc.getAccNo());
            repo.save(acc);
        }
    }

    public void withdraw(Withdrawable acc, double amount) {
        if (acc.withdraw(amount)) {
            notifier.send("Withdrew Rs. " + amount);
        }
    }

    public void save(Account acc) {
        repo.save(acc);
    }

    public String find(int accNo) {
        return repo.find(accNo);
    }
}
