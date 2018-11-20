package com.ddf.dubbo.boot.user.consumer.config;

import com.alibaba.dubbo.config.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author DDf on 2018/11/20
 */
@Configuration
public class DubboConfig {


    /**
     * 设置默认的消费端的属性，该属性会被应用到<dubbo:reference>标签；
     * 该配置会覆盖默认的服务端配置的属性
     * @return
     */
    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setTimeout(5 * 1000);
        consumerConfig.setRetries(0);
        consumerConfig.setVersion("1.0");
        consumerConfig.setLoadbalance("random");
        return consumerConfig;
    }
}
