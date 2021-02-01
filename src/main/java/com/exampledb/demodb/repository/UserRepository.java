package com.exampledb.demodb.repository;

import com.exampledb.demodb.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("Select u from Users u where u.username = ?1")
    Optional<Users> findUsersByUsername(String username);
}