package sample;

public class Customer {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phoneNum;
    private int customerId;

    public Customer() {
        firstName = "";
        lastName = "";
        dateOfBirth = "";
        phoneNum = "";
        customerId = 0;
    }

    public Customer(String firstIn, String lastIn, String dobIn, String phoneNum, int customerId) {
        firstName = firstIn;
        lastName = lastIn;
        dateOfBirth = dobIn;
        phoneNum = phoneNum;
        this.customerId = customerId;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
                ", phoneNum=" + phoneNum +
                ", customerId=" + customerId +
                '}';
    }
}
