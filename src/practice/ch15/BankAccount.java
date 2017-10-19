package practice.ch15;

public class BankAccount {
    private int balance = 100;

    public int getBalance() {
        return balance;
    }

    public synchronized void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(int withdrawAmount) {
        balance = balance - withdrawAmount;
    }
}
