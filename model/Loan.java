package ua.model;

import ua.util.Utils;
import java.time.LocalDate;

public class Loan extends BaseEntity {

    private Customer customer;
    private double amount;
    private double interestRate;
    private LocalDate startDate;

    public Loan(long id, Customer customer, double amount, double rate, LocalDate startDate) {
        super(id);
        this.customer = customer;
        this.amount = Utils.requirePositive(amount, "Loan amount");
        this.interestRate = Utils.requirePositive(rate, "Interest rate");
        this.startDate = startDate;
    }

    public static Loan create(long id, Customer c, double amount, double rate) {
        return new Loan(id, c, amount, rate, LocalDate.now());
    }

    @Override
    public String toString() {
        return "Loan: " + customer + ", amount=" + amount + ", rate=" + interestRate + "%";
    }
}
