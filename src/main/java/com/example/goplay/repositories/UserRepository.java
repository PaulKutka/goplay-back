package com.example.goplay.repositories;


import com.example.goplay.beans.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findUserByEmail(String email);
    User findUserById(Long id);

    User findUserByName(String player12Name);
}
