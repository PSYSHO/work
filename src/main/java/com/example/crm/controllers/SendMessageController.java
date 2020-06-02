package com.example.crm.controllers;

import com.example.crm.entities.Customer;
import com.example.crm.repositories.CustomerRepo;
import com.example.crm.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SendMessageController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private MailSender mailSender;
   @PostMapping
    public void notification(String message,String filter,String header){
       List<Customer> customers = customerRepo.findAllByCity(filter);
       if(customers.isEmpty())customers=customerRepo.findAllByCountry(filter);

       for(Customer customer:customers)mailSender.send(customer.getEmailAddress(),"News",message);
   }
}
