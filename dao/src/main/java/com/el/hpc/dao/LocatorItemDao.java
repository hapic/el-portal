package com.el.hpc.dao;

import com.el.hpc.domain.LocatorItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ShenQi on 17/4/29.
 */
@Component
public interface LocatorItemDao extends MongoRepository<LocatorItem,String> {

    LocatorItem findByName(String name);

    List<LocatorItem> findByGroupId(String groupId);
}
