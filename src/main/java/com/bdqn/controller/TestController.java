package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zezhong.shang on 16-4-12.
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public void test(){
        System.out.print("test");
    }
}
