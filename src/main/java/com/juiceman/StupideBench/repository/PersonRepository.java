package com.juiceman.StupideBench.repository;

import java.util.List;

import com.juiceman.StupideBench.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends MongoRepository<Person, String>{
    public Person findByFirstName(String firstName);
    public List<Person> findByAge(int age);
}