/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamovie;

/**
 *
 * @author Brijian
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private int customerId;

    public Customer() {
        firstName = "";
        lastName = "";
        dateOfBirth = "";
        email = "";
        customerId = 0;
    }

    public Customer(int customerID, String firstIn, String lastIn, String dobIn, String email) {
        firstName = firstIn;
        lastName = lastIn;
        dateOfBirth = dobIn;
        this.email = email;
        this.customerId = customerID;
    }

    public String getFirst() {
        return firstName;
    }

    public String getLast() {
        return lastName;
    }

    public String getDob() {
        return dateOfBirth;
    }

    public void setFirst(String firstIn) {
        firstName = firstIn;
    }

    public void setLast(String lastIn) {
        lastName = lastIn;
    }

    public void setDob(String dobIn) {
        dateOfBirth = dobIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNum=" + email +
                ", customerId=" + customerId +
                '}';
    }
}
