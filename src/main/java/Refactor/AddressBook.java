package Refactor;

public class AddressBook {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private long phonenum;
    private String emailId;

    public AddressBook(String firstName, String lastName, String address, String city, String state, int zipcode, long phonenum, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phonenum = phonenum;
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public long getPhonenum() {
        return phonenum;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setPhonenum(long phonenum) {
        this.phonenum = phonenum;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "["+"First Name: " + firstName + ", Last Name: " + lastName + ", Address: " + address + ", City: " + city
                + ", State: " + state + ", Zipcode: " + zipcode + ", Phone Number: " + phonenum + ", Email: " + emailId+"]";
    }
}
