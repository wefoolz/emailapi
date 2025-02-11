package com.email.controller;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="https://emailgui.vercel.app")
public class EmailController {


    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String justWelcome(){

        return "hello this is my email api";
    }

    //api to sen email
    @PostMapping("/sendemail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
        boolean result = this.emailService.senEmail(request.getMessage(),request.getSubject(), request.getTo(),request.getFrom(),request.getApppassword());
        System.out.println(request);
        if(result){
            return ResponseEntity.ok(new EmailResponse("Email Sent Successfully..."));

        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email Not Sent..."));

        }
    }
}

