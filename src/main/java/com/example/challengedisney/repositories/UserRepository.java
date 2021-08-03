package com.example.challengedisney.repositories;

import com.example.challengedisney.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByNameOrEmail(String name, String email);

    User findUserByEmailAndToken(String email, String token);

}
