package com.ddf.dubbo.user.provider.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author DDf on 2018/10/11
 * 指定暴露接口的实现类，需要实现类使用@Service注解，需要注意的是这个是com.alibaba.dubbo.config.annotation.Service的包，不要导错了
 * @DubboComponentScan(basePackages = "com.ddf.dubbo.user.provider.service.impl")
 */
@Configurable
@ComponentScan("com.ddf.dubbo")
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
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-user-provider");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.1.5:2181");
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
