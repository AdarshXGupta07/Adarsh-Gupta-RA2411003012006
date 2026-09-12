public class SalaryAccount extends BankAccount {

    private String companyName;

    public SalaryAccount(int accountNumber, String name, int age, double balance, String companyName) {
        super(accountNumber, name, age, balance, "Salary");
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }
}
