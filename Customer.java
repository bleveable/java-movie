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
    private int custID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    
    public Customer() {
        custID = -1;
        firstName = "";
        lastName = "";
        dateOfBirth = "";
        email = "";
    }
    
    public Customer(int idIn, String firstIn, String lastIn, String dobIn, String emailIn) {
        custID = idIn;
        firstName = firstIn;
        lastName = lastIn;
        dateOfBirth = dobIn;
        email = emailIn;
    }   
    
    public int getID() {
        return custID;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setID(int idIn) {
        custID = idIn;
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
    
    public void setEmail(String emailIn) {
        email = emailIn;
    }
    
     @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email=" + email +
                ", customerId=" + custID +
                '}';
    }
}
