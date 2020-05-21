package com.jun.service.impl;

import java.util.Date;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.jun.mapper.UserMapper;
import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.User;
import com.jun.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMappler;
	@Override
	public User login(String loginname, String password) {
		return userMappler.selByNameAndPwd(loginname, password);
	}
	@Override
	public List<User> selAll() {
		return userMappler.selAll();
	}
	@Override
	public List<User> selByTwoName(String loginname,String username,Integer status) {
		return userMappler.selByTwoName(loginname,username,status);
	}
	@Override
	public int insUser(User user) {
		return userMappler.insUser(user);
	}
	@Override
	public int delUserById(List<Integer> userIds) {
		int index = 0;
		for (Integer id : userIds) {
			index += userMappler.delUserByIds(id);
		}
		return index;
	}
	@Override
	public int updUserById(User user) {
		user.setCreatedate(new Date());
		return userMappler.updUserById(user);
	}
	@Override
	public User selById(Integer id) {
		return userMappler.selById(id);
	}
	@Override
	public EasyUIGrid selAllPage(Integer page, User user) {
		PageHelper.startPage(page, 2);
		if (StringUtils.isBlank(user.getLoginname())) {
			user.setLoginname(null);
		}
		if (StringUtils.isBlank(user.getUsername())) {
			user.setUsername(null);
		}
		if (user.getStatus() == null) {
			user.setStatus(0);
		}
		List<User> list = userMappler.selAllByPage(user.getLoginname(), user.getUsername(), user.getStatus());
		PageInfo<User> pageInfo = new PageInfo<>(list);
		EasyUIGrid easyUIGrid = new EasyUIGrid();
		
		easyUIGrid.setTotal(pageInfo.getTotal());
		easyUIGrid.setRows(pageInfo.getList());
		return easyUIGrid;
	}
}
