package com.el.hpc.vo;

import com.el.hpc.domain.Group;
import com.el.hpc.domain.Land;
import com.el.hpc.domain.LocatorItem;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by ShenQi on 17/5/6.
 * 页面元素
 */
@Setter
@Getter
public class PageItemVo implements Serializable {

    private Land land;
    private Map<Group,List<LocatorItem>> groupListMap;


}
