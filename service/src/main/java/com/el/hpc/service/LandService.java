package com.el.hpc.service;

import com.el.hpc.dao.LandDao;
import com.el.hpc.domain.Land;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ShenQi on 17/5/7.
 */
@Service
public class LandService {

    @Autowired
    private LandDao landDao;

    private void addLand(Land land){
        this.landDao.insert(land);
    }
}
