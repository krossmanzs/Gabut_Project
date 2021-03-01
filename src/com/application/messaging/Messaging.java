package com.application.messaging;

import java.util.ArrayList;
import java.util.Scanner;

public class Messaging {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Welcome to my humble world of programming");
        showInitialOptions();
    }

    private static void showInitialOptions(){
        System.out.println("Please select one:" +
                "\n\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit"
        );

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageMessages() {
        System.out.print("Please select one: " +
                "\n\t1. Show all messages" +
                "\n\t2. Send a new messages" +
                "\n\t3. Go back"
        );

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> showAllMessages();
            case 2 -> sendNewMessage();
            default -> showInitialOptions();
        }
    }

    private static void sendNewMessage() {
        scanner = new Scanner(System.in);

        System.out.println("Who are you going to send a message?");
        String name = scanner.nextLine();
        if (name.equals("")) {
            System.out.println("Please enter the name of the contact!");
            sendNewMessage();
        } else {
            boolean isExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                System.out.println("What are you going to say?");
                String text = scanner.nextLine();
                if (text.equals("")) {
                    System.out.println("Please enter some message");
                    sendNewMessage();
                } else {
                    id++;
                    Message newMessage = new Message(text, name, id);
                    for (Contact c : contacts) {
                        if (c.getName().equals(name)) {
                            ArrayList<Message> newMessages = c.getMessages();
                            newMessages.add(newMessage);
                            c.setMessages(newMessages);
                        }
                    }
                }
            } else {
                System.out.println("There is no such contact");
            }
        }

        showInitialOptions();
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c : contacts) {
            allMessages.addAll(c.getMessages());
        }

        if (allMessages.size() > 0) {
            for (Message m : allMessages) {
                m.getDetails();
                System.out.println("==================");
            }
        } else {
            System.out.println("You don't have any message!");
        }

        showInitialOptions();
    }

    private static void manageContacts(){
        System.out.println("Please Select One: " +
                "\n\t1. Show all contacts" +
                "\n\t2. Add a new contacts" +
                "\n\t3. Search for a contacts" +
                "\n\t4. Delete a contacts" +
                "\n\t5. Go back"
        );

        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> showAllContacts();
            case 2 -> addNewContact();
            case 3 -> searchContact();
            case 4 -> deleteContact();
            default -> showInitialOptions();
        }
    }

    private static void deleteContact() {
        System.out.print("Please enter the contact's name: ");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name!");
            deleteContact();
        } else {
            boolean isExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    isExist = true;
                    contacts.remove(c);
                }
            }

            if (!isExist) {
                System.out.println("There is no such contact found!");
            }

            showInitialOptions();
        }
    }

    private static void searchContact() {
        System.out.print("Please enter the contact name: ");
        String name = scanner.next();
        if (name.equals("")) {
            System.out.println("Please enter the name!");
            searchContact();
        } else {
            boolean isExist = false;
            for (Contact c : contacts){
                if (c.getName().equals(name)) {
                    isExist = true;
                    c.getDetails();
                }
            }

            if (!isExist) {
                System.out.println("There is no such contact in your Phone!");
            }
        }

        showInitialOptions();
    }

    private static void addNewContact() {
        System.out.print("Adding a new contact..."
                + "\nPlease enter the contact's name: "
        );
        String name = scanner.next();

        System.out.print("Please enter contact's number: ");
        Long number = scanner.nextLong();

        System.out.print("Pleas enter contact's email: ");
        String email = scanner.next();

        if (name.equals("") || number.equals(0L) || email.equals("")) {
            System.out.println("Please enter all of the information!");
            addNewContact();
        } else {
            boolean isExist = false;
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    isExist = true;
                    break;
                }
            }

            if (isExist) {
                System.out.println("You have a contact named " + name + " saved on this device");
                addNewContact();
            } else {
                contacts.add(new Contact(name, number, email));
                System.out.println(name + " added successfully");
            }
        }

        showInitialOptions();
    }

    private static void showAllContacts() {
        if (contacts.size() > 0) {
            for (Contact c : contacts) {
                c.getDetails();
                System.out.println("==================");
            }
            showInitialOptions();
        } else {
            System.out.println("Contact is empty! Please create one!");
            addNewContact();
        }
    }
}