package com.ddf.dubbo.user.provider;

import com.ddf.dubbo.user.provider.config.MainConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author DDf on 2018/10/11
 */
public class Application {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        context.start();
        System.in.read();
    }
}
