package com.ddf.dubbo.user.consumer;

import com.ddf.dubbo.common.interfaces.user.UserService;
import com.ddf.dubbo.user.consumer.config.MainConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author DDf on 2018/10/11
 */
public class Application {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        context.start();
        UserService userService = context.getBean(UserService.class);
        userService.list();
        System.in.read();
    }
}
