package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019-06-16.
 */
@Controller
@RequestMapping("/htsi")
public class HowToSolveItController
{
    @RequestMapping("/test")
    @ResponseBody
    public String testFunc(){
        return "nice";
    }
}
