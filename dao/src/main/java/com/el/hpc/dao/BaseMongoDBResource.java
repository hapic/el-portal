package com.el.hpc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ShenQi on 17/4/29.
 */
public interface BaseMongoDBResource<T> extends MongoRepository<T,Integer> {


}
