package com.jun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jun.mapper.DocumentMapper;
import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.Dept;
import com.jun.pojo.Document;
import com.jun.pojo.Employee;
import com.jun.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Resource
	private DocumentMapper documentMapper;
	@Override
	public EasyUIGrid selAll(Integer page,Document document) {
		PageHelper.startPage(page, 2);
		if (StringUtils.isBlank(document.getTitle())) {
			document.setTitle(null);
		}
		List<Document> documentlist = documentMapper.selAllByPage(document.getTitle());
		PageInfo<Document> pageInfo = new PageInfo<>(documentlist);
		EasyUIGrid easyUIGrid = new EasyUIGrid();
		
		easyUIGrid.setTotal(pageInfo.getTotal());
		easyUIGrid.setRows(pageInfo.getList());
		return easyUIGrid;
	}

}
