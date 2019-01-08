package com.juiceman.StupideBench.model;

import org.springframework.data.annotation.Id;

public class CategoryItem {


    @Id
    public String id;
    public String name;
    public String slug;

    @Override
    public String toString(){
        return  id+" "+name+" "+slug+" ";
    }
}
