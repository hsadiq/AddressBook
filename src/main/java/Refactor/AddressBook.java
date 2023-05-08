package Refactor;

public class AddressBook {


    private String firstName;
    private String lastName;
    private String address;
    private String state;
    private int zipCode;
    private long phoneNumber;
    private String emailId;
    private String City;

    public AddressBook(String firstName, String lastName, String address, String city, String state, int zipCode, long phoneNumber, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.City = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public String getFirstName() {
        this.firstName = firstName;
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nAddress: " + address +
                "\nState: " + state +
                "\nZip Code: " + zipCode +
                "\nPhone Number: " + phoneNumber +
                "\nEmail ID: " + emailId + "\n";
    }
}

