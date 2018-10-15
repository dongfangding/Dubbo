package com.ddf.dubbo.user.consumer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author DDf on 2018/10/14
 * 主配置类，使用@Import来导入不同的配置类
 *
 * @ImportResource 用来演示使用xml配置的方式来启动Dubbo，因目前主要使用配置类的方式来完成，所以演示的时候掉@Import，其余情况注释即可，这里只是演示
 */
@Configuration
@ComponentScan("com.ddf.dubbo.user.consumer")
//@Import(value = {DubboConfiguration.class})
@ImportResource(value = {"classpath:user-consumer.xml"})
public class MainConfiguration {
}
