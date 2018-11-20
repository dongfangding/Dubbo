package com.ddf.dubbo.boot.user.provider.service.impl;

import com.ddf.dubbo.common.interfaces.user.QuickStartService;
import org.springframework.stereotype.Service;

/**
 * @author DDf on 2018/10/23
 */
@Service
public class QuickStartServiceImpl implements QuickStartService {

    @Override
    public String sayHello(String msg) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello " + msg + " from dubbo-boot-user-provider";
    }
}
