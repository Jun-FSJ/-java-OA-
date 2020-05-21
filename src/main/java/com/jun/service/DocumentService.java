package com.jun.service;

import java.util.List;

import com.jun.pageutil.EasyUIGrid;
import com.jun.pojo.Document;

public interface DocumentService {
	EasyUIGrid selAll(Integer page,Document document);
}
