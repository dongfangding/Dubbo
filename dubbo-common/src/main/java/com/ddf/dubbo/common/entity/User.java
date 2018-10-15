package com.ddf.dubbo.common.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author DDf on 2018/10/11
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User extends BaseDomain implements Serializable {
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    public User(Integer id, String username, String password) {
        this.setId(id);
        this.username = username;
        this.password = password;
    }
}
