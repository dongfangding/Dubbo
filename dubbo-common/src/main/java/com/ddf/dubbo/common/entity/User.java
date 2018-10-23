package com.ddf.dubbo.common.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

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
@AllArgsConstructor
public class User extends BaseDomain implements Serializable {
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;

    public User(Integer id, String username, String password, String createBy, Date createTime, String modifyBy,
                Date modifyTime, Integer removed, Integer version) {
        super.setId(id);
        super.setCreateBy(createBy);
        super.setCreateTime(createTime);
        super.setModifyBy(modifyBy);
        super.setModifyTime(modifyTime);
        super.setRemoved(removed);
        super.setVersion(version);
        this.username = username;
        this.password = password;
    }
}
