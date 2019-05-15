package com.jk.xinx.service.car;

import com.jk.xinx.pojo.car.*;
import com.jk.xinx.pojo.tree.TreeBean;
import com.jk.xinx.util.ResultUtil;

import java.util.List;

public interface CarService {
    ResultUtil queryByPage(Integer page, Integer rows, Car car);

    List<CarType> queryCarTypeList();

    void deleteManyId(Integer[] ids);

    List<ColorTable> queryCarColorList();

    List<CarType> queryCarType();

    void updateCar(Car car);

    void saveCar(Car car);

    Car findCarById(Integer id);

    void TopOrDown(Integer id);

    void TopOrDowntwo(Integer id);

    List<RoleBean> carService();

    List<AreaBean> findprovince(Integer id);

    void findPasswordById(Integer id, String passwords, Car car);

    List<TreeBean> findRolePowerTree(Integer id);

    void saverRolePower(Integer roleid, Integer[] powerids);

    void updateRole(RoleBean rolebean);

    void saveRole(RoleBean rolebean);

    void deleteRoleId(Integer[] ids);

    RoleBean findRoleById(Integer id);

    void delPowerTree(Integer id);

    TreeBean findTreeById(Integer id);

    TreeBean saveTree(TreeBean tree);

    TreeBean updateTree(TreeBean tree);

    List<PowerMenu> findPowerMenuList(Integer powerid);

    void deleteMenuId(Integer[] ids);

    PowerMenu queryMenuById(Integer id);

    void updateMenu(PowerMenu powermenu);

    void saveMenu(PowerMenu powermenu);

    void deleteManyLogId(String[] ids);
}
