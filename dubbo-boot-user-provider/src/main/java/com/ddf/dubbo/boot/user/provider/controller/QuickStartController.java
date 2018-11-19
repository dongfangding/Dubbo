package com.ddf.dubbo.boot.user.provider.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ddf.dubbo.common.interfaces.user.QuickStartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DDf on 2018/11/19
 */
@RestController
public class QuickStartController {

    @Reference
    private QuickStartService quickStartService;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String msg) {
        return quickStartService.sayHello(msg);
    }
}
