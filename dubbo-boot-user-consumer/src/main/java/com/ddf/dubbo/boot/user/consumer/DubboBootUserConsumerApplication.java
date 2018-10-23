package com.ddf.dubbo.boot.user.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ddf.dubbo.boot.user.consumer"})
@EnableTransactionManagement
@EnableJpaAuditing
@EnableSpringDataWebSupport
@EnableDubbo
@ComponentScan(basePackages = "com.ddf.dubbo")
@EntityScan(basePackages = "com.ddf.dubbo")
public class DubboBootUserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboBootUserConsumerApplication.class, args);
    }
}
