package org.usermanagement.core.scheduler.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import org.usermanagement.core.exception.BusinessException;
import org.usermanagement.core.exception.type.Core;
import org.usermanagement.core.scheduler.SchedulerManager;

@Component
public class SchedulerManagerImpl implements SchedulerManager {

	/**
	 * scheduler 
	 */
	@Autowired
	@Qualifier("schedulerBean")
	private Scheduler scheduler;
	
	@Autowired
	@Qualifier("defaultDataSource")
	private DataSource defaultDataSource;
	
	@SuppressWarnings(value = {"rawtypes" })
	@Override
	public void createJob(String name, String group,
			boolean cronJob, String cronPattern,int timeInterval,
			Map<Object, Object> dataMap, Class implementation)
			throws BusinessException {
		
		try{
			if(scheduler.checkExists(new JobKey(name, group))) {
				throw new BusinessException(Core.SCHEDULER_START_FAILED);
			}
			
			JobDataMap jobDataMap = new JobDataMap(dataMap);
			JobDetailImpl job = new JobDetailImpl();
			job.setName(name);
			job.setGroup(group);
			job.setJobDataMap(jobDataMap);
			job.setJobClass(implementation);
			scheduler.scheduleJob(job, getTrigger(name, group, cronJob, cronPattern, timeInterval));
    	}catch(SchedulerException e){
    		throw new BusinessException(Core.SCHEDULER_START_FAILED);
    	}catch(ParseException e){
    		throw new BusinessException(Core.SCHEDULER_START_FAILED);
    	}
	}
	
	private Trigger getTrigger(String name, String group,boolean cronJob, String cronPattern, int timeInterval) throws SchedulerException, ParseException{
		if(cronJob) {
			CronTriggerImpl cronTrigger = new CronTriggerImpl();
			cronTrigger.setName("Trigger_"+name);
			cronTrigger.setGroup(group);
			cronTrigger.setCronExpression(cronPattern);
			return cronTrigger;
		}else{
	    	SimpleTriggerImpl trigger = new SimpleTriggerImpl();
	    	trigger.setStartTime(new Date(System.currentTimeMillis() + 10000));
	    	trigger.setName("Trigger_"+name);
	    	trigger.setGroup(group);
	    	trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
	    	trigger.setRepeatInterval(timeInterval);
	    	return trigger;
		}
	}
	
	
	@Bean
	private Scheduler schedulerBean() throws SchedulerException{
		SchedulerFactoryBean schedulerFactorybean = new SchedulerFactoryBean();
		schedulerFactorybean.setDataSource(defaultDataSource);
		Scheduler scheduler = schedulerFactorybean.getScheduler();
    	scheduler.start();
		return scheduler;
	}

	@Override
	public void deleteJob(String name, String group) throws BusinessException {
		try{
			scheduler.deleteJob(new JobKey(name, group));
		}catch(Exception e) {
			throw new BusinessException(Core.SCHEDULER_START_FAILED);
		}
	}

	@Override
	public void pauseJob(String name, String group) throws BusinessException {
		try{
			scheduler.pauseJob(new JobKey(name, group));
		}catch(Exception e) {
			throw new BusinessException(Core.SCHEDULER_START_FAILED);
		}
		
	}

	@Override
	public void resumeJob(String name, String group) throws BusinessException {
		try{
			scheduler.resumeJob(new JobKey(name, group));
		}catch(Exception e) {
			throw new BusinessException(Core.SCHEDULER_START_FAILED);
		}
		
	}


	@Override
	public void pauseAllJob() throws BusinessException {
		try{
			scheduler.pauseAll();
		}catch(Exception e) {
			throw new BusinessException(Core.SCHEDULER_START_FAILED);
		}
		
	}

	@Override
	public void resumeAllJob() throws BusinessException {
		try{
			scheduler.resumeAll();
		}catch(Exception e) {
			throw new BusinessException(Core.SCHEDULER_START_FAILED);
		}
	}

}
