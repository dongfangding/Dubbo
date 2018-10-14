package com.ddf.dubbo.user.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DDf on 2018/10/11
 * com.alibaba.dubbo.config.annotation.Service 该注解用来暴露接口，能够让其他消费者识别接口并完成调用
 * org.springframework.stereotype.Service 将该接口加入到Spring的容器中，根据实际情况看是否需要这个功能
 * 这里只是演示，注解不要用错了，Dubbo的@Service注解并不提供Spring的IOC的功能
 */
@Service
@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService {

    /**
     * 实现UserService，演示快速暴露一个接口
     * @return
     */
    public List<User> quickStart() {
        User user = new User(1, "ddf", "123456");
        User user1 = new User(2, "yichen", "987654");
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user1);
        return users;
    }
}
