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
    /**
     * 如果使用xml配置文件已经使用了<dubbo:reference></dubbo:reference>标签生成了远程服务代理对象，则这里使用就可以使用@Autowired，
     * 否则，则需要使用@Reference
     */
    /*@Autowired
    private QuickStartService quickStartService;*/

    public String sayHello(String msg) {
        return quickStartService.sayHello(msg);
    }
}
