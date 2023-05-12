package Refactor;

import java.util.*;

public class AddressBookManager {
    private final Map<String, List<AddressBook>> addressBookMap = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    public void addContact(AddressBook contact) {
        String city = contact.getCity();
        String state = contact.getState();

        if (addressBookMap.containsKey(city)) {
            addressBookMap.get(city).add(contact);
        } else {
            List<AddressBook> cityContacts = new ArrayList<>();
            cityContacts.add(contact);
            addressBookMap.put(city, cityContacts);
        }


        if (addressBookMap.containsKey(state)) {
            addressBookMap.get(state).add(contact);
        } else {
            List<AddressBook> stateContacts = new ArrayList<>();
            stateContacts.add(contact);
            addressBookMap.put(state, stateContacts);
        }
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

    public void searchByState(String state) {
        List<AddressBook> contacts = addressBookMap.get(state);
        if (contacts == null) {
            System.out.println("No contact found in ");
        } else {
            System.out.println("Contact in " + ":");
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

    public void countCity(){
        System.out.println("Enter City Name:");
        String city = sc.next();
        long count = addressBookMap.values().stream()
                .flatMap(List::stream)
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .count();
        System.out.println("Number of Contact In " + city + " = " + count);
    }

    public void countState(){
        System.out.println("Enter the State Name:");
        String state = sc.next();
        long count = addressBookMap.values().stream().
                flatMap(List::stream)
                .filter(states -> states.getState().equalsIgnoreCase(state))
                .count();
        System.out.println("Number of Contact In " + state + " = " + count);
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
            System.out.println("1. Add contact");
            System.out.println("2. Display contacts");
            System.out.println("3. Search by city");
            System.out.println("4. Deleting Contact");
            System.out.println("5. Search by State");
            System.out.println("6. Total in city");
            System.out.println("7. Total in State");
            System.out.println("0. Exit from AddressBook");
            System.out.print("Enter your choice:");
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
                    break;
                case 5:
                    System.out.println("Enter State to Search");
                    String searchState = sc.next();
                    addressBookManager.searchByState(searchState);
                    break;
                case 6:
                    addressBookManager.countCity();
                    break;
                case 7:
                    addressBookManager.countState();
                    break;
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
