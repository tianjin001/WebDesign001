package com.ginger.service.impl;

import com.ginger.mapper.UserMapper;
import com.ginger.pojo.User;
import com.ginger.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user){
         return userMapper.select(user.getUsername(), user.getPassword());
    }

    @Override
    public User selectByUsername(User user) {
        return userMapper.selectByCondition(user.getUsername());
    }

    @Override
    public void register(User user) {
        userMapper.add(user);
    }


}
