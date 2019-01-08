package com.juiceman.StupideBench.model;


import com.juiceman.StupideBench.utils.ScriptFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.script.ExecutableMongoScript;
import org.springframework.data.mongodb.core.script.NamedMongoScript;

class UsersRepositoryImpl implements UsersRepositoryCustom {


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

        //Log.debug("UsersRepositoryImpl updateName");

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



        return  false;



    }

}
