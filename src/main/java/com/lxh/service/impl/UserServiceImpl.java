package com.lxh.service.impl;


import com.lxh.dao.UserMapper;
import com.lxh.entity.User;
import com.lxh.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAll();
    }
}
