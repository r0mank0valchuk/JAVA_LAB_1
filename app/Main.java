package ua.app;

import ua.model.*;

public class Main {
    public static void main(String[] args) {

        Customer c1 = Customer.of(1, "Nastya", "Koshova", "nastia@mail.com");
        Branch b1 = Branch.create(10, "Central", "Kyiv");

        Account acc1 = new CheckingAccount(101, "CHK-001", c1, 1000, b1, 10);
        Account acc2 = new SavingsAccount(102, "SVG-111", c1, 5000, b1, 12);

        System.out.println("Accounts:");
        System.out.println(acc1);
        System.out.println(acc2);

        System.out.println("\nTransactions:");
        acc1.withdraw(200);
        acc2.deposit(300);
        Transaction t1 = Transaction.transfer(9001, acc1, acc2, 150);
        System.out.println(t1);

        System.out.println("\nMonthly updates:");
        acc1.monthlyUpdate();  // fee
        acc2.monthlyUpdate();  // interest
        System.out.println(acc1);
        System.out.println(acc2);

        System.out.println("\nLoans:");
        Loan l1 = Loan.create(5000, c1, 10_000, 7.5);
        System.out.println(l1);

        System.out.println("\nValidation test:");
        try {
            acc1.deposit(-10);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
