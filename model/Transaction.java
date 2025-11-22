package ua.model;

import ua.util.Utils;
import java.time.LocalDate;

public class Transaction extends BaseEntity {

    private Account fromAccount;
    private Account toAccount;
    private double amount;
    private LocalDate date;

    public Transaction(long id, Account from, Account to, double amount, LocalDate date) {
        super(id);
        this.fromAccount = from;
        this.toAccount = to;
        this.amount = Utils.requirePositive(amount, "Transaction amount");
        this.date = date != null ? date : LocalDate.now();
    }

    public static Transaction transfer(long id, Account from, Account to, double amount) {
        return new Transaction(id, from, to, amount, LocalDate.now());
    }

    @Override
    public String toString() {
        return "Transaction: " + fromAccount.getAccountNumber() + " → " +
                toAccount.getAccountNumber() + " | " + Utils.formatMoney(amount);
    }
}
