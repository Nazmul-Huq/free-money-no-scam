package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.model.Email;
import com.example.freemoneynoscam.repositories.DatabaseInsertion;
import org.springframework.stereotype.Service;


@Service
public class ValidateEmailService {

    DatabaseInsertion databaseInsertion = new DatabaseInsertion();


    /**
     * check if a given email is valid or not
     * For validity: an email must have at least one "@" and one "."
     * @param email
     * @return
     */
    public boolean isEmailValid(String email){
        if ( (email.matches(".*(\\.).*")) && (email.matches(".*(\\@).*"))){
            return true;
        } else {
            return false;
        }
    }

    /**
     * add a given email to database
     * @param email
     * @return
     */
    public String addEmailToDatabase(String email){
        if (isEmailValid(email)) {
            if (databaseInsertion.addData(new Email(email))) {
                return "succeed";
            } else {
                return "not-succeed";
            }
        }
        return "invalid-email";
    }
} // class ends here
