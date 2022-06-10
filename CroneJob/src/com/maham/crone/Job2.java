package com.maham.crone;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
public class Job2 implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Job2 --->>> Time is " + new Date());
		EmailUtil.sendEmail("mahamiqbal990@gmail.com","Email Testing Subject2", "Email Testing Body2");
		} 
}
