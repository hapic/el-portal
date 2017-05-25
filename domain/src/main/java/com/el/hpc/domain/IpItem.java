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
public class IpItem implements Serializable {
    private String id;
    private String ip;

    @Transient
    private List<TagItem> tagItems;
}
