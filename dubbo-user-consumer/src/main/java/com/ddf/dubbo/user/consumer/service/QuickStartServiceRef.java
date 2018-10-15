package com.ddf.dubbo.user.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddf.dubbo.common.interfaces.user.QuickStartService;
import org.springframework.stereotype.Service;

/**
 * @author DDf on 2018/10/15
 */
@Service
public class QuickStartServiceRef {

    @Reference
    private QuickStartService quickStartService;

    public String sayHello(String msg) {
        return quickStartService.sayHello(msg);
    }
}
