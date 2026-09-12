public abstract class Account {

    private int accNo;
    private String name;
    private int age;
    private double balance;
    private String type;
    private double minBalance;

    public Account(int accNo, String name, int age, double balance, String type, double minBalance) {
        if (age < 18) {
            System.out.println("Age below 18, setting it to 18");
            age = 18;
        }
        if (balance < minBalance) {
            System.out.println("Balance below minimum, setting it to " + minBalance);
            balance = minBalance;
        }

        this.accNo = accNo;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.type = type;
        this.minBalance = minBalance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return false;
        }
        balance += amount;
        return true;
    }

    // protected, so only the accounts that really allow withdrawals expose it
    protected boolean take(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
            return false;
        }
        if (balance - amount < minBalance) {
            System.out.println("Withdrawal would breach minimum balance");
            return false;
        }
        balance -= amount;
        return true;
    }

    public int getAccNo() {
        return accNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }
}
