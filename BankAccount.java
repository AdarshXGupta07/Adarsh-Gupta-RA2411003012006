public class BankAccount {

    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;

    public BankAccount(int accountNumber, String name, int age, double balance, String accountType) {
        if (age < 18) {
            System.out.println("Age was below 18, correcting to 18");
            age = 18;
        }

        double minimumBalance;
        if (accountType.equals("Savings")) {
            minimumBalance = 500.0;
        } else {
            minimumBalance = 1000.0;
        }

        if (balance < minimumBalance) {
            System.out.println("Initial balance below minimum, correcting to " + minimumBalance);
            balance = minimumBalance;
        }

        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.accountType = accountType;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return false;
        }

        this.balance = this.balance + amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return false;
        }

        double minimumBalance;
        if (this.accountType.equals("Savings")) {
            minimumBalance = 500.0;
        } else {
            minimumBalance = 1000.0;
        }

        if (this.balance - amount < minimumBalance) {
            System.out.println("Withdrawal would breach minimum balance");
            return false;
        }

        this.balance = this.balance - amount;
        return true;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountType() {
        return this.accountType;
    }
}
