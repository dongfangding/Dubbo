package com.ddf.dubbo.user.provider;

import com.ddf.dubbo.user.provider.config.MainConfiguration;
import com.ddf.dubbo.user.provider.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author DDf on 2018/10/11
 */
public class Application {

    private static ApplicationContext context;
    public static void main(String[] args) {
        loadWithAnnotation();

        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        System.out.println("userService = " + userService);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用注解配置来配置Dubbo的实现
     * 参考http://dubbo.apache.org/zh-cn/docs/user/configuration/annotation.html
     * 需要 2.5.7 及以上版本支持
     */
    private static void loadWithAnnotation() {
        context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        AnnotationConfigApplicationContext annotationConfigApplicationContext = (AnnotationConfigApplicationContext) context;
        annotationConfigApplicationContext.start();
    }
}
