package com.el.hpc.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by ShenQi on 17/5/1.
 * 分组的实体类
 */
@Setter
@Getter
public class Group implements Serializable{

    private Integer id;
    private String name;
    
}
