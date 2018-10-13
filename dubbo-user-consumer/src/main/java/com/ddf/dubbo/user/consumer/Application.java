package com.ddf.dubbo.user.consumer;

import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.common.interfaces.user.UserService;
import com.ddf.dubbo.user.consumer.config.DubboConfiguration;
import com.ddf.dubbo.user.consumer.service.UserServiceRef;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author DDf on 2018/10/11
 */
public class Application {
    public static void main(String[] args) throws IOException {
        loadWithAnnotation();
    }

    /**
     * 通过注解API来完成Dubbo的服务调用
     */
    private static void loadWithAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboConfiguration.class);
        context.start();

        UserServiceRef userServiceRef = context.getBean(UserServiceRef.class);
        List<User> list = userServiceRef.list();
        System.out.println("list = " + list);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过配置文件来完成Dubbo的服务调用
     */
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
