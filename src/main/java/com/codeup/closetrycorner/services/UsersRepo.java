package com.codeup.closetrycorner.services;

import com.codeup.closetrycorner.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}