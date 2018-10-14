package com.ddf.dubbo.common.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author DDf on 2018/10/14
 */
@Getter
@Setter
public class BaseDomain {
    private Integer id;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    private Integer removed;

    private Integer version;
}
