package com.juiceman.StupideBench.model;

import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentMethod {

    public String name;
    public int last_four;
    public Date expiration_date;
    public String crypted_number;


    public PaymentMethod(String name, int last_four, Date expiration_date, String crypted_number){
           this.name = name;
           this.last_four = last_four;
           this.expiration_date = expiration_date;
           this.crypted_number = crypted_number;
    }

    public void setTestData(String str){
        this.name += "_"+str;
        last_four += Integer.parseInt(str);
        crypted_number += "_"+str;
        expiration_date = new Date();

        GregorianCalendar gc = new GregorianCalendar();
        expiration_date = gc.getGregorianChange();
    }
}
