package com.ddf.dubbo.boot.user.provider.repository;

import com.ddf.dubbo.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author DDf on 2018/10/15
 */
public interface UserRespository extends JpaRepository<User, Integer> {
}
