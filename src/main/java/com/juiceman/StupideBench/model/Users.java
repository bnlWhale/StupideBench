package com.juiceman.StupideBench.model;

import org.springframework.data.annotation.Id;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {

    @Id
    public String id;

    public String firstName;
    public String lastName;


    public List<Address> addresses;

    public Users() {}

    public Users(String firstName, String lastName, List<Address> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
    }


    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    @Override
    public String toString() {
        return String.format(
                "Users [id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName, this.addresses);
    }

    public void showAddress(){
        for (Address addr:addresses
        ) {
            System.out.println(addr);
        }
    }

}
