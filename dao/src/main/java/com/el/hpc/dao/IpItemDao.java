package com.el.hpc.dao;

import com.el.hpc.domain.IpItem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ShenQi on 17/5/25.
 */
public interface IpItemDao extends MongoRepository<IpItem,String> {
}
