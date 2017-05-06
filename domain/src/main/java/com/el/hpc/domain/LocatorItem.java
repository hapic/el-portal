package com.el.hpc.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by ShenQi on 17/4/28.
 * 一个链接的实体类
 */
@Setter
@Getter
public class LocatorItem implements Serializable {

    @Id
    private String id;
    private String name;
    private String desc;
    private String href;
    private String isNew;
    private String host;


}
