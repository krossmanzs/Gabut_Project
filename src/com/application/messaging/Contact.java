package com.application.messaging;

import java.util.ArrayList;

public class Contact {
    private String name;
    private Long number;
    private String email;
    private ArrayList<Message> messages;

    public Contact(String name, Long number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = new ArrayList<>();
    }   

    public void getDetails(){
        System.out.println(
                "Name: " + this.name +
                "\nNumber: " + this.number +
                "\nEmail: " + this.email
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
