package com.bl;

import java.util.*;

public class AddContact {
    List<AddressBook> add = new ArrayList<>();
    AddressBook obj = new AddressBook();
    Scanner ab = new Scanner(System.in);

    public void insertion(){

        System.out.println("Enter First Name: ");
        obj.setFirst_Name(ab.next());
        System.out.println("Enter Last Name: ");
        obj.setLast_Name(ab.next());
        System.out.println("Enter Address: ");
        obj.setAddress(ab.next());
        System.out.println("Enter City: ");
        obj.setCity(ab.next());
        System.out.println("Enter State: ");
        obj.setState(ab.next());
        System.out.println("Enter Number: ");
        obj.setPhone_Number(ab.nextDouble());
        System.out.println("Enter Pincode: ");
        obj.setZip_Code(ab.nextInt());
        System.out.println("Enter MailAdd: ");
        obj.setEmail_id(ab.next());

    }
    public static void main(String[] args) {
        List<AddressBook> add = new ArrayList<>();
        AddContact addC = new AddContact();
        Scanner A1 = new Scanner(System.in);
        int Menu;
        do {
            System.out.println("Press 1 for Insert");
            Menu = A1.nextInt();
            switch (Menu) {
                case 1:
                    addC.insertion();
                    break;
            }
        }
        while (Menu != 0);
    }
}
