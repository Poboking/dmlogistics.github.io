package rog.sziit.dynamicplus.task;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author:poboking
 * @version:1.0
 * @time:2023/5/22 14:47
 */



/**
 * SchedulerManager 类用于管理 Quartz 调度器，实现定时任务的创建、启动、停止等功能
 * @Component
 */
public class SchedulerManager {
 @Autowired
 private Scheduler scheduler;

 /**
  * 创建并启动定时任务
  * @param dataSourceName 数据源名称
  * @param cronExpression Cron 表达式，指定任务执行的时间规则
  * @throws SchedulerException 如果调度器调度失败，则抛出该异常
 */
public void scheduleJob(String dataSourceName, String cronExpression) throws SchedulerException {
        // 创建 JobDetail 对象，指定任务实例和任务名称
        JobDetail jobDetail = JobBuilder.newJob(SyncDataBaseJob.class)
        .withIdentity("SyncDataBaseJob", dataSourceName)
        .build();

        // 创建 Trigger 对象，指定任务执行时间规则
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
        .withIdentity("SyncDataBaseTrigger", dataSourceName)
        .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
        .build();

        // 向任务的 JobDataMap 中添加数据源名称属性
        jobDetail.getJobDataMap().put("dataSourceName", dataSourceName);

        // 使用调度器将任务与触发器进行绑定
        scheduler.scheduleJob(jobDetail, cronTrigger);
        }
}