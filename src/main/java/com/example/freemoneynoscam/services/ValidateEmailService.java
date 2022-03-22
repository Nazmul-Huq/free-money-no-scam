package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repository.DatabaseInsertion;
import org.springframework.stereotype.Service;


@Service
public class ValidateEmailService {

    DatabaseInsertion databaseInsertion = new DatabaseInsertion();


    public boolean isEmailValid(String email){
        if ( (email.matches(".*(\\.).*")) && (email.matches(".*(\\@).*"))){
            return true;
        } else {
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
