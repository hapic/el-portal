package com.el.hpc.service;

import com.el.hpc.dao.GroupDao;
import com.el.hpc.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShenQi on 17/5/7.
 */
@Service
public class GroupService {

    @Autowired
    private GroupDao groupDao;

    public void addOneGroup(Group group){
        this.groupDao.insert(group);
    }

    public List<Group> findGroupByLandId(String landId){
        return this.groupDao.findByLandId(landId);
    }


}
