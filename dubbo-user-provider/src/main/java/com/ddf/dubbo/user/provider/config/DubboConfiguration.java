package com.ddf.dubbo.user.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.context.annotation.Bean;


/**
 *
 * @author DDf on 2018/10/11
 * @DubboComponentScan 扫描所有标注了注解com.alibaba.dubbo.config.annotation.Service，需要暴露的接口
 *
 *
 * 配置手册请参考官网：
 * http://dubbo.apache.org/zh-cn/docs/user/references/xml/introduction.html
 *
 */
@DubboComponentScan(basePackages = "com.ddf.dubbo.user.provider.service.impl")
public class DubboConfiguration {

    /**
     * 应用信息配置,用以暴漏当前应用，对应配置类ApplicationConfig
     * http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-application.html
     * RegistryConfig 注册中心配置 http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-registry.html
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        // 描述当前应用信息
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-user-provider");

        // 注册中心地址
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.1.5:2181");
        applicationConfig.setRegistry(registryConfig);
        return applicationConfig;
    }


    /**
     * 协议配置
     * http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-protocol.html
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }
}
