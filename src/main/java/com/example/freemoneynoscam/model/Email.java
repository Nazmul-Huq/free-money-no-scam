package com.example.freemoneynoscam.model;

public class Email {

    private String emailToAdd;

    public Email() {
    }

    public Email(String emailToAdd) {
        this.emailToAdd = emailToAdd;
    }

    public String getEmailToAdd() {
        return emailToAdd;
    }

    public void setEmailToAdd(String emailToAdd) {
        this.emailToAdd = emailToAdd;
    }

    @Override
    public String toString() {
        return "emailToAdd";
    }
}
