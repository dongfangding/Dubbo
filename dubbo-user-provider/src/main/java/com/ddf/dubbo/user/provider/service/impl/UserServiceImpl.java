package com.ddf.dubbo.user.provider.service.impl;

import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {
    /**
     * 实现UserService，演示快速暴露一个接口
     * @return
     */
    @Override
    public List<User> quickStart() {
        User user = new User(1, "ddf", "123456");
        User user1 = new User(2, "yichen", "987654");
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user1);
        return users;
    }

    @Override
    public User registryUser(User user) {
        return null;
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
