package com.el.hpc.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ShenQi on 17/5/6.
 * 各个环境的model
 */
@Setter
@Getter
public class Land implements Serializable {

    @Id
    private String id;
    private String name;

}
