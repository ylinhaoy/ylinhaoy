package com.jk.xinx.service.user;

import com.jk.xinx.pojo.user.UserBean;

import java.util.HashSet;

public interface UserService {
    UserBean selectByAccount(String account);

    HashSet<String> findRoleSet(Integer userId);
}
