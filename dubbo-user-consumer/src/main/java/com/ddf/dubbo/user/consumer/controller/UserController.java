package com.ddf.dubbo.user.consumer.controller;

import com.ddf.dubbo.common.interfaces.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author DDf on 2018/10/11
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;


}
