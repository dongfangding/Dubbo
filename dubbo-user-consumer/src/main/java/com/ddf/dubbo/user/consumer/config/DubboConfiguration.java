package com.ddf.dubbo.user.consumer.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author DDf on 2018/10/11
 *
 */
@Configurable
@DubboComponentScan(basePackages = "com.ddf.dubbo.common.interfaces")
public class DubboConfiguration {

    /**
     * 应用信息配置,用以暴漏当前应用，对应配置类ApplicationConfig
     * http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-application.html
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-user-provider");
        return applicationConfig;
    }

    /**
     * 设置消费方的全局配置，
     * 关于配置这一块，请参考官方最佳配置用法http://dubbo.apache.org/zh-cn/docs/user/recommend.html
     * @return
     */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(3000);
        return consumerConfig;
    }

    /**
     * 设置注册中心
     * RegistryConfig 注册中心配置 http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-registry.html
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.1.5:2181");
        return registryConfig;
    }
}
