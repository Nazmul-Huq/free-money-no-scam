package com.example.freemoneynoscam.repositories;

import com.example.freemoneynoscam.model.Email;

import java.util.ArrayList;

public interface EmailRepository {

    // method to fetch a random email
    ArrayList<String> fetchSingleEmail();

    // method to fetch all email
    ArrayList<String> fetchAllEmails();
}
