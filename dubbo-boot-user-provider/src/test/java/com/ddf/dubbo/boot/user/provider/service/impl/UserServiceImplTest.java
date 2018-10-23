package com.ddf.dubbo.boot.user.provider.service.impl;

import com.ddf.dubbo.boot.user.provider.DubboBootUserProviderApplicationTests;
import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author DDf on 2018/10/18
 */
public class UserServiceImplTest extends DubboBootUserProviderApplicationTests {

    @Autowired
    private UserService userService;


    @Test
    public void testRegistryUser() {
        User user = new User("测试1", "123456");
        userService.registryUser(user);
    }

    @Test
    public void testBatchRegistryUser() {
        User user = new User("测试2", "123456");
        User user1 = new User("测试3", "123456");
        User user2 = new User("测试4", "123456");
        User user3 = new User("测试5", "123456");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        userService.batchRegistryUser(list);
    }

    @Test
    @Transactional
    public void testList() {
        Page<User> page = userService.list(1, 10);
        if (page != null && page.getContent() != null) {
            System.out.println("-------------testList----------------");
            List<User> content = page.getContent();
            for (User user : content) {
                System.out.println(user.getUsername() + "***********************");
            }
            System.out.println("-------------testList----------------");
        }
    }
}
