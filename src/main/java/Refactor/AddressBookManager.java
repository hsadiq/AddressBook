package Refactor;

import java.util.*;
import java.io.*;

public class AddressBookManager {
    private final Map<String, List<AddressBook>> addressBookMap = new HashMap<>();

    Scanner sc = new Scanner(System.in);
    private static AddressBook getContactDetailsFromUser(Scanner scanner) {
        System.out.println("Enter first name:");
        String firstName = scanner.next();
        System.out.println("Enter last name:");
        String lastName = scanner.next();
        System.out.println("Enter address:");
        String address = scanner.next();
        System.out.println("Enter city:");
        String city = scanner.next();
        System.out.println("Enter state:");
        String state = scanner.next();
        System.out.println("Enter zip code:");
        int zipCode = scanner.nextInt();
        System.out.println("Enter phone number:");
        long phoneNumber = scanner.nextLong();
        System.out.println("Enter email:");
        String email = scanner.next();
        return new AddressBook(firstName, lastName, address, city, state, zipCode, phoneNumber, email);
    }

    public void addContact(AddressBook contact) {
        String city = contact.getCity();
        String state = contact.getState();

        List<AddressBook> cityContacts = addressBookMap.getOrDefault(city, new ArrayList<>());
        cityContacts.add(contact);
        addressBookMap.put(city, cityContacts);

        List<AddressBook> stateContacts = addressBookMap.getOrDefault(state, new ArrayList<>());
        if (!city.equals(state)) {
            stateContacts.add(contact);
            addressBookMap.put(state, stateContacts);
        }

        // Write the contact to a file
        writeContactToFile(contact);
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
        System.out.println("Enter City");
        String city = sc.next();
        long count = addressBookMap.values().stream()
                .flatMap(List::stream)
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .count();
        System.out.println("Number of Contact In " + city + " = " + count);
    }



    public void countState(){
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

    public void sortContacts(String field) {
        Comparator<AddressBook> comparator;
        switch (field.trim().toLowerCase()) {
            case "city":
                comparator = Comparator.comparing(AddressBook::getCity);
                break;
            case "state":
                comparator = Comparator.comparing(AddressBook::getState);
                break;
            case "zip":
                comparator = Comparator.comparing(AddressBook::getZipcode);
                break;
            default:
                System.out.println("Invalid field!");
                return;
        }

        List<AddressBook> contacts = new ArrayList<>();
        for (List<AddressBook> cityContacts : addressBookMap.values()) {
            contacts.addAll(cityContacts);
        }
        contacts.sort(comparator);

        System.out.println("Sorted by " + field + ":");
        contacts.forEach(System.out::println);
    }

    public void sortContacts() {
        System.out.println("Sort by (city/state/zip):");
        String field = sc.next();
        sortContacts(field);
    }

    public void writeContactToFile(AddressBook contact)  {
        String fileName = "AddressBookCSV.json";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write(addressBookMap.toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile() {
        String fileName = "AddressBookCSV.json";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                for (String field : fields) {
                    System.out.print(field.trim() + ", ");
                }
                System.out.println();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)  {
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
            System.out.println("8. Sort With Option");
            System.out.println("9. Write contacts to Json");
            System.out.println("10. Read contacts from Json");
            System.out.println("0. Exit from AddressBook");
            System.out.print("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    AddressBook contactToAdd = getContactDetailsFromUser(sc);
                    addressBookManager.addContact(contactToAdd);
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
                case 8:
                    System.out.println("Enter field to sort by (City/State/Zip):");
                    String field = sc.next();
                    addressBookManager.sortContacts(field);
                    break;

                case 9:
                    AddressBook contactToWrite = getContactDetailsFromUser(sc);
                    addressBookManager.writeContactToFile(contactToWrite);
                    break;

                case 10:
                    addressBookManager.readFromFile();
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
