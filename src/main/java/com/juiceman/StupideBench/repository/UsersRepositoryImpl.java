package com.juiceman.StupideBench.model;


import com.juiceman.StupideBench.service.ProductService;
import com.juiceman.StupideBench.utils.MongoPageHelper;
import com.juiceman.StupideBench.utils.ScriptFactory;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.script.ExecutableMongoScript;
import org.springframework.data.mongodb.core.script.NamedMongoScript;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;


class UsersRepositoryImpl implements UsersRepositoryCustom {


    private static final Log log = LogFactory.getLog(UsersRepositoryImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public boolean updateName(String fieldName, String old_firstName, String new_firstName){

/*
        Query query = new Query(Criteria.where(fieldName).is(old_firstName));
        Update update = new Update();
        update.set(fieldName, new_firstName);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Users.class);
        if(result != null){
            return result.wasAcknowledged();
        }else{
            return false;
        }
*/
        String filed_slug = "slug";
        String filed_slug_value = "MacBook-Pro-2018-9092";
        Query query = new Query(Criteria.where(filed_slug).is(filed_slug_value));

        /*
        List<Products> products = mongoTemplate.find(query, Products.class);
        System.out.println("find:"+products+" size:"+products.size());

        Products oneProduct = mongoTemplate.findOne(query,Products.class);
        query = new Query(Criteria.where("_id").is(oneProduct.main_cat_id));
        Categories oneCate = mongoTemplate.findOne(query, Categories.class);
        System.out.println("Categories:"+oneCate);
        */

        /*
        query = new Query(Criteria.where("_id").is("4c4b1476238d3b4dd5000001"));
        Users user = mongoTemplate.findOne(query, Users.class);
        System.out.println("find user:"+user);
        */

        for(int i=1;i<21;i++){

            query = new Query(Criteria.where("_id").is("4c4b1476238d3b4dd5000001"));
            Users user = mongoTemplate.findOne(query, Users.class);

            List<PaymentMethod> pm = user.payment_methods;
            for(PaymentMethod pmm:pm){
                pmm.setTestData(String.valueOf(i));
            }

            List<Address> ad = user.addresses;
            for(Address addr:ad){
                addr.setTestData(String.valueOf(i));
            }

            String userName = user.username+"_"+String.valueOf(i);
            String firstName = user.first_name+"_"+String.valueOf(i);
            String lastName = user.last_name+"_"+String.valueOf(i);
            String email = user.email+"_"+String.valueOf(i);
            Users nu = new Users(userName, firstName, lastName, ad, pm, email);
            //mongoTemplate.insert(nu);
        }

         //Aggregation
        //query = new Query(Criteria.where("_id").is("4c4b1476238d3b4dd5000001"));

        /*
        String str = ScriptFactory.getInstance().getScriptStrByName("SearchDetail.js");
        System.out.println("updateName "+str);

        ScriptOperations scriptOps = mongoTemplate.scriptOps();
        ExecutableMongoScript searchScript = new ExecutableMongoScript(str);
        //ExecutableMongoScript searchScript = new ExecutableMongoScript("product = db.products.findOne({'slug': 'wheel-barrow-9092'}) \n" +
        //       "db.products.update({_id:product['_id']},{$set:{\"sku\":\"7890\"}})");



        scriptOps.register(new NamedMongoScript("search", searchScript));
        try{
            //scriptOps.call("search", "search product");
            scriptOps.call("search");
        }catch(UncategorizedMongoDbException e){
            System.out.println(e);
        }
        */

        /*
        Person p = new Person("Joe","Good",34);
        mongoTemplate.insert(p);
        */





        return  false;



    }

}
