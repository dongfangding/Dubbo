package com.ddf.dubbo.boot.user.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.ddf.dubbo.boot.user.provider.repository.UserRespository;
import com.ddf.dubbo.common.entity.User;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ddf.dubbo.boot.user.provider.repository"})
@EnableTransactionManagement
@EnableJpaAuditing
@EnableSpringDataWebSupport
@EnableDubbo
@ComponentScan(basePackages = "com.ddf.dubbo")
@EntityScan(basePackages = "com.ddf.dubbo")
public class DubboBootUserProviderApplication implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {
    private static ApplicationContext applicationContext;
    public static void main(String[] args) {
        SpringApplication.run(DubboBootUserProviderApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        UserRespository userRespository = applicationContext.getBean(UserRespository.class);
        userRespository.deleteAll();
        User user = new User("ddf", "123456");
        User user1 = new User("ddf1", "123456");
        User user2 = new User("ddf2", "123456");
        User user3 = new User("ddf3", "123456");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        userRespository.saveAll(list);
    }
}
