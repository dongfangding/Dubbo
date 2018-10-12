package com.ddf.dubbo.user.consumer;

import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author DDf on 2018/10/11
 */
public class Application {
    public static void main(String[] args) throws IOException {
        loadWithXml();
    }

    private static void loadWithXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:user-consumer.xml"});
        context.start();
        // 获取远程服务代理
        UserService userService = (UserService) context.getBean("userService");
        List<User> list = userService.list();
        // 执行远程方法
        userService.list();
        // 显示调用结果
        System.out.println(list);
    }
}
