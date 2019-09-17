package com.bdqn.controller;

import com.bdqn.module.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@CrossOrigin
@RestController
@RequestMapping("/xtx")
public class AuthController {
    /**
     * 用户验证
     * @param token
     * @return
     */

    @GetMapping("/auth/verify")
    public ResponseEntity<UserInfo> verifyUser( HttpServletRequest request,
                                               HttpServletResponse response){
        try{
            //1.从token中解析token信息
            UserInfo userInfo =  new UserInfo();
            userInfo.setId(1l);
            userInfo.setUsername("xtx");
            return ResponseEntity.ok(userInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        //5.出现异常,相应401
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    /**
     * 登录授权
     * @param username
     * @param password
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/auth/accredit")
    public ResponseEntity<Void> authentication(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        //1.登录校验
        if("xtx".equals(username)&&"1qaz2wsx".equals(password)){
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
