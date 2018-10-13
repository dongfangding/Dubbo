package com.ddf.dubbo.user.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DDf on 2018/10/12
 */
@Service
public class UserServiceRef {

    @Reference
    private UserService userService;

    public List<User> list() {
        return userService.list();
    }
}
