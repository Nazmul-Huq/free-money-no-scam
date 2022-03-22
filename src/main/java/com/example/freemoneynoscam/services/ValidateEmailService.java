package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repository.DatabaseInsertion;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class ValidateEmailService {

    DatabaseInsertion databaseInsertion = new DatabaseInsertion();


    public boolean isEmailValid(String email){
        if (Pattern.matches(".+@.+.", email)) {
            //return false;
            return true;
        } else {
            //return true;
            return false;
        }
    }

    public String addEmailToDatabase(String email){
        if (isEmailValid(email)) {
            if (databaseInsertion.addData(email)) {
                return "succeed";
            } else {
                return "not-succeed";
            }
        }
        return "invalid-email";
    }
} // class ends here
