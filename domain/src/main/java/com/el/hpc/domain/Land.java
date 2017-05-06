package com.el.hpc.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by ShenQi on 17/5/6.
 * 各个环境的model
 */
@Setter
@Getter
public class Land implements Serializable {

    private Integer id;
    private String name;
}
