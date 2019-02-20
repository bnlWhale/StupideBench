package com.juiceman.StupideBench.service;


import com.juiceman.StupideBench.model.Users;
import com.juiceman.StupideBench.repository.UsersRepository;
import com.juiceman.StupideBench.utils.MongoPageHelper;
import com.juiceman.StupideBench.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private MongoPageHelper mongoPageHelper;



    public List<Users> getAll(){
        return usersRepository.findAll();
    }



    // an example for fetching user's data by number of page
    /*

    public PageResult<StatByClientRs> findByDurationPage(FindByDurationPageRq rq) {
    final Query query = new Query(Criteria.where("duration").is(rq.getDuration()));

    return mongoPageHelper.pageQuery(query, StatByClient.class, rq.getPageSize(),
        rq.getPageNum(), mapper::mapToRs, rq.getLastId());
    }

     */

    /*
        return user data by page's number


     */
    public PageResult<Users> getPageUsers(){
        Query query = new Query(Criteria.where("_id").ne(null));
        return mongoPageHelper.pageQuery(query, Users.class, 3,1);
    }


    public Users getByUsername(String userName){


        return null;
    }
}
