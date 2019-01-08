package com.juiceman.StupideBench.model;

public class Address {

    public String name;
    public String street;
    public String city;
    public String state;
    public String zip;

    public Address(String name, String street, String city, String state, String zip){

        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {

        return this.name+" "+this.street+" "+this.city+" "+this.state+" "+this.zip;
    }
}

