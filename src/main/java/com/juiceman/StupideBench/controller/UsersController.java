package com.juiceman.StupideBench.controller;


import com.juiceman.StupideBench.model.Person;
import com.juiceman.StupideBench.model.Users;
import com.juiceman.StupideBench.repository.UsersRepository;
import com.juiceman.StupideBench.payload.UserIdentityAvailability;
import com.juiceman.StupideBench.payload.UserProfile;
import com.juiceman.StupideBench.payload.UserSummary;
import com.juiceman.StupideBench.repository.PersonRepository;
import com.juiceman.StupideBench.security.CurrentUser;
import com.juiceman.StupideBench.security.PersonPrincipal;
import com.juiceman.StupideBench.service.UserService;
import com.juiceman.StupideBench.utils.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserService userService;


    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserSummary getCurrentUser(@CurrentUser PersonPrincipal currentUser) {
        //logger.info("getCurrentUser",currentUser);
        UserSummary userSummary = new UserSummary(currentUser.getUsername());
        //logger.info(userSummary.getUserName(),userSummary);
        return userSummary;
    }

    @RequestMapping("/api/getAllUser")
    public List<Users> getAllUser(){
        return usersRepository.findAll();
    }

    @RequestMapping("/api/getUserByPage")
    public PageResult<Users> getUserByPage(){
        return userService.getPageUsers();
    }


    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !personRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !personRepository.existsByUserName(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {

        Person user = personRepository.findByUserName(username);


        long pollCount = 0;
        long voteCount = 0;

        UserProfile userProfile = new UserProfile(user.getId(), user.getUserName(), java.time.Instant.now(), pollCount, voteCount);
        userProfile.setRole(user.getRole());
        return userProfile;
    }

}
