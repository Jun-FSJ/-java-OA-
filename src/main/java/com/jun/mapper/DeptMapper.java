package com.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jun.pojo.Dept;
import com.jun.pojo.User;

public interface DeptMapper {
	/**
	 * 分页查询部门
	 * @param loginname
	 * @param username
	 * @param status
	 * @return
	 */
	@Select({
        "<script>" ,
        "            select * from dept_inf" ,
        "            where 1 = 1" ,
        "            <if test=\"name != null and name != '' \">" ,
        "                and name like concat(concat('%',#{name},'%'))" ,
        "            </if>" ,           
        "    </script>"
	})
	List<Dept> selAllByPage(@Param("name") String name);
	/**
	 * 添加部门
	 * @return
	 */
	@Insert("insert into dept_inf (name,remark) values(#{name},#{remark})")
	int insDept(Dept dept);
	/**
	 * 删除部门根据id
	 * @param id
	 * @return
	 */
	@Delete("delete from dept_inf where id=#{id}")
	int deptDel(Integer id);
	/**
	 * 修改部门
	 * @param dept
	 * @return
	 */
	@Update("update dept_inf set name=#{name},remark=#{remark} where id=#{id}")
	int updDept(Dept dept);
	
	/**
	 * 查询部门全部信息
	 */
	@Select("select * from dept_inf")
	List<Dept> selAll();
	/**
	 * 获得部门信息通过id
	 */
	@Select("select * from dept_inf where id=#{id}")
	Dept selDeptById(Integer id);
}
