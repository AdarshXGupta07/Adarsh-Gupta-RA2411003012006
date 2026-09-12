import java.util.ArrayList;
import java.util.List;

public class BeforeMain {

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new SavingsAccount(101, 5000));
        accounts.add(new FixedDepositAccount(104, 50000));

        System.out.println("Running the nightly withdrawal job");

        for (Account account : accounts) {
            account.withdraw(500);
        }

        System.out.println("Job finished");
    }
}
