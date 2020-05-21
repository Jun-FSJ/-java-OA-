package com.jun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	/**
	 * 用户登陆界面
	 * @return
	 */
	@RequestMapping("login")
	public String showlogin() {
		return "loginForm";
	}
	/**
	 * 显示添加用户页面
	 * @return
	 */
	@RequestMapping("useradd.action")
	public String showUserAdd() {
		return "user/useradd";
	}
	/**
	 * 显示添加部门页面
	 * @return
	 */
	@RequestMapping("dept/addDept")
	public String showDeptAdd() {
		return "dept/deptadd";
	}
	@RequestMapping("job/addJob")
	public String showJobAdd() {
		return "job/jobadd";
	}
	/**
	 * 展示修改用户页面
	 * @param id
	 * @return
	 */
	@RequestMapping("viewUser.action")
	public String showUpdUser(Integer id,Model model) {
		model.addAttribute("id", id);
		return "user/useredit";
	}
	/**
	 * 展示修改部门页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("viewDept.action")
	public String showUpdDept(Integer id,Model model) {
		model.addAttribute("id",id);
		return "dept/deptedit";
	}
	/**
	 * 展示修改职位页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("viewJob.action")
	public String showUpdJob(Integer id,Model model) {
		model.addAttribute("id",id);
		return "job/jobedit";
	}
	/**
	 * 显示后台管理页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= {"main.action","top.action","left.action","right.action"})
	public String Main(HttpServletRequest request,String loginname,String password) throws Exception {
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/")+1, uri.length());
		if(action != null && !"".equals(action)) {
			//不同的action显示不同的页面 char/byte/short/int(包括它们4个包装类型)/String/enum
			if(action.equals("main.action")) {
				return "main";
			}else if(action.equals("top.action")) {
				return "top";
			}else if(action.equals("left.action")) {
				return "left";
			}else {
				return "right";
			}
		}else {
			throw new Exception("报错");
		}
		
	}
}
