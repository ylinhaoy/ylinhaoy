package com.jk.xinx.service.user;

import com.jk.xinx.mapper.user.UserMapper;

import com.jk.xinx.pojo.user.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean selectByAccount(String account) {

        return userMapper.selectByAccount(account);
    }

    @Override
    public HashSet<String> findRoleSet(Integer userId) {
        return userMapper.findRoleSet(userId);
    }
}
