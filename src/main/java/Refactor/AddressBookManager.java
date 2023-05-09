package Refactor;

import java.util.*;

public class AddressBookManager {
    private final Map<String, List<AddressBook>> addressBookMap;

    public AddressBookManager() {
        addressBookMap = new HashMap<>();
    }

    public void addContact(AddressBook contact) {
        String city = contact.getCity();
        List<AddressBook> contacts = addressBookMap.getOrDefault(city, new ArrayList<>());
        contacts.add(contact);
        addressBookMap.put(city, contacts);
        System.out.println("Contact Added Successfully");
    }

    public void displayContacts() {
        if (addressBookMap.isEmpty()) {
            System.out.println("No contacts found!");
        } else {
            for (List<AddressBook> contacts : addressBookMap.values()) {
                for (AddressBook contact : contacts) {
                    System.out.println(contact);
                }
            }
        }
    }

    public void searchContact(String city) {
        List<AddressBook> contacts = addressBookMap.get(city);
        if (contacts == null) {
            System.out.println("No contact found in " + city);
        } else {
            for (AddressBook contact : contacts) {
                System.out.println(contact);
            }
        }
    }
    public void searchByCity(String city) {
        List<AddressBook> contacts = addressBookMap.get(city);
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("No contacts found in " + city);
        } else {
            System.out.println("Contacts in " + city + ":");
            for (AddressBook contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void deleteContact(String firstName) {
        boolean removed = false;
        for (String city : addressBookMap.keySet()) {
            List<AddressBook> contacts = addressBookMap.get(city);
            for (int i = 0; i < contacts.size(); i++) {
                AddressBook contact = contacts.get(i);
                if (contact.getFirstName().equals(firstName)) {
                    contacts.remove(i);
                    removed = true;
                    break;
                }
            }
            if (removed) {
                System.out.println("Contact deleted successfully!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Contact not found!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBookManager addressBookManager = new AddressBookManager();

        int choice;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add contact");
            System.out.println("2. Display contacts");
            System.out.println("3. Search by city");
            System.out.println("4. Deleting Contact");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter first name:");
                    String firstName = sc.next();
                    System.out.println("Enter last name:");
                    String lastName = sc.next();
                    System.out.println("Enter address:");
                    String address = sc.next();
                    System.out.println("Enter city:");
                    String city = sc.next();
                    System.out.println("Enter state:");
                    String state = sc.next();
                    System.out.println("Enter zip code:");
                    int zipCode = sc.nextInt();
                    System.out.println("Enter phone number:");
                    long phoneNumber = sc.nextLong();
                    System.out.println("Enter email:");
                    String email = sc.next();
                    AddressBook addressBook = new AddressBook(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
                    addressBookManager.addContact(addressBook);
                    break;
                case 2:
                    addressBookManager.displayContacts();
                    break;
                case 3:
                    System.out.println("Enter city to search:");
                    String searchCity = sc.next();
                    addressBookManager.searchByCity(searchCity);
                    break;
                case 4:
                    System.out.println("Enter the First Name");
                    String remove = sc.next();
                    addressBookManager.deleteContact(remove);
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }
}
