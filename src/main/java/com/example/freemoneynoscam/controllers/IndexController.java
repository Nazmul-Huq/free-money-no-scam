package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.services.ManageData;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {

    @Autowired
    ValidateEmailService validateEmailService;
    @Autowired
    ManageData manageData;

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


    // map to add email page
    @GetMapping("/add-email")
    public String addEmail(){
        return "add-email";
    }

    @GetMapping("/get-a-random-email")
    public String getARandomEmail(Model model){
        model.addAttribute("emails", manageData.getSingleEmailFromDatabase());        ;
        return "show-email";
    }

    @GetMapping("/get-all-email")
    public String getAllEmail(Model model){
        model.addAttribute("emails", manageData.getAllEmailFromDatabase());        ;
        return "show-email";
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
