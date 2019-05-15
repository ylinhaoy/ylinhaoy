package com.jk.xinx.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("toMain")
    public String toMain(){
        return "view/main";
    }
    @RequestMapping("toMain2")
    public String toMain2(){
        return "view/main2";
    }

    @RequestMapping("to403")
    public String to403(){
        return "view/403";
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "/index";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        System.out.println("go to login.html");
        return "/login1";
    }
    @RequestMapping("toBookList")
    public String toBookList(){
        return "view/book";
    }

    @RequestMapping("toRoleList")
    public String toRoleList(){
        return "view/roleList";
    }

    @RequestMapping("/user/add")
    public String toUserAdd(){
        return "/user/add";
    }

    @RequestMapping("/user/edit")
    public String toUserEdit(){
        return "/user/edit";
    }

    @RequestMapping("/self/sl")
    public String toSelfSl(){
        return "/self/sl";
    }
    @RequestMapping("/client/weather")
    public String toClientWeather(){
        return "/client/weather";
    }

    @RequestMapping("/user/list")
    public String toUserList(){
        return "/user/list";
    }

    @RequestMapping("/user/manage")
    public String toUserManage(){
        return "/user/manage";
    }
    @RequestMapping("/log/list")
    public String toLogList(){
        return "/log/list";
    }
    @RequestMapping("/log/myList")
    public String toLogMyList(){
        return "/log/myList";
    }
}
