package ua.model;

import ua.util.Utils;

public class Customer extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;

    public Customer(long id, String firstName, String lastName, String email) {
        super(id);
        this.firstName = Utils.requireName(firstName, "First name");
        this.lastName = Utils.requireName(lastName, "Last name");
        this.email = Utils.requireName(email, "Email");
    }

    public static Customer of(long id, String fn, String ln, String email) {
        return new Customer(id, fn, ln, email);
    }

    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName; }
    public String getEmail()     { return email; }

    public void setEmail(String email) {
        this.email = Utils.requireName(email, "Email");
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + email + ")";
    }
}
