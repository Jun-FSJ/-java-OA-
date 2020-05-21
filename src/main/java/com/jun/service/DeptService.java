package com.jun.service;

import java.util.List;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.Dept;
import com.jun.pojo.User;

public interface DeptService {
	/**
	 * 分页查询全部部门
	 * @param page
	 * @param user
	 * @return
	 */
	EasyUIGrid selAllPage(Integer page,Dept dept);
	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	int insDept(Dept dept);
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	int delDept(Integer id);
	/**
	 * 修改部门
	 * @param dept
	 * @return
	 */
	int updDept(Dept dept);
	/**
	 * 查询全部
	 * @return
	 */
	List<Dept> getAll();
	/**
	 * 获取所有通过id
	 * @param id
	 * @return
	 */
	Dept getAllById(Integer id);
}
