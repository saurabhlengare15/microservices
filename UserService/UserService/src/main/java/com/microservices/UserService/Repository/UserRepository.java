package com.microservices.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.UserService.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
