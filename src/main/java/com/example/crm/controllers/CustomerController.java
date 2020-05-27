package com.example.crm.controllers;

import com.example.crm.entities.Customer;
import com.example.crm.repositories.CustomerRepo;
import com.example.crm.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import java.awt.*;
import java.util.Collections;
import java.util.Optional;


@RestController
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepository;

    @GetMapping
    public Iterable<Customer> getAll() {
        return customerRepository.findAll(Sort.by("firstName").ascending());
    }
    @GetMapping("/{Id}")
    public Optional<Customer> getById(@PathVariable("Id") Long id){
        return customerRepository.findById(id);
    }
    /*@GetMapping("/{firstName}")
    public Customer getByFirstName(@PathVariable("firstName") String  firstName){
        return customerRepository.findByFirstName(firstName);
    }*/

    @PostMapping
    public Customer createCustomer(@RequestBody Customer Customer){
        return customerRepository.save(Customer);
    }

    @PutMapping("/{Id}")
    public void updateCustomer(@PathVariable("Id") Long id, @RequestBody Customer customer){
        customerRepository.findById(id).map(customer1 -> {
           customer1.setAddress(customer.getAddress());
           customer1.setCity(customer.getCity());
           customer1.setCountry(customer.getCountry());
           customer1.setEmailAddress(customer.getEmailAddress());
           customer1.setFirstName(customer.getFirstName());
           customer1.setLastName(customer.getLastName());
           customer1.setPhoneNumber(customer.getPhoneNumber());
           customer1.setComment(customer.getComment());
            return customerRepository.save(customer1);
        });
    }

    @DeleteMapping("/{Id}")
    public void deleteCustomer(@PathVariable("Id") Customer customer){
        customerRepository.delete(customer);
    }
}
