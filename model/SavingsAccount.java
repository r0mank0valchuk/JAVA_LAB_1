package ua.model;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(long id, String number, Customer owner, double balance,
                          Branch branch, double interestRate) {
        super(id, number, owner, balance, branch);
        this.interestRate = interestRate;
    }

    public static SavingsAccount of(long id, String num, Customer owner,
                                    double balance, Branch branch, double rate) {
        return new SavingsAccount(id, num, owner, balance, branch, rate);
    }

    @Override
    public void monthlyUpdate() {
        balance += balance * (interestRate / 100.0) / 12.0;
    }
}
