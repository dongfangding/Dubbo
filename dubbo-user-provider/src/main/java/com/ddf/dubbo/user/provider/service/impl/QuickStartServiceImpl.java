package com.ddf.dubbo.user.provider.service.impl;

import com.ddf.dubbo.common.interfaces.user.QuickStartService;

/**
 * @author DDf on 2018/10/11
 * com.alibaba.dubbo.config.annotation.Service 该注解用来暴露接口，能够让其他消费者识别接口并完成调用
 */
@com.alibaba.dubbo.config.annotation.Service
public class QuickStartServiceImpl implements QuickStartService {
    @Override
    public String sayHello(String msg) {
        return "hello " +  msg + " from dubbo-user-provider";
    }
}
