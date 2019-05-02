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
    
    public Customer() {
        firstName = "";
        lastName = "";
        dateOfBirth = "";
        email = "";
    }
    
    public Customer(String firstIn, String lastIn, String dobIn, String emailIn) {
        firstName = firstIn;
        lastName = lastIn;
        dateOfBirth = dobIn;
        email = emailIn;
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
}
