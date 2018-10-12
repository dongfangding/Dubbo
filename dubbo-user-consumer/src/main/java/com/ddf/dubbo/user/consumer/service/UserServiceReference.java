package com.ddf.dubbo.user.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;

import java.util.List;

/**
 * @author DDf on 2018/10/12
 */
@Service
public class UserServiceReference {

    @Reference
    private UserService userService;

    public List<User> list() {
        return userService.list();
    }
}
