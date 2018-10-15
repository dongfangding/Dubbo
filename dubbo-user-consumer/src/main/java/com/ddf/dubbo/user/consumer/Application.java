package com.ddf.dubbo.user.consumer;

import com.ddf.dubbo.user.consumer.config.MainConfiguration;
import com.ddf.dubbo.user.consumer.service.QuickStartServiceRef;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author DDf on 2018/10/11
 */
public class Application {
    private static AnnotationConfigApplicationContext context;

    public static void main(String[] args) {
        loadWithAnnotation();

        QuickStartServiceRef quickStartServiceRef = context.getBean(QuickStartServiceRef.class);
        String sayHello = quickStartServiceRef.sayHello("消费者传参调用服务者实现");
        System.out.println("sayHello = " + sayHello);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过注解配置类来完成Dubbo的服务调用
     */
    private static void loadWithAnnotation() {
        context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        context.start();
    }
}
