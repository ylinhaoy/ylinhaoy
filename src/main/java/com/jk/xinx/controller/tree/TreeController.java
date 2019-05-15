package com.jk.xinx.controller.tree;

import com.jk.xinx.pojo.tree.TreeBean;
import com.jk.xinx.service.tree.TreeService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("/findWestTreeList")
    @ResponseBody
    public List<TreeBean> findWestTreeList(){
        Integer userId = (Integer) SecurityUtils.getSubject().getPrincipal();
        System.out.println(userId);
        return treeService.findWestTreeList(userId);
    }
}
