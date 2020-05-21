package com.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jun.pojo.Dept;
import com.jun.pojo.Employee;
import com.jun.pojo.Job;
import com.jun.pojo.User;

public interface EmployeeMapper {
	/**
	 * 分页查询员工数据
	 * @param loginname
	 * @param username
	 * @param status
	 * @return
	 */
	
	 @Select({
         "<script>" ,
         "            select * from employee_inf" ,
         "            where 1=1" ,
         "            <if test=\"name != null\">" ,
         "                and name like concat('%','${name}','%') " ,
         "            </if>" ,
         "            <if test=\"job_id != 0 and job_id != null \" >" ,
         "                and job_id = #{job_id}" ,
         "            </if>" ,
         "            <if test=\"dept_id != 0  and dept_id != null\" >" ,
         "                and dept_id = #{dept_id}" ,
         "            </if>" ,
         "            <if test=\"card_id != null\" >" ,
         "                and card_id = #{card_id}" ,
         "            </if>" ,
         "            <if test=\"sex != 0 and sex != null\" >" ,
         "                and sex = #{sex}" ,
         "            </if>" ,
         "            <if test=\"phone != null\" >" ,
         "                and phone = #{phone}" ,
         "            </if>" ,
         "    </script>"
 })
	 List<Employee> selAllPage(Employee employeeInf);
	 
	@Select("select * from employee_inf where card_id = #{card_id}")
	Employee getByCardId(@Param("card_id") String card_id);

	@Insert("insert into employee_inf (name, card_id, sex, job_id, education, email, phone, tel, party,qq_num, address, post_code, birthday,race, speciality, hobby, remark, dept_id) values (#{name}, #{card_id}, #{sex}, #{job_id}, #{education}, #{email}, #{phone}, #{tel}, #{party}, #{qq_num}, #{address}, #{post_code}, #{birthday}, #{race}, #{speciality}, #{hobby}, #{remark}, #{dept_id})")
	void insert(Employee employeeInf);

	@Select("select * from employee_inf where id = #{id}")
	Employee getById(@Param("id") Integer id);

	@Update("update employee_inf set name = #{name}, card_id = #{card_id}, sex = #{sex}, job_id = #{job_id}, education = #{education}, email = #{email}, phone = #{phone}, tel = #{tel}, party = #{party}, qq_num = #{qq_num}, address = #{address}, post_code = #{post_code}, birthday = #{birthday}, race = #{race}, speciality = #{speciality}, hobby = #{hobby}, remark = #{remark}, dept_id = #{dept_id} where id = #{id}")
	void updateEm(Employee employeeInf);

	@Delete("delete from employee_inf where id = #{employeeId}")
	void delete(Integer employeeId);
}
