package Refactor;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AddressBook implements Comparable<AddressBook> {

    private String name;
    private String phoneNumber;
    private String email;
    private String city;


    // constructor, getters, and setters

    @Override
    public int compareTo(AddressBook other) {
        return this.name.compareTo(other.getName());
    }

    public String getName() {
        return name;
    }


    public String getFirstName() {
        return firstName;
    }

    private String firstName;
    private String lastName;
    private String address;
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
        return "[" + firstName + ", " + lastName + ",  " + address + ", " + city
                + ", " + state + ", " + zipcode + ", " + phonenum + ", " + emailId + "]";
    }
}
