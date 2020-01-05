package com.hxyc.quartz;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @ClassName SimpleJob
 * @Description TODO
 * @Author admin
 * @Date 2020/1/5 17:49
 **/
@Configuration
@EnableScheduling  //开启任务调度
public class SimpleJob {

    //每隔五秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void run(){
        //任务
        //err红色输出
        System.err.println(LocalDateTime.now());
    }
}
