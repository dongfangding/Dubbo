package com.ddf.dubbo.boot.user.provider.config;

import com.alibaba.dubbo.config.*;
import com.ddf.dubbo.boot.user.provider.service.impl.QuickStartServiceImpl;
import com.ddf.dubbo.common.interfaces.user.QuickStartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DDf on 2018/11/20
 * 如果使用注解的方式，但某些需要控制到具体方法级别的配置怎么办？
 *
 * 1. 使用配置类（但官方似乎并不推荐）
 * 2. 使用XML配置，使用@ImportSource注解将配置文件导入到配置类中使之生效
 *
 *
 * 配置类的使用方式：
 * 1. 首先暴漏的接口实现类不能再使用dubbo的@service注解
 * 2. 使用spring的@service注解将实现类加入到容器中，注入到配置类中
 * 3. 使用ServiceConfig设置容器中的实现类，才能保证实现类正常使用IOC功能
 * 4. 使用MethodConfig来控制方法的配置
 * 5. 将使用MethodConfig来控制方法的配置应用当前的使用ServiceConfig设置容器中的实现类
 * 6. 使用ServiceConfig的export()方法来暴露服务
 *
 *
 * Configuration先注释掉该配置类，使之不能生效，这里只是作为备份演示
 */
@Configuration
public class DubboConfig {
    @Autowired
    private ApplicationConfig applicationConfig;
    @Autowired
    private RegistryConfig registryConfig;
    @Autowired
    private QuickStartService quickStartService;


    /**
     * 演示使用ServiceConfig来控制某个接口下方法级别的配置
     * @return
     */
    @Bean
    public ServiceConfig<QuickStartServiceImpl> userServiceServiceConfig() {
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setInterface(QuickStartService.class);
        serviceConfig.setRef(quickStartService);
        serviceConfig.setVersion("1.0");

        List<MethodConfig> methodConfigs = new ArrayList<>();
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("sayHello");
        methodConfig.setTimeout(1001);
        methodConfig.setRetries(2);
        methodConfigs.add(methodConfig);

        serviceConfig.setMethods(methodConfigs);

        serviceConfig.export();
        return serviceConfig;
    }

    /**
     * 在 Provider 上尽量多配置 Consumer 端属性
     * http://dubbo.apache.org/zh-cn/docs/user/recommend.html
     * 对暴露的接口进行默认的属性配置，如果消费端没有配置，则会使用服务端配置的属性，这作为一种缺省配置
     * 经测试对单独的ServiceConfig/MethodConfig配置类不生效
     */
    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setVersion("1.0");
        providerConfig.setTimeout(10 * 1000);
        providerConfig.setRetries(0);
        // 默认随机
        providerConfig.setLoadbalance("random");
        return providerConfig;
    }
}
