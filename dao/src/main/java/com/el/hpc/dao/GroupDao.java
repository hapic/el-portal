package com.el.hpc.dao;

import com.el.hpc.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by ShenQi on 17/5/7.
 */
public interface GroupDao  extends MongoRepository<Group,String>{

    public List<Group> findByLandId(String landId);
}
