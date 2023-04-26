package com.bl;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AddContact {

    public static void main(String[] args) {

        // Collection<AddressBook> a = new ArrayList<AddressBook>();
        List<AddressBook> a = new ArrayList<AddressBook>();
        Scanner s1 = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("Press 1 for Insert");
            System.out.println("Press 2 for Display");
            System.out.println("Press 3 for Search");
            System.out.println("Press 4 for Delete");
            System.out.println("Press 5 for Update");
            System.out.println("Press 0 for exit");
            System.out.print("Enter your choice: ");
            ch = s1.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Serial number: ");
                    int srnum = s1.nextInt();
                    System.out.print("Enter First name: ");
                    String first_name = sc.nextLine();
                    System.out.print("Enter last name: ");
                    String last_name = sc.nextLine();
                    System.out.print("Enter address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter state: ");
                    String state = sc.nextLine();
                    System.out.print("Enter zip: ");
                    int zip_code = s1.nextInt();
                    System.out.print("Enter phone: ");
                    long phone_number = s2.nextLong();
                    System.out.print("Enter email: ");
                    String email_id = sc.nextLine();
                    a.add(new AddressBook(srnum, first_name, last_name, address, state, zip_code, phone_number, email_id));
                    break;

                case 2:
                    // System.out.println(a);
                    System.out.println("*************");
                    Iterator<AddressBook> i = a.iterator();
                    while (i.hasNext()) {
                        AddressBook addr = i.next();
                        System.out.println(addr);
                    }
                    System.out.println("*************");

                    System.out.println("*************");
                    break;
            }
        } while (ch != 0);

    }
}