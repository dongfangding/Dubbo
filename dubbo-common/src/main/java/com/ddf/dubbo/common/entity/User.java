package com.ddf.dubbo.common.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author DDf on 2018/10/11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
}
