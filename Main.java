import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // change this one line to switch where accounts are stored
        AccountRepository repo = new FileAccountRepository("accounts.txt");
        Bank bank = new Bank(new EmailNotificationService(), repo);

        SavingsAccount savings = new SavingsAccount(101, "Ravi", 20, 5000);
        CurrentAccount current = new CurrentAccount(102, "Meena", 30, 8000);
        SalaryAccount salary = new SalaryAccount(103, "Arjun", 25, 12000, "GreenLeaf Tech");
        FixedDepositAccount fd = new FixedDepositAccount(104, "Priya", 28, 50000, 12);

        List<Account> accounts = new ArrayList<>();
        accounts.add(savings);
        accounts.add(current);
        accounts.add(salary);
        accounts.add(fd);

        for (Account acc : accounts) {
            bank.deposit(acc, 1000);
        }

        System.out.println();
        savings.transfer(current, 2000);
        System.out.println("Transferred 2000 from savings to current");

        System.out.println();
        List<Withdrawable> canWithdraw = new ArrayList<>();
        canWithdraw.add(savings);
        canWithdraw.add(current);
        canWithdraw.add(salary);

        for (Withdrawable acc : canWithdraw) {
            bank.withdraw(acc, 500);
        }

        for (Account acc : accounts) {
            bank.save(acc);
        }

        System.out.println();
        System.out.println("Account 101 in the store: " + bank.find(101));

        System.out.println();
        ATM atm = new ATM(1, 20000);
        atm.deposit(500);
        atm.withdraw(2000);

        System.out.println();
        salary.applyForLoan(50000);
        salary.applyForLoan(5000000);

        System.out.println();
        InterestPolicy savingsPolicy = new SavingsInterestPolicy();
        InterestPolicy fdPolicy = new FixedDepositInterestPolicy();
        System.out.println("Interest on 101: " + savingsPolicy.calculate(savings.getBalance()));
        System.out.println("Interest on 104: " + fdPolicy.calculate(fd.getBalance()));

        System.out.println();
        StatementGenerator gen = new StatementGenerator();
        System.out.println(gen.generate(savings));
        System.out.println(salary.getCompany() + " pays into account " + salary.getAccNo());
        System.out.println("FD 104 is locked for " + fd.getMonths() + " months");
    }
}
