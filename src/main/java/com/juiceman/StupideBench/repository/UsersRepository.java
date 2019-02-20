package com.juiceman.StupideBench.repository;


import java.util.List;


import com.juiceman.StupideBench.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String>, UsersRepositoryCustom {




}
