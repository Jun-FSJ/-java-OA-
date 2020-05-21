package com.jun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jun.mapper.DeptMapper;
import com.jun.mapper.EmployeeMapper;
import com.jun.mapper.JobMapper;
import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.Employee;
import com.jun.pojo.EmployeeDto;
import com.jun.pojo.User;
import com.jun.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeMapper employeeMapper;
	@Resource
	private DeptMapper deptMapper;
	@Resource
	private JobMapper jobMapper;

	@Override
	public EasyUIGrid selAllPage(Integer page, EmployeeDto employeeDto) {
		PageHelper.startPage(page, 2);
		if (StringUtils.isBlank(employeeDto.getName())) {
			employeeDto.setName(null);
		}
		if (StringUtils.isBlank(employeeDto.getCardId())) {
			employeeDto.setCardId(null);
		}
		if (StringUtils.isBlank(employeeDto.getPhone())) {
			employeeDto.setPhone(null);
		}
		Employee employee = new Employee();
		employee.setPhone(employeeDto.getPhone());
		employee.setDept_id(employeeDto.getDeptId());
		employee.setJob_id(employeeDto.getJobId());
		employee.setName(employeeDto.getName());
		employee.setCard_id(employeeDto.getCardId());
		employee.setSex(employeeDto.getSex());
		List<Employee> list = employeeMapper.selAllPage(employee);

		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		EasyUIGrid easyUIGrid = new EasyUIGrid();

		easyUIGrid.setTotal(pageInfo.getTotal());
		easyUIGrid.setRows(pageInfo.getList());
		return easyUIGrid;
	}

	@Override
	public void insEmployee(Employee employee) {
		employeeMapper.insert(employee);
	}

	public void delById(List<Integer> employeeIds) {
		// 循环删除
		for (Integer employeeId : employeeIds) {
			employeeMapper.delete(employeeId);
		}
	}

	@Override
	public void updById(Employee employee) {
		employeeMapper.updateEm(employee);
	}

	@Override
	public Employee findByCardId(String cardId) {
		return employeeMapper.getByCardId(cardId);
	}

	@Override
	public Employee findById(Integer id) {
		return employeeMapper.getById(id);
	}

}
