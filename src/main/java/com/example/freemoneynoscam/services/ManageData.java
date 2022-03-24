package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repositories.EmailRepository;
import com.example.freemoneynoscam.repositories.EmailRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ManageData {

    EmailRepository emailRepository = new EmailRepositoryImpl();

    public ArrayList<String> getSingleEmailFromDatabase(){
        ArrayList<String> emails = emailRepository.fetchSingleEmail();
        return emails;
    }

    public ArrayList<String> getAllEmailFromDatabase(){
        ArrayList<String> emails = emailRepository.fetchAllEmails();
        return emails;
    }
}
