public class Main {

    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();
        NotificationService emailService = new EmailNotificationService();

        Bank bank = new Bank(emailService, repository);

        BankAccount savings = new BankAccount(101, "Ravi", 20, 5000, "Savings");
        BankAccount current = new BankAccount(102, "Meena", 30, 8000, "Current");
        SalaryAccount salary = new SalaryAccount(103, "Arjun", 25, 12000, "GreenLeaf Tech");

        InterestPolicy savingsPolicy = new SavingsInterestPolicy();
        InterestPolicy currentPolicy = new CurrentInterestPolicy();
        InterestPolicy salaryPolicy = new SalaryInterestPolicy();

        bank.deposit(savings, 1000);
        bank.withdraw(savings, 500);
        bank.deposit(current, 2000);
        bank.deposit(salary, 3000);

        System.out.println();

        bank.showInterest(savings, savingsPolicy);
        bank.showInterest(current, currentPolicy);
        bank.showInterest(salary, salaryPolicy);

        System.out.println();
        System.out.println("Switching to SMS without changing Bank");

        Bank smsBank = new Bank(new SMSNotificationService(), repository);
        smsBank.deposit(salary, 500);

        System.out.println();

        StatementGenerator statementGenerator = new StatementGenerator();
        System.out.println(statementGenerator.generate(salary));
        System.out.println("Salary credited by: " + salary.getCompanyName());
    }
}
