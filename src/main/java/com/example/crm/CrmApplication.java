package com.example.crm;

import com.example.crm.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CrmApplication {
    @Autowired
    MailSender mailSender;
    public static void main(String[] args){
        SpringApplication.run(CrmApplication.class,args);
    }
}
