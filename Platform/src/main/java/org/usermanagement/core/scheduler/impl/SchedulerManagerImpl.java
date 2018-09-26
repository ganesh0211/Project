package org.usermanagement.core.scheduler.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.usermanagement.core.exception.BusinessException;
import org.usermanagement.core.exception.type.Core;
import org.usermanagement.core.scheduler.SchedulerManager;

@Component
public class SchedulerManagerImpl implements SchedulerManager {

    /**
     * scheduler
     */
    private Scheduler scheduler;

    @Autowired
    private Environment environment;

    @SuppressWarnings(value = {"rawtypes"})
    @Override
    public void createJob(String name, String group,
                          boolean cronJob, String cronPattern, int timeInterval,
                          Map<Object, Object> dataMap, Class implementation)
            throws BusinessException {

        System.out.println("\n\nCREATING JOB HERE*********************");
        try {
            if (scheduler.checkExists(new JobKey(name, group))) {
                throw new BusinessException(Core.SCHEDULER_START_FAILED);
            }

            JobDataMap jobDataMap = new JobDataMap(dataMap);
            JobDetailImpl job = new JobDetailImpl();
            job.setName(name);
            job.setGroup(group);
            job.setJobDataMap(jobDataMap);
            job.setJobClass(implementation);
            scheduler.scheduleJob(job, getTrigger(name, group, cronJob, cronPattern, timeInterval));
            //scheduler.getCurrentlyExecutingJobs();
        } catch (SchedulerException e) {
            e.printStackTrace();
            throw new BusinessException(Core.SCHEDULER_START_FAILED);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new BusinessException(Core.SCHEDULER_START_FAILED);
        }
    }

    private Trigger getTrigger(String name, String group, boolean cronJob, String cronPattern, int timeInterval) throws SchedulerException, ParseException {
        if (cronJob) {
            CronTriggerImpl cronTrigger = new CronTriggerImpl();
            cronTrigger.setName("Trigger_" + name);
            cronTrigger.setGroup(group);
            cronTrigger.setCronExpression(cronPattern);
            return cronTrigger;
        } else {
            SimpleTriggerImpl trigger = new SimpleTriggerImpl();
            trigger.setStartTime(new Date(System.currentTimeMillis() + 10000));
            trigger.setName("Trigger_" + name);
            trigger.setGroup(group);
            trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
            trigger.setRepeatInterval(timeInterval);
            return trigger;
        }
    }


    @Bean
    private Scheduler schedulerBean() throws SchedulerException {
        System.out.println("SCHEDULER BEAN CREATION" + scheduler);
        StdSchedulerFactory schedulerFactory = new StdSchedulerFactory();
        schedulerFactory.initialize(schedulerProperties(true));
        scheduler = schedulerFactory.getScheduler();
        System.out.println("SCHEDULER BEAN BEFORE START" + scheduler);
        scheduler.start();
        System.out.println("SCHEDULER BEAN AFTER START" + scheduler);
        return scheduler;
    }


    private Properties schedulerProperties(boolean clustered) {
        Properties properties = new Properties();
        properties.put("org.quartz.jobStore.class", environment.getRequiredProperty("org.quartz.jobStore.class"));
        properties.put("org.quartz.jobStore.isClustered", clustered);
        properties.put("org.quartz.jobStore.dataSource", environment.getRequiredProperty("org.quartz.jobStore.dataSource"));
        properties.put("org.quartz.threadPool.threadCount", environment.getRequiredProperty("org.quartz.threadPool.threadCount"));
        properties.put("org.quartz.dataSource.mysql.driver", environment.getRequiredProperty("hibernate.connection.driver_class"));
        properties.put("org.quartz.dataSource.mysql.URL", environment.getRequiredProperty("hibernate.connection.url"));
        properties.put("org.quartz.dataSource.mysql.user", environment.getRequiredProperty("hibernate.connection.username"));
        properties.put("org.quartz.dataSource.mysql.password", environment.getRequiredProperty("hibernate.connection.password"));
        properties.put("org.quartz.dataSource.mysql.maxConnections", environment.getRequiredProperty("org.quartz.dataSource.mysql.maxConnections"));
        properties.put("org.quartz.jobStore.tablePrefix", environment.getRequiredProperty("org.quartz.jobStore.tablePrefix"));
        properties.put("org.quartz.jobStore.driverDelegateClass", environment.getRequiredProperty("org.quartz.jobStore.driverDelegateClass"));
        return properties;
    }

    @Override
    public void deleteJob(String name, String group) throws BusinessException {
        try {
            scheduler.deleteJob(new JobKey(name, group));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(Core.SCHEDULER_START_FAILED);
        }
    }

    @Override
    public void pauseJob(String name, String group) throws BusinessException {
        try {
            scheduler.pauseJob(new JobKey(name, group));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException(Core.SCHEDULER_START_FAILED);
        }

    }

    @Override
    public void resumeJob(String name, String group) throws BusinessException {
        try {
            scheduler.resumeJob(new JobKey(name, group));
        } catch (Exception e) {
            throw new BusinessException(Core.SCHEDULER_START_FAILED);
        }

    }


    @Override
    public void pauseAllJob() throws BusinessException {
        try {
            scheduler.pauseAll();
        } catch (Exception e) {
            throw new BusinessException(Core.SCHEDULER_START_FAILED);
        }

    }

    @Override
    public void resumeAllJob() throws BusinessException {
        try {
            scheduler.resumeAll();
        } catch (Exception e) {
            throw new BusinessException(Core.SCHEDULER_START_FAILED);
        }
    }

}
