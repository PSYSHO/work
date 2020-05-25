package com.example.crm.repositories;

import com.example.crm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
