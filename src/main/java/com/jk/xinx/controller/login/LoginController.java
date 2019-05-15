package com.jk.xinx.controller.login;

import com.jk.xinx.pojo.user.UserBean;
import com.jk.xinx.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String,Object> login(UserBean userBean){
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (!StringUtil.isNotEmpty(userBean.getUsername()) || !StringUtil.isNotEmpty(userBean.getPassword())){
            map.put("code","1");
            map.put("msg","用户名或密码不能为空");
            return map;
        }
        String account=userBean.getUsername();
        String password=userBean.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
            //此步将 调用realm的认证方法
            map.put("code",0);
            map.put("msg","登录成功");
            return map;
        }catch (UnknownAccountException e){
            map.put("code",2);
            map.put("msg","用户名不存在");
            return map;

        }catch(IncorrectCredentialsException e){
            //这最好把 所有的 异常类型都背会
            map.put("code",3);
            map.put("msg","密码错误");
            return map;
        }
    }


    @RequestMapping("/logout")
    public String logout(){
        return "login";
    }
}
