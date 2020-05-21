package com.jun.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pageutil.Page;
import com.jun.pojo.Dept;
import com.jun.pojo.Employee;
import com.jun.pojo.EmployeeDto;
import com.jun.pojo.Job;
import com.jun.pojo.NewEmployee;
import com.jun.pojo.User;
import com.jun.service.DeptService;
import com.jun.service.EmployeeService;
import com.jun.service.JobService;

@Controller
public class EmployeeController {
	@Resource
	private EmployeeService employeeServiceImpl;
	@Resource
	private DeptService deptServiceImpl;
	@Resource
	private JobService jobServiceImpl;
	/**
	 * 分页显示查询用户
	 * @param pageIndex
	 * @param loginname
	 * @param username
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "employeelist.action")
    public String userListPost(@RequestParam(value = "pageIndex", defaultValue = "1") String pageIndex,HttpServletRequest request,EmployeeDto employeeDto) {
		
		List<Dept> deptList = deptServiceImpl.getAll();
		List<Job> jobList = jobServiceImpl.getAll();
        EasyUIGrid page = employeeServiceImpl.selAllPage(Integer.valueOf(pageIndex),employeeDto);
        Page pageModel = new Page();
        pageModel.setPageIndex(Integer.valueOf(pageIndex));
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());
        List<Employee> rows = (List<Employee>) page.getRows();
        List<NewEmployee> employeeList = new ArrayList<>();
        for (Employee employee2 : rows) {
        	NewEmployee newEmployee = new NewEmployee();
        	BeanUtils.copyProperties(employee2, newEmployee);
        	Job job = jobServiceImpl.getAllById(employee2.getJob_id());
        	Dept dept = deptServiceImpl.getAllById(employee2.getDept_id());
        	newEmployee.setDept(dept);
        	newEmployee.setJob(job);
        	employeeList.add(newEmployee);
		}
        request.setAttribute("deptList", deptList);
        request.setAttribute("jobList",jobList);
        request.setAttribute("employeelist", employeeList);
        request.setAttribute("pageModel", pageModel);
        return "employee/employeelist";
    }
	/**
	 * 展示添加页面
	 * @param request
	 * @return
	 */
	@RequestMapping("employeeadd.action")
	public String showAddEmployee(HttpServletRequest request) {
		List<Dept> deptList = deptServiceImpl.getAll();
		List<Job> jobList = jobServiceImpl.getAll();
		request.setAttribute("deptList", deptList);
        request.setAttribute("jobList",jobList);
		return "employee/employeeadd";
	}
	/**
	 * 添加
	 * @param employee
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("employee/addEmployee")
	public String addEmployee(Employee employee,BindingResult bindingResult) {
		employee.setCreate_date(new Date());
		employeeServiceImpl.insEmployee(employee);
		return "employee/employeelist";
	}
	/**
	 * 删除
	 * @param employeeId
	 * @return
	 */
	@RequestMapping("employeedel.action")
	public String delEmployee(@RequestParam("employeeId") List<Integer> employeeId) {
		employeeServiceImpl.delById(employeeId);
		return "employee/employeelist";
	}
	/**
	 * 展示修改
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("employee/updateEmployee")
    public String showEdit(Integer id, Model model) {
        // 查询出所有的职位和部门
        List<Dept> deptList = deptServiceImpl.getAll();
        List<Job> jobList = jobServiceImpl.getAll();


        Employee employeeInf = employeeServiceImpl.findById(id);
        model.addAttribute("employee", employeeInf);
        model.addAttribute("deptList", deptList);
        model.addAttribute("jobList", jobList);
        return "employee/employeeedit";
    }
	/**
	 * 修改
	 * @param employeeInf
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/employee/editEmployee")
    public String edit(Employee employeeInf, BindingResult bindingResult) {
        employeeServiceImpl.updById(employeeInf);
        return "employee/employeeedit";
    }
}
