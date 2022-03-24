package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repositories.EmailRepository;
import com.example.freemoneynoscam.repositories.EmailRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManageData {

    EmailRepository emailRepository = new EmailRepositoryImpl();

    /**
     * get and return a single email
     * @return
     */
    public ArrayList<String> getSingleEmailFromDatabase(){
        ArrayList<String> emails = emailRepository.fetchSingleEmail();
        return emails;
    }

    /**
     * get and return all email from database
     * @return
     */
    public ArrayList<String> getAllEmailFromDatabase(){
        ArrayList<String> emails = emailRepository.fetchAllEmails();
        return emails;
    }
}
