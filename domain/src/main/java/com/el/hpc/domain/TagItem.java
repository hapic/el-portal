package com.el.hpc.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by ShenQi on 17/5/25.
 */
@Setter
@Getter
public class TagItem implements Serializable {
    private String id;
    private String name;

}
