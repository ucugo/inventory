package com.ugo.uchegbu;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * Created by Ugo on 11/04/2015.
 */

@Configuration
@EnableMongoRepositories
@ComponentScan("com.ugo.uchegbu.*")
public class JpaConfig extends AbstractMongoConfiguration {

   public MongoTemplate mongoTemplate() throws Exception {
       MongoTemplate template = new MongoTemplate(mongoDbFactory());
       template.setWriteConcern(WriteConcern.FSYNCED);
        return template;
    }

    @Override
    protected String getDatabaseName() {
        return "mydb";
    }


    public MongoClient mongoClient() throws Exception{
        return new MongoClient();
    }

    @Override
    public Mongo mongo() throws Exception {
        return mongoClient();
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.ugo.uchegbu.repository";
    }

    @Bean
    public MongoOperations mongoOperations(MongoTemplate mongoTemplate){
        return mongoTemplate;
    }
}
