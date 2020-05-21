package com.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import com.jun.pojo.User;

public interface UserMapper {
	/**
	 * 登陆
	 * @param loginname
	 * @param password
	 * @return
	 */
	@Select("select * from user_inf where loginname=#{0} and password=#{1}")
	User selByNameAndPwd(String loginname,String password);
	/**
	 * 查询全部
	 * @return
	 */
	@Select("select * from user_inf")
	List<User> selAll();
	/**
	 * 分页查询
	 * @param loginname
	 * @param username
	 * @param status
	 * @return
	 */
	@Select({
        "<script>" ,
        "            select * from user_inf" ,
        "            where 1 = 1" ,
        "            <if test=\"loginname != null and loginname != '' \">" ,
        "                and loginname = #{loginname}" ,
        "            </if>" ,
        "            <if test=\"username != null \">" ,
        "                and username like concat('%','${username}','%') " ,
        "            </if>",
        "            <if test=\"status != 0 \" >" ,
        "                and status = #{status}" ,
        "            </if>" ,
        "    </script>"
	})
	List<User> selAllByPage(@Param("loginname") String loginname, @Param("username") String username, @Param("status") Integer status);
	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return
	 */
	@Select("select * from user_inf where id=#{id}")
	User selById(Integer id);
	
	/**
	 * 具体的用户查询
	 * @param loginname
	 * @param username
	 * @param status
	 * @return
	 */
	@Select("select * from user_inf where loginname=#{0} and username=#{1} and status=#{2}")
	List<User> selByTwoName(String loginname,String username,Integer status);
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@Insert("insert into user_inf (username,status,loginname,password) values(#{username},#{status},#{loginname},#{password})")
	int insUser(User user);
	/**
	 * 删除用户
	 * @param list
	 * @return
	 */
	@Delete("delete from user_inf where id=#{id}")
	int delUserByIds(Integer id);
	/**
	 * 根据用户id修改用户
	 * @param id
	 * @return
	 */
	@Update("update user_inf set username=#{username},status=#{status},loginname=#{loginname},password=#{password} where id=#{id}")
	int updUserById(User user);
}
