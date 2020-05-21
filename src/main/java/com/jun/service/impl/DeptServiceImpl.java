package com.jun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jun.mapper.DeptMapper;
import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.Dept;
import com.jun.pojo.User;
import com.jun.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Resource
	private DeptMapper deptMapper;
	@Override
	public EasyUIGrid selAllPage(Integer page, Dept dept) {
		PageHelper.startPage(page, 2);
		if (StringUtils.isBlank(dept.getName())) {
			dept.setName(null);
		}
		List<Dept> list = deptMapper.selAllByPage(dept.getName());
		PageInfo<Dept> pageInfo = new PageInfo<>(list);
		EasyUIGrid easyUIGrid = new EasyUIGrid();
		
		easyUIGrid.setTotal(pageInfo.getTotal());
		easyUIGrid.setRows(pageInfo.getList());
		return easyUIGrid;
	}
	@Override
	public int insDept(Dept dept) {
		return deptMapper.insDept(dept);
	}
	@Override
	public int delDept(Integer id) {
		return deptMapper.deptDel(id);
	}
	@Override
	public int updDept(Dept dept) {
		return deptMapper.updDept(dept);
	}
	@Override
	public List<Dept> getAll() {
		return deptMapper.selAll();
	}
	@Override
	public Dept getAllById(Integer id) {
		return deptMapper.selDeptById(id);
	}

}
