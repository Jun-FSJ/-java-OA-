package com.jun.service;

import java.util.List;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.Employee;
import com.jun.pojo.EmployeeDto;
import com.jun.pojo.User;

public interface EmployeeService {
	/**
	 * 分页查询全部员工
	 * @param page
	 * @param user
	 * @return
	 */
	EasyUIGrid selAllPage(Integer page,EmployeeDto employeeDto);
	
	Employee findByCardId(String cardId);
	/**
	 * 添加
	 * @param employee
	 */
	void insEmployee(Employee employee);
	
	Employee findById(Integer id);
	/**
	 * 删除根据id
	 * @param id
	 */
	void delById(List<Integer> employeeIds);
	/**
	 * 修改根据id
	 * @param id
	 */
	void updById(Employee employee);
}
