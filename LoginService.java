package com.ginger.service;

import com.ginger.pojo.User;

public interface LoginService {
     User login(User user);

     User selectByUsername(User user);

     void register(User user);


}


