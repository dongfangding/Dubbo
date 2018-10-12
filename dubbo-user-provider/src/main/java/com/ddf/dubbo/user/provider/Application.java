package com.ddf.dubbo.user.provider;

import com.ddf.dubbo.common.interfaces.user.UserService;
import com.ddf.dubbo.user.provider.config.DubboConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author DDf on 2018/10/11
 */
public class Application {
    public static void main(String[] args) throws IOException {
        loadWithAnnotation();
    }

    /**
     * 使用注解配置来配置Dubbo的实现
     * 参考http://dubbo.apache.org/zh-cn/docs/user/configuration/annotation.html
     * 需要 2.5.7 及以上版本支持
     */
    private static void loadWithAnnotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DubboConfiguration.class);
        context.start();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用XML配置方式来加载Dubbo配置文件
     * 快速启动参考： http://dubbo.apache.org/zh-cn/docs/user/quick-start.html
     * 详细schema配置： http://dubbo.apache.org/zh-cn/docs/user/references/xml/introduction.html
     */
    private static void loadWithXML() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:user-provider.xml"});
        context.start();
        UserService bean = context.getBean(UserService.class);
        System.out.println("bean: " + bean);
        try {
            System.in.read(); // 按任意键退出*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
