package com.application.messaging;

public class Message {
    private String text;
    private String recipient;
    private int id;

    public Message(String text, String recipient, int id) {
        this.text = text;
        this.recipient = recipient;
        this.id = id;
    }

    public void getDetails(){
        System.out.println("Contact Name: " + this.recipient +
                "\nMessage: " + this.text +
                "\nID: " + this.id);
    }
}
