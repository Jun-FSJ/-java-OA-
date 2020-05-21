package com.jun.pojo;

public class NewEmployee extends Employee{
	private Job job;
	private Dept dept;
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "NewEmployee [job=" + job + ", dept=" + dept + "]";
	}
	
}
