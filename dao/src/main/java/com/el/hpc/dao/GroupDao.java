package com.el.hpc.dao;

import com.el.hpc.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ShenQi on 17/5/7.
 */
public interface GroupDao  extends MongoRepository<Group,String>{
}
