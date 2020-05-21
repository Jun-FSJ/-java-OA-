package com.jun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pageutil.Page;
import com.jun.pojo.Dept;
import com.jun.pojo.User;
import com.jun.service.DeptService;
@Controller
public class DeptController {
	@Resource
	private DeptService deptServiceImpl;
	/**
	 * 分页显示查询部门
	 * @param pageIndex
	 * @param loginname
	 * @param username
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping("dept/selectDept")
    public String deptListPost(@RequestParam(value = "pageIndex", defaultValue = "1") String pageIndex, String name,HttpServletRequest request) {
        Dept dept = new Dept();
        dept.setName(name);
        EasyUIGrid page = deptServiceImpl.selAllPage(Integer.valueOf(pageIndex), dept);

        Page pageModel = new Page();
        pageModel.setPageIndex(Integer.valueOf(pageIndex));
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());

        request.setAttribute("deptlist", page.getRows());
        request.setAttribute("pageModel", pageModel);
        return "dept/deptlist";
    }
	/**
	 * 添加部门
	 * @param flag
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("deptaddsave.action")
	public String deptAdd(Integer flag,Dept dept) throws Exception {
		int index = deptServiceImpl.insDept(dept);
		System.out.println(flag);
		if (index > 0 ) {
			return "dept/deptlist";
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
	@RequestMapping("deptdel.action")
	public String delDept(Integer deptId) throws Exception {
		int index = deptServiceImpl.delDept(deptId);
		if (index > 0 ) {
			return "dept/deptlist";
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
	@RequestMapping("deptedit.action")
	public String updDept(Dept dept) throws Exception {
		System.out.println(dept.getName()+"..."+dept.getRemark());
		int index = deptServiceImpl.updDept(dept);
		if (index > 0) {
			return "dept/deptlist";
		}else {
			throw new Exception("修改失败");
		}
	}
}
