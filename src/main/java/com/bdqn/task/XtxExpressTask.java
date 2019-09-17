package com.bdqn.task;

import com.bdqn.service.IExpressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class XtxExpressTask {
    @Autowired
    IExpressInfoService expressInfoService;
    @Scheduled(cron ="00 02 11 17 * ?")
    public void task02() {
        System.out.println(Thread.currentThread().getName() + " | task02222 " + new Date().toLocaleString());
        expressInfoService.removeAll();
    }

}
