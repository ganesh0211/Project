package org.usermanagement.core.scheduler;
import java.util.HashMap;
import java.util.Map;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration 
@ComponentScan("org.util.scheduler") 
public class QuartzConfiguration {
	@Bean
	public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("jobone");
		obj.setTargetMethod("myTask");
		return obj;
	}
	
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "RAM");
		
		factory.setJobDataAsMap(map);
		factory.setGroup("mygroup");
		factory.setName("myjob");
		return factory;
	}
	
	//Job is scheduled after every 1 minute 
	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(){
		CronTriggerFactoryBean cronTriggerFactory = new CronTriggerFactoryBean();
		cronTriggerFactory.setJobDetail(jobDetailFactoryBean().getObject());
		cronTriggerFactory.setStartDelay(3000);
		cronTriggerFactory.setName("mytrigger");
		cronTriggerFactory.setGroup("mygroup");
		cronTriggerFactory.setCronExpression("0 0/1 * 1/1 * ? *");
		return cronTriggerFactory;
	}
	
	@Bean
	@Autowired
	public Scheduler schedulerBean(@Qualifier("schedulerFactoryBean") SchedulerFactoryBean schedulerFactoryBean) {
		return schedulerFactoryBean.getScheduler();
	}
	
	@Bean
	private SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactorybean = new SchedulerFactoryBean();
		return schedulerFactorybean;
	}
	
	
} 