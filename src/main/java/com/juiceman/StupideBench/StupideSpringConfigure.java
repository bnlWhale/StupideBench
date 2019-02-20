package com.juiceman.StupideBench;


import com.juiceman.StupideBench.utils.MongoPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;

@EnableMongoAuditing
@Configuration
public class StupideSpringConfigure {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Bean
    public MongoPageHelper mongoPageHelper() {
        return new MongoPageHelper(mongoTemplate);
    }

    @Bean
    public MongoTransactionManager mongoTransactionManager(MongoDbFactory dbFactory){
        return new MongoTransactionManager(dbFactory);
    }

}
