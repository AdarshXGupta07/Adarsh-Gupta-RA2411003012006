public class AccountRepository {

    public void save(Account account) {
        System.out.println("Saving account " + account.getAccountNumber() + " to database");
    }

    public void save(Withdrawable account) {
        System.out.println("Saving account " + account.getAccountNumber() + " to database");
    }
}
