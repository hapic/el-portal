package com.el.hpc.service;

import com.el.hpc.dao.LocatorItemDao;
import com.el.hpc.domain.LocatorItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.helpers.LocatorImpl;

import java.util.List;

/**
 * Created by ShenQi on 17/4/29.
 */
@Service
public class LocatorItemService {

    @Autowired
    private LocatorItemDao locatorItemDao;

    public void addLocatorItem(LocatorItem item){
        locatorItemDao.insert(item);
    }

    public List<LocatorItem> findAllLocatorItemByGroupId(String groupId){
        return this.locatorItemDao.findByGroupId(groupId);
    }



}
