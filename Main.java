import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();
        NotificationService emailService = new EmailNotificationService();
        Bank bank = new Bank(emailService, repository);

        SavingsAccount savings = new SavingsAccount(101, "Ravi", 20, 5000);
        CurrentAccount current = new CurrentAccount(102, "Meena", 30, 8000);
        SalaryAccount salary = new SalaryAccount(103, "Arjun", 25, 12000, "GreenLeaf Tech");
        FixedDepositAccount fixedDeposit = new FixedDepositAccount(104, "Priya", 28, 50000, 12);

        List<Account> allAccounts = new ArrayList<Account>();
        allAccounts.add(savings);
        allAccounts.add(current);
        allAccounts.add(salary);
        allAccounts.add(fixedDeposit);

        System.out.println("Deposit run for every account");

        for (Account account : allAccounts) {
            bank.deposit(account, 1000);
        }

        System.out.println();
        System.out.println("Interest run for every account");

        bank.showInterest(savings, new SavingsInterestPolicy());
        bank.showInterest(current, new CurrentInterestPolicy());
        bank.showInterest(salary, new SalaryInterestPolicy());
        bank.showInterest(fixedDeposit, new FixedDepositInterestPolicy());

        System.out.println();
        System.out.println("Nightly withdrawal job");

        List<Withdrawable> withdrawableAccounts = new ArrayList<Withdrawable>();
        withdrawableAccounts.add(savings);
        withdrawableAccounts.add(current);
        withdrawableAccounts.add(salary);

        for (Withdrawable account : withdrawableAccounts) {
            bank.withdraw(account, 500);
        }

        System.out.println("Job finished without any crash");
        System.out.println("The fixed deposit was never added to the list, so it was never asked to withdraw");

        System.out.println();

        StatementGenerator statementGenerator = new StatementGenerator();
        System.out.println(statementGenerator.generate(fixedDeposit));
        System.out.println("Locked for " + fixedDeposit.getTermInMonths() + " months");
    }
}
