package com.juiceman.StupideBench.service;

import java.util.List;

import com.juiceman.StupideBench.model.Person;
import com.juiceman.StupideBench.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    //Create operation
    public Person create(String firstName, String lastName, String password, String email, String userName, String role) {
        Person p = new Person(firstName, lastName, password, email, userName, role);
        encryptPassword(p);
        return personRepository.save(p);
    }
    //Retrieve operation
    public List<Person> getAll(){
        return personRepository.findAll();
    }
    public Person getByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }
    //Update operation
    public Person update(String firstName, String lastName) {
        Person p = personRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        return personRepository.save(p);
    }
    //Delete operation
    public void deleteAll() {
        personRepository.deleteAll();
    }
    public void delete(String firstName) {
        Person p = personRepository.findByFirstName(firstName);
        personRepository.delete(p);
    }

    //************
    public Person getByUserName(String userName) {
        return personRepository.findByUserName(userName);
    }

    private void encryptPassword(Person userEntity){
        String password = userEntity.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userEntity.setPassword(password);
    }
}
