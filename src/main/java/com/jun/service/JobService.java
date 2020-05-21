package com.jun.service;

import java.util.List;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.Dept;
import com.jun.pojo.Job;
import com.jun.pojo.User;

public interface JobService {
	/**
	 * 分页查询全部部门
	 * @param page
	 * @param user
	 * @return
	 */
	EasyUIGrid selAllPage(Integer page,Job job);
	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	int insJob(Job job);
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	int delJob(Integer id);
	/**
	 * 修改部门
	 * @param dept
	 * @return
	 */
	int updJob(Job job);
	/**
	 * 查询全部
	 * @return
	 */
	List<Job> getAll();
	/**
	 * 获取所有通过id
	 * @param id
	 * @return
	 */
	Job getAllById(Integer id);
}
