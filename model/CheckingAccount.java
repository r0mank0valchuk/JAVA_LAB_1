package ua.model;

public class CheckingAccount extends Account {

    private double monthlyFee;

    public CheckingAccount(long id, String number, Customer owner, double balance,
                           Branch branch, double monthlyFee) {
        super(id, number, owner, balance, branch);
        this.monthlyFee = monthlyFee;
    }

    public static CheckingAccount create(long id, String num, Customer owner,
                                         double balance, Branch branch, double fee) {
        return new CheckingAccount(id, num, owner, balance, branch, fee);
    }

    @Override
    public void monthlyUpdate() {
        if (balance >= monthlyFee)
            balance -= monthlyFee;
    }
}
