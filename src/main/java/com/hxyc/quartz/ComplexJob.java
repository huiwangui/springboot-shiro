package com.hxyc.quartz;

import com.hxyc.dao.CronDao;
import com.hxyc.model.Cron;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @ClassName ComplexJob
 * @Description TODO 需求：cron的表达式来自于数据库
 * @Author admin
 * @Date 2020/1/5 18:06
 **/
@Configuration
@EnableScheduling  //开启任务调度
public class ComplexJob implements SchedulingConfigurer{

    @Resource
    @SuppressWarnings("all")
    CronDao cronDao;

    //任务  触发器
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                //任务
                System.out.println(LocalDateTime.now());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                Cron cron = cronDao.findById(1);
                return new CronTrigger(cron.getCron()).nextExecutionTime(triggerContext);
            }
        });

    }
}
