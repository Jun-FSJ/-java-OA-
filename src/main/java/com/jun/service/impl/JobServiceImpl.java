package com.jun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jun.mapper.JobMapper;
import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.Dept;
import com.jun.pojo.Job;
import com.jun.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Resource
	private JobMapper jobMapper;
	@Override
	public EasyUIGrid selAllPage(Integer page, Job job) {
		PageHelper.startPage(page, 2);
		if (StringUtils.isBlank(job.getName())) {
			job.setName(null);
		}
		List<Job> list = jobMapper.selAllByPage(job.getName());
		PageInfo<Job> pageInfo = new PageInfo<>(list);
		EasyUIGrid easyUIGrid = new EasyUIGrid();
		
		easyUIGrid.setTotal(pageInfo.getTotal());
		easyUIGrid.setRows(pageInfo.getList());
		return easyUIGrid;
	}

	@Override
	public int insJob(Job job) {
		return jobMapper.insJob(job);
	}

	@Override
	public int delJob(Integer id) {
		return jobMapper.jobDel(id);
	}

	@Override
	public int updJob(Job job) {
		return jobMapper.updJob(job);
	}

	@Override
	public List<Job> getAll() {
		return jobMapper.selAll();
	}

	@Override
	public Job getAllById(Integer id) {
		return jobMapper.selJobById(id);
	}

}
