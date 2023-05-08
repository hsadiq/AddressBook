//package com.bl;
//
//import java.util.*;
//
//public class AddContact {
//
//    public static void main(String[] args) {
//
//        List<AddressBook> a = new ArrayList<>();
//        HashMap<String, AddressBook> map = new HashMap<>();
//        Scanner s1 = new Scanner(System.in);
//        Scanner sc = new Scanner(System.in);
//        Scanner s2 = new Scanner(System.in);
//        int ch;
//        do {
//            System.out.println("Press 1 for Insert");
//            System.out.println("Press 2 for Display");
//            System.out.println("Press 3 for Search");
//            System.out.println("Press 4 for Delete");
//            System.out.println("Press 5 for Update");
//            System.out.println("Press 0 for exit");
//            System.out.print("Enter your choice: ");
//            ch = s1.nextInt();
//            switch (ch) {
//                case 1:
//                    System.out.print("Enter Serial number: ");
//                    int srnum = s1.nextInt();
//                    System.out.print("Enter First name: ");
//                    String first_name = sc.nextLine();
//                    System.out.print("Enter last name: ");
//                    String last_name = sc.nextLine();
//                    System.out.print("Enter address: ");
//                    String address = sc.nextLine();
//                    System.out.print("Enter state: ");
//                    String state = sc.nextLine();
//                    System.out.print("Enter zip: ");
//                    int zip_code = s1.nextInt();
//                    System.out.print("Enter phone: ");
//                    long phone_number = s2.nextLong();
//                    System.out.print("Enter email: ");
//                    String email_id = sc.nextLine();
//                    a.add(new AddressBook(srnum, first_name, last_name, address, state, zip_code, phone_number, email_id));
//                    break;
//
//                case 2:
//                    System.out.println("******Contact Adding******");
//
//                case 3:
//                    // System.out.println(a);
//                    System.out.println("*************");
//                    Iterator<AddressBook> i = a.iterator();
//                    while (i.hasNext()) {
//                        AddressBook addr = i.next();
//                        System.out.println(addr);
//                    }
//                    System.out.println("*************");
//                    break;
//
//                case 4:
//                    boolean found = false;
//                    System.out.println("Enter serial number to search: ");
//                    srnum = s1.nextInt();
//                    System.out.println("*************");
//                    i = a.iterator();
//                    while (i.hasNext()) {
//                        AddressBook addr = i.next();
//                        if (addr.getSrnum() == srnum) {
//                            System.out.println(addr);
//                            found = true;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Entered Number Record Not matched");
//                    }
//                    System.out.println("*************");
//                    break;
//
//                case 5:
//                    found = false;
//                    System.out.println("Enter serial number to delete: ");
//                    srnum = s1.nextInt();
//                    System.out.println("*************");
//                    i = a.iterator();
//                    while (i.hasNext()) {
//                        AddressBook addr = i.next();
//                        if (addr.getSrnum() == srnum) {
//                            i.remove();
//                            found = true;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Entered Name Record Not matched");
//                    } else {
//                        System.out.println("Record Deleted Successfully");
//                    }
//                    System.out.println("*************");
//                    break;
//
//                case 6:
//                    found = false;
//                    System.out.println("Enter serial number to update: ");
//                    srnum = s1.nextInt();
//                    System.out.println("*************");
//                    // i = a.iterator();
//                    ListIterator<AddressBook> li = a.listIterator();
//                    while (li.hasNext()) {
//                        AddressBook addr = li.next();
//                        if (addr.getSrnum() == srnum) {
//                            System.out.print("Enter new first name: ");
//                            first_name = sc.nextLine();
//                            System.out.print("Enter new last name: ");
//                            last_name = sc.nextLine();
//                            System.out.print("Enter new address: ");
//                            address = sc.nextLine();
//                            System.out.print("Enter new state: ");
//                            state = sc.nextLine();
//                            System.out.print("Enter new zip: ");
//                            zip_code = sc.nextInt();
//                            System.out.print("Enter new phone: ");
//                            phone_number = sc.nextLong();
//                            System.out.print("Enter new email: ");
//                            email_id = sc.nextLine();
//                            li.set(new AddressBook(srnum, first_name, last_name, address, state, zip_code, phone_number, email_id));
//                            found = true;
//                        }
//                    }
//                    if (!found) {
//                        System.out.println("Entered Number Record Not matched");
//                    } else {
//                        System.out.println("Record Updated Successfully");
//                    }
//                    System.out.println("*************");
//                    break;
//
//            }
//        } while (ch != 0);
//
//    }
//}