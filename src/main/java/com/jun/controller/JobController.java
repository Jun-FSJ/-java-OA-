package com.jun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pageutil.Page;
import com.jun.pojo.Dept;
import com.jun.pojo.Job;
import com.jun.service.JobService;

@Controller
public class JobController {
	@Resource
	private JobService jobServiceImpl;
	/**
	 * 分页显示查询职位
	 * @param pageIndex
	 * @param loginname
	 * @param username
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping("job/selectJob")
    public String deptListPost(@RequestParam(value = "pageIndex", defaultValue = "1") String pageIndex, String name,HttpServletRequest request) {
        Job job = new Job();
        job.setName(name);
        EasyUIGrid page = jobServiceImpl.selAllPage(Integer.valueOf(pageIndex), job);

        Page pageModel = new Page();
        pageModel.setPageIndex(Integer.valueOf(pageIndex));
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());

        request.setAttribute("joblist", page.getRows());
        request.setAttribute("pageModel", pageModel);
        return "job/joblist";
    }
	/**
	 * 添加部门
	 * @param flag
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("jobaddsave.action")
	public String jobAdd(Integer flag,Job job) throws Exception {
		int index = jobServiceImpl.insJob(job);
		System.out.println(flag);
		if (index > 0 ) {
			return "job/joblist";
		}else {
			throw new Exception("添加失败");
		}
	}
	/**
	 * 删除部门
	 * @param deptId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobdel.action")
	public String delJob(Integer jobId) throws Exception {
		int index = jobServiceImpl.delJob(jobId);
		if (index > 0 ) {
			return "job/joblist";
		}else {
			throw new Exception("删除失败");
		}
	}
	/**
	 * 修改部门通过id
	 * @param dept
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("jobedit.action")
	public String updDept(Job job) throws Exception {
		System.out.println(job.getName()+"..."+job.getRemark());
		int index = jobServiceImpl.updJob(job);
		if (index > 0) {
			return "job/joblist";
		}else {
			throw new Exception("修改失败");
		}
	}
}
