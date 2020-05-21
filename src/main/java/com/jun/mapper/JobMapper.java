package com.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jun.pojo.Dept;
import com.jun.pojo.Job;

public interface JobMapper {
	/**
	 * 分页查询部门
	 * @param loginname
	 * @param username
	 * @param status
	 * @return
	 */
	@Select({
        "<script>" ,
        "            select * from job_inf" ,
        "            where 1 = 1" ,
        "            <if test=\"name != null and name != '' \">" ,
        "                and name like concat(concat('%',#{name},'%'))",
        "            </if>" ,           
        "  </script>"
	})
	List<Job> selAllByPage(@Param("name") String name);
	/**
	 * 添加部门
	 * @return
	 */
	@Insert("insert into job_inf (name,remark) values(#{name},#{remark})")
	int insJob(Job job);
	/**
	 * 删除部门根据id
	 * @param id
	 * @return
	 */
	@Delete("delete from job_inf where id=#{id}")
	int jobDel(Integer id);
	@Update("update job_inf set name=#{name},remark=#{remark} where id=#{id}")
	int updJob(Job job);
	
	/**
	 * 查询职位全部信息
	 */
	@Select("select * from job_inf")
	List<Job> selAll();
	/**
	 * 获得职位信息通过id
	 */
	@Select("select * from job_inf where id=#{id}")
	Job selJobById(Integer id);
}
