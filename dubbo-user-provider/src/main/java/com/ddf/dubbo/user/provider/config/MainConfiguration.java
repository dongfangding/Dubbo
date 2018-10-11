package com.ddf.dubbo.user.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author DDf on 2018/10/11
 */
@Configurable
@ComponentScan("com.ddf.dubbo")
public class MainConfiguration {

    /**
     * 应用信息配置,用以暴漏当前应用，对应配置类ApplicationConfig
     * http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-application.html
     * RegistryConfig 注册中心配置 http://dubbo.apache.org/zh-cn/docs/user/references/xml/dubbo-registry.html
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-user-provider");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("192.168.135:2181");
        applicationConfig.setRegistry(registryConfig);
        return applicationConfig;
    }


    /**
     * 服务提供者协议配置
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
