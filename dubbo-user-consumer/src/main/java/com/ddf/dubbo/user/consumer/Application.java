package com.ddf.dubbo.user.consumer;

import com.ddf.dubbo.common.entity.User;
import com.ddf.dubbo.user.consumer.config.DubboConfiguration;
import com.ddf.dubbo.user.consumer.service.UserServiceRef;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author DDf on 2018/10/11
 */
public class Application {
    private static ApplicationContext context;

    public static void main(String[] args) {
        loadWithAnnotation();

        UserServiceRef userServiceRef = context.getBean(UserServiceRef.class);
        List<User> list = userServiceRef.quickStart();
        System.out.println("quickStart = " + list);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过注解API来完成Dubbo的服务调用
     */
    private static void loadWithAnnotation() {
        context = new AnnotationConfigApplicationContext(DubboConfiguration.class);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = (AnnotationConfigApplicationContext ) context;
        annotationConfigApplicationContext.start();
    }
}
