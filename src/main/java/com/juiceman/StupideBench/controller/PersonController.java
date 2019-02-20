package com.juiceman.StupideBench.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.juiceman.StupideBench.model.Person;
import com.juiceman.StupideBench.model.RoleManager;
import com.juiceman.StupideBench.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/create")
    public String create(@RequestParam String userName, @RequestParam String email, @RequestParam String password) {
        String role = RoleManager.ROLE_USER;
        Person p = personService.create(null, null, password, email, userName, role);
        return p.toString();
    }

    @RequestMapping("/get")
    public Person getPerson(@RequestParam String firstName) {
        return personService.getByFirstName(firstName);
    }

    @RequestMapping("/getAll")
    public List<Person> getAll(){
        return personService.getAll();
    }

    @RequestMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName) {
        Person p = personService.update(firstName, lastName);
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName) {
        personService.delete(firstName);
        return "Deleted "+firstName;
    }

    @RequestMapping ("/deleteAll")
    public String deleteAll() {
        personService.deleteAll();
        return "Deleted all records";
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
    }

    /*
    @PostMapping("/api/logout")
    public ResponseEntity<?> logout(HttpServletRequest request,
                                    @AuthenticationPrincipal(expression = "idToken") OidcIdToken idToken) {
        // send logout URL to client so they can initiate logout
        String logoutUrl = this.registration.getProviderDetails()
                .getConfigurationMetadata().get("end_session_endpoint").toString();

        Map<String, String> logoutDetails = new HashMap<>();
        logoutDetails.put("logoutUrl", logoutUrl);
        logoutDetails.put("idToken", idToken.getTokenValue());
        request.getSession(false).invalidate();
        return ResponseEntity.ok().body(logoutDetails);
    }
    */
}

