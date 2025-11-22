package ua.model;

import ua.util.Utils;

public abstract class Account extends BaseEntity {

    private String accountNumber;
    private Customer owner;
    protected double balance;
    private Branch branch;

    public Account(long id, String accountNumber, Customer owner, double balance, Branch branch) {
        super(id);
        this.accountNumber = Utils.requireName(accountNumber, "Account number");
        this.owner = owner;
        this.balance = Utils.requireNonNegative(balance, "Balance");
        this.branch = branch;
    }

    public String getAccountNumber() { return accountNumber; }
    public Customer getOwner() { return owner; }
    public Branch getBranch() { return branch; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        balance += Utils.requirePositive(amount, "Deposit");
    }

    public void withdraw(double amount) {
        double a = Utils.requirePositive(amount, "Withdrawal");
        if (a > balance)
            throw new IllegalArgumentException("Insufficient funds");
        balance -= a;
    }

    public abstract void monthlyUpdate();

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " #" + accountNumber +
                " [" + Utils.formatMoney(balance) + "] Owner: " + owner;
    }
}
