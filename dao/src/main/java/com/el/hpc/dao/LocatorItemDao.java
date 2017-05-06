package com.el.hpc.dao;

import com.el.hpc.domain.LocatorItem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ShenQi on 17/4/29.
 */
public interface LocatorItemDao extends MongoRepository<LocatorItem,Integer> {



}
