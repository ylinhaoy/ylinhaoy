package com.jk.xinx.mapper.user;

import com.jk.xinx.pojo.user.UserBean;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public interface UserMapper {
    UserBean selectByAccount(String username);

    HashSet<String> findRoleSet(Integer userId);
}
