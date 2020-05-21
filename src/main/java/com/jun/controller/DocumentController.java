package com.jun.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pageutil.Page;
import com.jun.pojo.Dept;
import com.jun.pojo.Document;
import com.jun.pojo.User;
import com.jun.service.DocumentService;
import com.jun.service.UserService;

@Controller
public class DocumentController {
	@Resource
	private DocumentService documentServiceImpl;
	@Resource
	private UserService userServiceImpl;
	/**
	 * 分页显示查询部门
	 * @param pageIndex
	 * @param loginname
	 * @param username
	 * @param status
	 * @param request
	 * @return
	 */
	@RequestMapping("documentlist.action")
    public String deptListPost(@RequestParam(value = "pageIndex", defaultValue = "1") String pageIndex,Document document,HttpServletRequest request) {
		EasyUIGrid page = documentServiceImpl.selAll(Integer.valueOf(pageIndex), document);
        Page pageModel = new Page();
        pageModel.setPageIndex(Integer.valueOf(pageIndex));
        pageModel.setTotalPageSum(page.getTotal() % 2 == 0 ? page.getTotal() / 2 : page.getTotal() / 2 + 1);
        pageModel.setTotalRecordSum(page.getTotal());
        List<Document> list = (List<Document>) page.getRows();
        for (Document document2 : list) {
			User user = userServiceImpl.selById(document2.getUser_id());
			document2.setUser(user);
			document2.setCreateDate(new Date());
		}
        request.setAttribute("documentlist", list);
        request.setAttribute("pageModel", pageModel);
        return "document/documentlist";
    }
	@RequestMapping("documentadd.action")
	public String showAdd() {
		return "document/documentadd";
	}
}
