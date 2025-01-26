package com.ginger.mapper;

import com.ginger.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User select(@Param("username")String username, @Param("password")String password);

    User selectByCondition(String username);

    void add(User user);

}
