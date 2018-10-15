package com.ddf.dubbo.boot.user.provider.service.impl;

import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;

import java.util.List;

/**
 * @author DDf on 2018/10/15
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<User> quickStart() {
        return null;
    }

    @Override
    public User registryUser(User user) {
        return user;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }
}
