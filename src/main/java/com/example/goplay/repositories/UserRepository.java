package com.example.goplay.repositories;


import com.example.goplay.beans.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    User findUserByEmail(String email);
}
