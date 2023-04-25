package com.bl;

import java.util.ArrayList;
import java.util.Scanner;

class Details{
    private String First_Name;
    private String Last_Name;
    private int Phone_Number;
    private String Email_id;
    private String Address;
    private String City;


    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public int getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(int phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getEmail_id() {
        return Email_id;
    }

    public void setEmail_id(String email_id) {
        Email_id = email_id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZip_Code() {
        return Zip_Code;
    }

    public void setZip_Code(int zip_Code) {
        Zip_Code = zip_Code;
    }

    private String State;
    private int Zip_Code;
}

public class AddressBook {
    private ArrayList<Details> Details;
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book Programme");
        Scanner ab = new Scanner(System.in);
        // Creating The First Contact
        Details a = new Details();
        System.out.println("Enter Your First Name: ");
        String first_name = ab.nextLine();
        System.out.println("Enter Your Last Name: ");
        String last_name = ab.nextLine();
        System.out.println("Enter Your Address: ");
        String address = ab.nextLine();
        System.out.println("Enter Your City: ");
        String city = ab.nextLine();
        System.out.println("Enter Your State: ");
        String state = ab.nextLine();
        System.out.println("Enter Your Email: ");
        String email = ab.nextLine();
        System.out.println("Enter Your Mobile Number: ");
        int phone_number = ab.nextInt();
        System.out.println("Enter Your Zip Code: ");
        int zip_code = ab.nextInt();

        System.out.println("New Contact: " + "\n" + "First Name: " +first_name+ " Last Name: " +last_name+ " Address: "+address+
                " City: " +city+ " State: " + state + " Email: "+ email+ " Mobile: "+ phone_number + " Postal: " + zip_code);
/*

        a.setAddress("Pasiyana");
        a.setFirst_Name("Sadiq");
        a.setLast_Name("Hussain");
        a.setPhone_Number(78286061);
        a.setEmail_id("ksadik320@gmail.com");
        a.setCity("jabalpur");
        a.setState("MadhyaPerdesh");
        a.setZip_Code(482004);

        System.out.println("Contact: " +
        a.getFirst_Name() +" "+
        a.getLast_Name() +" "+
        a.getCity() +" "+
        a.getPhone_Number() +" "+
        a.getState() +" "+
        a.getEmail_id() +" "+
        a.getZip_Code() +" "+
                a.getAddress());
        */

    }
}
//added to git