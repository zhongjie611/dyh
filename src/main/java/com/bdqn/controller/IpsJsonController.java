package com.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019-06-25.
 */
@RestController
public class IpsJsonController {

    @RequestMapping("/ipsjson")
    public String getIpsJson(){
        return "{\"boolean\":true,\"string\":\"string\",\"list\":[1,2,3],\"int\":2}";
    }

}
