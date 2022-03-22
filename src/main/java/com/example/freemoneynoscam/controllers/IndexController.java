package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {

    @Autowired
    ValidateEmailService validateEmailService;

    // map to homepage
    @GetMapping("/")
    public String index(){
        return "index";
    }

    // map to homepage
    @GetMapping("/index")
    public String homePage(){
        return "index";
    }

    @PostMapping("/test")
    public String addEmail(WebRequest formData){
        String succeedOrNot = validateEmailService.addEmailToDatabase(formData.getParameter("email"));
        return "redirect:/"+succeedOrNot;
    }

    // page to show after successfully added to the database
    @GetMapping("/succeed")
    public String succeed(){
        return "succeed";
    }

    // page to show if email validation failed
    @GetMapping("/invalid-email")
    public String invalidEmail(){
        return "invalid-email";
    }

    // page to if email is valid but failed to add to database for connection or other issue(s)
    @GetMapping("/not-succeed")
    public String notSucceed(){
        return "not-succeed";
    }

    // redirect to homepage
    @GetMapping("/redirect-to-homepage")
    public String redirectToHomepage(){
        return "index";
    }

}
