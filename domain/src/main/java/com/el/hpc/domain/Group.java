package com.el.hpc.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

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
    
}
