package com.jk.xinx.service.tree;

import com.jk.xinx.mapper.tree.TreeMapper;
import com.jk.xinx.pojo.tree.TreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService{

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<TreeBean> findWestTreeList(Integer userId) {
        return treeMapper.findWestTreeList(userId);
    }
}
