package com.jun.service;

import java.util.List;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.User;

public interface UserService {
	/**
	 * 用户登陆
	 * @param loginname
	 * @param password
	 * @return
	 */
	User login(String loginname,String password);
	/**
	 * 查询全部
	 * @return
	 */
	List<User> selAll();
	/**
	 * 根据用户id查找用户信息
	 * @param id
	 * @return
	 */
	User selById(Integer id);
	/**
	 * 具体的用户查询
	 * @param loginname
	 * @param username
	 * @param status
	 * @return
	 */
	List<User> selByTwoName(String loginname,String username,Integer status);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int insUser(User user);
	/**
	 * 删除用户
	 * @param list
	 * @return
	 */
	int delUserById(List<Integer> userIds);
	/**
	 * 根据用户id修改用户
	 * @param id
	 * @return
	 */
	int updUserById(User user);
	/**
	 * 分页查询全部
	 * @param page
	 * @param user
	 * @return
	 */
	EasyUIGrid selAllPage(Integer page,User user);
}
