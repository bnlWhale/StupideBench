package com.juiceman.StupideBench.repository;


import java.util.Optional;

import com.juiceman.StupideBench.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends MongoRepository<Person, String>{

    public Person findByFirstName(String firstName);
    public Person findByUserName(String userName);
    public Boolean existsByUserName(String userName);
    public Boolean existsByEmail(String email);
    Optional<Person> findByUserNameOrEmail(String userName, String email);
    Optional<Person> findPeopleById(String id);
}