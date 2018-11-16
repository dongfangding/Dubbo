package com.ddf.dubbo.boot.user.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ddf.dubbo.common.interfaces.user.QuickStartService;

/**
 * @author DDf on 2018/10/23
 * dubbo如何既作为消费方又作为提供者？protocol的port如果和提供者不一样，则不能消费，而如果一样，则又会提示地址已经被使用
 */
@Service
public class QuickStartServiceImpl implements QuickStartService {
    @Override
    public String sayHello(String msg) {
        return "hello " + msg + " from dubbo-boot-user-consumer";
    }
}
