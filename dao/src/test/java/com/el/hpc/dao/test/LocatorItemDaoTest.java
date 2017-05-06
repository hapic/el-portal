package com.el.hpc.dao.test;

import com.el.hpc.dao.GroupDao;
import com.el.hpc.dao.LandDao;
import com.el.hpc.dao.LocatorItemDao;
import com.el.hpc.domain.Group;
import com.el.hpc.domain.Land;
import com.el.hpc.domain.LocatorItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by ShenQi on 17/5/6.
 */


@RunWith(SpringJUnit4ClassRunner.class)
//这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下
@SpringBootTest
@SpringBootApplication(scanBasePackages = {"com.el.hpc"})
@EnableMongoRepositories(basePackages = "com.el.hpc.dao")
public class LocatorItemDaoTest {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    private LocatorItemDao locatorItemDao;

    @Autowired
    private LandDao landDao;

    @Autowired
    private GroupDao groupDao;

    @Test
    public void testSave(){

        String landUUid=UUID.randomUUID().toString();
        Land land = new Land();
        land.setId(landUUid);
        land.setName("测试环境");
        this.landDao.insert(land);

        String groupUUid=UUID.randomUUID().toString();
        Group group= new Group();
        group.setId(groupUUid);
        group.setName("中台专用");
        group.setLandId(landUUid);
        this.groupDao.insert(group);

        groupUUid=UUID.randomUUID().toString();
        group= new Group();
        group.setId(groupUUid);
        group.setName("公共支撑");
        group.setLandId(landUUid);
        this.groupDao.insert(group);

        groupUUid=UUID.randomUUID().toString();
        group= new Group();
        group.setId(groupUUid);
        group.setName("solr组");
        group.setLandId(landUUid);
        this.groupDao.insert(group);



        LocatorItem locatorItem= new LocatorItem();
        locatorItem.setId(UUID.randomUUID().toString());
        locatorItem.setName("网站");
        locatorItem.setHost("192.168.10.190");
        locatorItem.setHref("www.eloancn.com");
        locatorItem.setDesc("网摘");
        locatorItem.setGroupId(groupUUid);

        locatorItemDao.insert(locatorItem);
    }
}
