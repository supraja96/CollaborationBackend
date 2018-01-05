package com.niit.Test;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.niit.DAO.JobDAO;
import com.niit.config.DbConfig;
import com.niit.model.Blog;
import com.niit.model.Job;
@Ignore
@ComponentScan("com.niit.*")
public class JobTest {

    static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.niit");
        context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
	
	@Test
	public void addJobTest(){
		Job job=new Job();
		job.setJobId(12);
		job.setJobProfile("Software-IT");
		job.setJobDesc("Software developer");
		job.setQualification("B.SC/MBA");
		job.setStatus("Eligible");
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problems in Inserting Job",jobDAO.addJob(job));
	}
	@Ignore
	@Test
	public void updateJobTest()
	{
		Job job=(Job)jobDAO.getJob(12);
		job.setJobProfile("Developer");
		job.setJobDesc("developing applications");
		job.setQualification("M.Tech");
		
		assertTrue("Problem in updating job",jobDAO.updateJob(job));
	}
	@Ignore
	@Test
	public void deleteJobTest(){
		Job job=(Job)jobDAO.getJob(12);
		assertTrue("Problem in deletion",jobDAO.deleteJob(job));
	}
	@Ignore
	@Test
	public void getAllJobTest(){
	List<Job> jobList=(List<Job>)jobDAO.getAllJobs();
	assertNotNull("Job list not found ",jobList.get(0));
	     for(Job job:jobList)
	{
		System.out.println("JobID:"+ job.getJobId() + "JobProfile:"+ job.getJobProfile());
	}
	
	}
	
	@Ignore
	@Test
	public void getJobTest(){

	Job job=(Job)jobDAO.getJob(12);
	System.out.println("JobProfile:" + job.getJobProfile());
	System.out.println("JobDescription:" + job.getJobDesc());
	
	assertNotNull("Job not found", job);
	}
	
}

