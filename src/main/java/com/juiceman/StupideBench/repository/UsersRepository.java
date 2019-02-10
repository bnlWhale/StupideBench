package com.juiceman.StupideBench.model;


import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String>, UsersRepositoryCustom {




}
