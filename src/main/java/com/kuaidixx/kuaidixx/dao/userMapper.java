package com.kuaidixx.kuaidixx.dao;

import com.kuaidixx.kuaidixx.pojo.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    int insert(user record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated
     */
    List<user> selectAll();
    /*
    判断用户名是否存在
    select count(*) from user where username=xxx
     */
    int findByUsername(@Param("username") String username);
    user findByUsernameAndPassword(@Param("username")String username,@Param("password") String password);
    //判断邮箱是否存在
    int findByPhone(@Param("phone") String phone);
}