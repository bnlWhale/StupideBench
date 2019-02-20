package com.juiceman.StupideBench.model;

import org.springframework.data.annotation.Id;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {

    @Id
    public String id;

    public String first_name;
    public String last_name;
    public String username;
    public List<Address> addresses;
    public List<PaymentMethod> payment_methods;
    public String email;
    public String password;


    public Users() {}

    public Users(String username, String firstName, String lastName, List<Address> addresses, List<PaymentMethod> payment_methods, String email) {
        this.first_name = firstName;
        this.last_name = lastName;
        this.addresses = addresses;
        this.username = username;
        this.payment_methods =  payment_methods;
        this.email = email;
    }


    @Override
    public String toString() {
        return String.format(
                "Users [id=%s, firstName='%s', lastName='%s']",
                id, first_name, last_name, this.addresses);
    }

    public String getRoles(){

        return RoleManager.ROLE_USER;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }


    public void showAddress(){
        for (Address addr:addresses
        ) {
            System.out.println(addr);
        }
    }

}
