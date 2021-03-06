package com.ddf.dubbo.boot.user.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddf.dubbo.boot.user.provider.repository.UserRespository;
import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author DDf on 2018/10/15
 *
 * 本类主要做演示，不对数据进行合理性或重复性校验
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRespository userRespository;

    @Override
    @Transactional
    public List<User> batchRegistryUser(Iterable<User> iterable) {
        return userRespository.saveAll(iterable);
    }

    @Override
    @Transactional
    public User registryUser(User user) {
        return userRespository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User login(String username, String password) {
        User user = userRespository.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            return user;
        }
        throw new RuntimeException("用户不存在, 用户： " + username + "密码: " + password);
    }

    /**
     * 如果使用Controller来接收客户端参数，则可以使用Pageable对象直接接收客户端的参数，会被自动封装成对象
     * 但是使用dubbo协议之后Pageable并不能序列化传输，所以这里只能修改为基础属性，同样返回的Page对象也不能
     * 序列化传输，所以修改为了List对象来接收
     * @param page
     * @param size
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> list(int page, int size) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRespository.findAll(pageRequest).getContent();
    }
}
