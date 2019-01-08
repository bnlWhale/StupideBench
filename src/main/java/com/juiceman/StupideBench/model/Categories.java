package com.juiceman.StupideBench.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
public class Categories {

    @Id
    public String id;
    public String slug;
    public List<CategoryItem> ancestors;
    public ObjectId parent_id;
    public String name;
    public String description;

    public Categories(String id, String slug, ObjectId parent_id, String name, String description, List<CategoryItem> ancestors){
        this.id = id;
        this.slug = slug;
        this.parent_id = parent_id;
        this.name = name;
        this.description = description;
        this.ancestors = ancestors;

    }



    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(id+" ");
        str.append(slug+" ");
        if(ancestors != null){
            for(CategoryItem item:ancestors){
                str.append(item.toString());
            }
        }
        return  str.toString();
    }

}

