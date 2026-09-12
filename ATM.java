public class ATM implements Depositable, Withdrawable {

    private int id;
    private double cash;

    public ATM(int id, double cash) {
        this.id = id;
        this.cash = cash;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return false;
        }
        cash += amount;
        System.out.println("ATM " + id + " took in Rs. " + amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount > cash) {
            System.out.println("ATM " + id + " does not have that much cash");
            return false;
        }
        cash -= amount;
        System.out.println("ATM " + id + " gave out Rs. " + amount);
        return true;
    }
}
