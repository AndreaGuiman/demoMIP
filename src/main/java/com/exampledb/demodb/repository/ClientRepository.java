package com.exampledb.demodb.repository;

import com.exampledb.demodb.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Integer> {
}
