package com.ajose.fullstackbackend.repo;

import com.ajose.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {

}
