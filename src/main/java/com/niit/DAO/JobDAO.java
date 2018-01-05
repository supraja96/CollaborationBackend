package com.niit.DAO;

import java.util.List;

import com.niit.model.Job;

public interface JobDAO {

	public boolean addJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> getAllJobs();
	public Job getJob(int jobId);
	public boolean deleteJob(Job job);
	
}
