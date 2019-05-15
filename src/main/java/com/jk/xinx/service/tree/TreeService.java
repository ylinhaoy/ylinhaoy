package com.jk.xinx.service.tree;

import com.jk.xinx.pojo.tree.TreeBean;

import java.util.List;

public interface TreeService {
    List<TreeBean> findWestTreeList(Integer userId);
}
