package com.ddf.dubbo.common.entity;

import lombok.*;

/**
 * @author DDf on 2018/10/11
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}
