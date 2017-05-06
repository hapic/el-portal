package com.el.hpc.dao;

import com.el.hpc.domain.Land;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ShenQi on 17/5/7.
 */
public interface LandDao extends MongoRepository<Land,String>{
}
