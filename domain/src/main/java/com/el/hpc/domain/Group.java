package com.el.hpc.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ShenQi on 17/5/1.
 * 分组的实体类
 */
@Setter
@Getter
public class Group implements Serializable{

    @Id
    private String id;
    private String name;

    private String landId;

    @Transient
    private List<LocatorItem> locatorItemList;
    
}
