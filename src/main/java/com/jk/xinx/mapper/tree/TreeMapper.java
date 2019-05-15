package com.jk.xinx.mapper.tree;

import com.jk.xinx.pojo.tree.TreeBean;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TreeMapper {
    @Select("SELECT " +
            "distinct " +
            "te.*  " +
            "FROM " +
            "tree te " +
            "LEFT JOIN t_role_power trp ON te.id = trp.powerid " +
            "LEFT JOIN t_user_role tur ON trp.roleid = tur.roleid  " +
            "WHERE " +
            "tur.userid = #{value}")
    List<TreeBean> findWestTreeList(Integer userId);
}
