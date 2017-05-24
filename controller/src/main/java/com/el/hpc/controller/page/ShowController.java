package com.el.hpc.controller.page;

import com.el.hpc.domain.Group;
import com.el.hpc.domain.Land;
import com.el.hpc.domain.LocatorItem;
import com.el.hpc.service.GroupService;
import com.el.hpc.service.LandService;
import com.el.hpc.service.LocatorItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.ws.RequestWrapper;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by ShenQi on 17/4/25.
 */
@Controller
public class ShowController {

    @Autowired
    private LandService landService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private LocatorItemService locatorItemService;

    @RequestMapping("/")
    public ModelAndView home(Map<String, Object> model) {

        List<Land> lands = landService.loadAllLand();

        String thisLandId=null;
        if(lands!=null && !lands.isEmpty()){
            Land land = lands.get(0);
            thisLandId = land.getId();
            land.setCurrentPage(true);
        }

        //
        List<Group> groupList = this.groupService.findGroupByLandId(thisLandId);
        for(Group group:groupList){
            String groupId = group.getId();
            List<LocatorItem> allLocatorItemByGroupId = this.locatorItemService.findAllLocatorItemByGroupId(groupId);
            group.setLocatorItemList(allLocatorItemByGroupId);
        }

        model.put("lands", lands);
        model.put("groupList", "groupList");

        return new ModelAndView("index","data",model);
    }


    @RequestMapping("manager")
    public ModelAndView manger() {
        return new ModelAndView("manager/index");
    }

}
