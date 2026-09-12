public class SalaryAccount extends Account implements Withdrawable {

    private String companyName;

    public SalaryAccount(int accountNumber, String name, int age, double balance, String companyName) {
        super(accountNumber, name, age, balance, "Salary", 1000.0);
        this.companyName = companyName;
    }

    public boolean withdraw(double amount) {
        return takeMoneyOut(amount);
    }

    public String getCompanyName() {
        return this.companyName;
    }
}
