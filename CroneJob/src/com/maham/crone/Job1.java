package com.maham.crone;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class Job1 implements Job{
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Job1 --->>> Time is " + new Date());
		EmailUtil.sendEmail("mahamiqbal990@gmail.com","Email Testing Subject1", "Email Testing Body1");
		}
	

}
