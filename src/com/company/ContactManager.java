package com.company;

import java.util.Scanner;

public class ContactManager {

    Contact[] contactArray = new Contact[1];
    int index = 0;

    public void start() {
        while (true) {
            int action = showMenuAndGetAction();
            switch (action) {
                case 1:
                    sortContactList();
                    showContactList();
                    break;
                case 2:
                    Contact contact = getContact();
                    if (!isContactExist(contact.getPhone())) {
                        addContact(contact);
                    } else {
                        System.out.println("This phone exists");
                    }
                    break;
                case 3:
                    findByPhone();
                    break;
                case 4:
                    deleteByPhone();
                    break;
                case 5:
                    findByName();
                    break;
                case 0:
                    return;
                case -1:
                    break;
                default:
                    System.out.println("Not available action?");
            }
        }
    }

    public void addContact(Contact contact) {
        if (contactArray.length == index) {
            Contact[] newpArray = new Contact[contactArray.length + 5];
            int i = 0;
            while (i < contactArray.length) {
                newpArray[i] = contactArray[i];
                i++;
            }
            contactArray = newpArray;
        }
        contactArray[index] = contact;
        index++;
    }

    public int showMenuAndGetAction() {
        System.out.println("\t\t ***MENU***");
        System.out.println("-----------------------------");
        System.out.println("|\t\t1-Contact List\t\t|");
        System.out.println("|\t\t2-Contact add\t\t|");
        System.out.println("|\t\t3-Find by Phone\t\t|");
        System.out.println("|\t\t4-Delete by phone\t|");
        System.out.println("|\t\t5-Find by Name\t\t|");
        System.out.println("|\t\t0-Back to Menu\t\t|");
        System.out.println("-----------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Action: ");
        String s = scanner.next();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("Enter Number: ");
                return -1;
            }
        }
        return Integer.parseInt(s);
    }

    public void showContactList() {
        System.out.println("--- Contact List ---");
        int i = 0;
        while (i < contactArray.length) {
            Contact contact = contactArray[i];
            if (contact != null) {
                System.out.println(contact);
            }
            i++;
        }
    }

    public void sortContactList() {
        for (int i = 0; i < contactArray.length; i++) {
            for (int j = i + 1; j < contactArray.length; j++) {
                if (contactArray[i] == null || contactArray[j] == null) {
                    continue;
                }
                if (contactArray[i].getName().compareTo(contactArray[j].getName()) > 0) {
                    Contact temp = contactArray[i];
                    contactArray[i] = contactArray[j];
                    contactArray[j] = temp;
                }
            }
        }
    }

    public Contact getContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Add New Contact ---");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Entre Phone: ");
        String phone = scanner.next();


        Contact contact = new Contact();
        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        return contact;
    }

    public boolean isContactExist(String phone) {
        for (Contact contact : contactArray) {
            if (contact != null && phone.equals(contact.getPhone())) {
                return true;
            }
        }
        return false;
    }

    public void findByPhone() {
        System.out.println("--- Find By Phone ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Phone: ");
        String phone = scanner.next();


        for (Contact contact : contactArray) {
            if (contact != null && phone.equals(contact.getPhone())) {
                System.out.println(contact.getName());

            }
        }
    }

    public void findByName() {
        System.out.println("--- Find By Name ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.next();

        for (Contact contact : contactArray) {
            if (contact != null && name.equals(contact.getName())) {
                System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhone());
            }
        }
    }

    public void deleteByPhone() {
        System.out.println("--- Delete By Phone ---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Phone: ");
        String phone = scanner.next(); // 1234

        for (int i = 0; i < contactArray.length; i++) {
            Contact contact = contactArray[i];
            if (contact != null && phone.equals(contact.getPhone())) {
                contactArray[i] = null;
                System.out.println("Contact deleted");
                break;
            }
        }

    }

    public boolean isHave(String phone) {
        for (Contact contact : contactArray) {
            if (contact != null && phone.equals(contact.getPhone())) {
                return true;
            }
        }
        return false;
    }
}
