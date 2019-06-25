package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019-06-16.
 */
@Controller
@RequestMapping("/htsi")
public class HowToSolveItController
{
    @RequestMapping(value = "/sorry", method = RequestMethod.GET, produces="text/html;charset=UTF-8")
    public String testFunc(){
        return "/pre/test/index";
    }
}
