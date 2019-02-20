package com.juiceman.StupideBench.security;



import com.juiceman.StupideBench.model.Person;
import com.juiceman.StupideBench.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.juiceman.StupideBench.exception.ResourceNotFoundException;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email

        Person person = personRepository.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
                );

        return PersonPrincipal.create(person);
    }


    @Transactional
    public UserDetails loadUserById(String id) {

        Person user = personRepository.findPeopleById(id).orElseThrow(
                () ->
                        new UsernameNotFoundException("User not found by id: " + id)
        );
        return PersonPrincipal.create(user);

    }

}