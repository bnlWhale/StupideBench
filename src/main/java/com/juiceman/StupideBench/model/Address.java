package com.juiceman.StupideBench.model;

public class Address {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(){

    }

    public Address(String name, String street, String city, String state, String zip){

        this.setName(name);
        this.setStreet(street);
        this.setCity(city);
        this.setState(state);
        this.setZip(zip);
    }


    public void setTestData(String str){

        this.setName(this.getName() + "_"+str);
        this.setCity(this.getCity() + "_"+str);
    }


    @Override
    public String toString() {

        return this.getName() +" "+ this.getStreet() +" "+ this.getCity() +" "+ this.getState() +" "+ this.getZip();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}

