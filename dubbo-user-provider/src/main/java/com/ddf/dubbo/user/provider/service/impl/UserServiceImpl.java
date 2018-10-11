package com.ddf.dubbo.user.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DDf on 2018/10/11
 */
@Service
public class UserServiceImpl implements UserService {

    public List<User> list() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User(1, "ddf", "123456"));
        userList.add(new User(2, "yichen", "123456"));
        userList.add(new User(3, "dongfang.ding", "123456"));
        return userList;
    }
}
