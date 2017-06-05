package org.usermanagement.core;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 5/6/17
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
@DisallowConcurrentExecution
public class SimpleJobCheck implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.print("JOB CALLED " + new Date() + " " + context.getJobDetail().getKey());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
