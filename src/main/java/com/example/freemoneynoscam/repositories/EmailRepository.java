package com.example.freemoneynoscam.repositories;

import com.example.freemoneynoscam.model.Email;

import java.util.ArrayList;

public interface EmailRepository {

    ArrayList<String> fetchSingleEmail();
    ArrayList<String> fetchAllEmails();
}
