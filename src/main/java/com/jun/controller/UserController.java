package com.jun.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pageutil.Page;
import com.jun.pojo.Employee;
import com.jun.pojo.User;
import com.jun.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;

	/**
	 * 用户登陆
	 * 
	 * @param request
	 * @param loginname
	 * @param password
	 * @return
	 */
	@RequestMapping(value = { "login.action" })
	public String login(HttpSession session, String loginname, String password) {
		User user = userServiceImpl.login(loginname, password);
		if (user != null) {
			session.setAttribute("user_session", user);
			return "redirect:main.action";
		} else {
			return "loginForm";
		}
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	@RequestMapping("logout.action")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("user");
		Cookie cookie = new Cookie("LOGIN", "");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		return "loginForm";

	}
	/**
	 * 分页显示查询用户
	 * @param pageIndex
	 * @param loginname
	 * @param username
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "userlist.action")
    public String userListPost(@RequestParam(value = "pageIndex", defaultValue = "1") String pageIndex, String loginname, String username, Integer status,
                               HttpServletRequest request) {

        User user = new User();
        user.setLoginname(loginname);
        user.setUsername(username);
        user.setStatus(status);
        EasyUIGrid page = userServiceImpl.selAllPage(Integer.valueOf(pageIndex), user);

        Page pageModel = new Page();
        pageModel.setPageIndex(Integer.valueOf(pageIndex));
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());

        request.setAttribute("userlist", page.getRows());
        request.setAttribute("pageModel", pageModel);
        return "user/userlist";
    }
	
	/**
	 * 添加用户
	 * 
	 * @return
	 */
	@RequestMapping("useraddsave.action")
	public String userAdd(User user) {
		if (user != null) {
			Date date = new Date();
			user.setCreatedate(date);
		}
		int index = userServiceImpl.insUser(user);
		if (index > 0) {
			return "user/useradd";
		} else {
			return "errAdd";
		}
	}

	/**
	 * 根据ids删除用户
	 * 
	 * @param userIds
	 * @return
	 */
	@RequestMapping("userdel.action")
	public String delUser(@RequestParam("userIds") List<Integer> userIds, HttpServletRequest request) {
		int index = userServiceImpl.delUserById(userIds);
		if (index == 0) {
			return "errDel";
		}
		List<User> list = userServiceImpl.selAll();
		request.setAttribute("userlist", list);
		return "user/userlist";
	}

	/**
	 * 根据id修改用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("userupdate.action")
	public String UpdUser(User user) {
		int index = userServiceImpl.updUserById(user);
		if (index > 0) {
			return "user/userlist";
		} else {
			return "errorAdd";
		}
	}
}
