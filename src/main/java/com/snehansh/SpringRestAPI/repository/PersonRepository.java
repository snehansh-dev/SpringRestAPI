package com.snehansh.SpringRestAPI.repository;

import com.snehansh.SpringRestAPI.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
