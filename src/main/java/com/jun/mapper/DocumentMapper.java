package com.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jun.pojo.Dept;
import com.jun.pojo.Document;

public interface DocumentMapper {
	/**
	 * 分页查询文档
	 * @param loginname
	 * @param username
	 * @param status
	 * @return
	 */
	@Select({
        "<script>" ,
        "            select * from document_inf" ,
        "            where 1 = 1" ,
        "            <if test=\"title != null and title != '' \">" ,
        "                and title like concat(concat('%',#{title},'%'))" ,
        "            </if>" ,           
        "    </script>"
	})
	List<Document> selAllByPage(@Param("title") String title);
}
