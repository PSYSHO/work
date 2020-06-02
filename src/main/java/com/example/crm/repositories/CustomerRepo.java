package com.example.crm.repositories;

import com.example.crm.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Customer findByFirstName(String firstName);
    List<Customer> findAllByCity(String city);
    List<Customer> findAllByCountry(String country);
}
