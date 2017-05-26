package com.el.hpc.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ShenQi on 17/5/25.
 */
@Setter
@Getter
public class TagItem implements Serializable {
    private String id;
    private String name;

    @Transient
    private List<IpItem> ipItems;

}
