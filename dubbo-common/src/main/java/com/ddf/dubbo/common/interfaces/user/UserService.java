package com.ddf.dubbo.common.interfaces.user;

import com.ddf.dubbo.common.entity.User;

import java.util.List;

/**
 * @author DDf on 2018/10/11
 */
public interface UserService {

    List<User> quickStart();

    User registryUser(User user);

    User login(String username, String password);

    List<User> list();
}
