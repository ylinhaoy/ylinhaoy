package com.jk.xinx.service.car;

import com.jk.xinx.mapper.car.CarMapper;
import com.jk.xinx.pojo.car.*;
import com.jk.xinx.pojo.tree.TreeBean;
import com.jk.xinx.util.PageModel;
import com.jk.xinx.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class CarServiceImpl  implements  CarService{

    @Autowired
    private CarMapper carMapper;

    @Override
    public ResultUtil queryByPage(Integer page, Integer rows, Car car) {
        ResultUtil resultUtil = new ResultUtil();
        HashMap<String, Object> params = new HashMap<>();
        params.put("Car", car);
        int count = carMapper.findCarListPageCount(params);
        resultUtil.setTotal(count);
        PageModel pageModel = new PageModel(count, page, rows);
        params.put("start", pageModel.getFirstResultCount());
        params.put("count", pageModel.getPageCount());
        List<Car> cars =  carMapper.queryByPage(params);
        resultUtil.setRows(cars);
        return resultUtil;
    }

    @Override
    public List<CarType> queryCarTypeList() {
        List<CarType> queryCarList = carMapper.queryCarTypeList();
        CarType carType = new CarType(-1, "亲选择");
        queryCarList.add(0, carType);
        return 	queryCarList;
    }

    @Override
    public void deleteManyId(Integer[] ids) {
        carMapper.deleteManyId(ids);
    }

    @Override
    public List<ColorTable> queryCarColorList() {
        List<ColorTable> queryCarColorList = carMapper.queryCarColorList();
        return queryCarColorList;
    }

    @Override
    public List<CarType> queryCarType() {
        return carMapper.queryCarType();
    }

    @Override
    public void updateCar(Car car) {
        carMapper.deleteRoleById(car.getCid());
        Integer cid = car.getCid();
        String[] roleArr = car.getRoleid().split(",");
        ArrayList<UserRoleBean> arrayList = new ArrayList<UserRoleBean>();
        for (String roleid : roleArr) {
            UserRoleBean userRoleBean = new UserRoleBean();
            userRoleBean.setUserid(cid);
            userRoleBean.setRoleid(Integer.parseInt(roleid));
            arrayList.add(userRoleBean);
        }
        carMapper.saveUserRole(arrayList);
        carMapper.updateCar(car);
    }

    @Override
    public void saveCar(Car car) {


        carMapper.saveCar(car);
        //将用户的角色取出来保存到用户角色关联表中
        Integer cid = car.getCid();
        String[] roleArr = car.getRoleid().split(",");
        ArrayList<UserRoleBean> arrayList = new ArrayList<UserRoleBean>();
        for (String roleid : roleArr) {
            UserRoleBean userRoleBean = new UserRoleBean();
            userRoleBean.setUserid(cid);
            userRoleBean.setRoleid(Integer.parseInt(roleid));
            arrayList.add(userRoleBean);
        }
        carMapper.saveUserRole(arrayList);
    }

    @Override
    public Car findCarById(Integer id) {
        return carMapper.findCarById(id);
    }

    @Override
    public void TopOrDown(Integer id) {
        carMapper.TopOrDown(id);
    }

    @Override
    public void TopOrDowntwo(Integer id) {
        carMapper.TopOrDowntwo(id);
    }

    @Override
    public List<RoleBean> carService() {
        List<RoleBean> carService = carMapper.carService();
        return carService;
    }

    @Override
    public List<AreaBean> findprovince(Integer id) {
        List<AreaBean> findprovince = carMapper.findprovince(id);
        return findprovince;
    }

    @Override
    public void findPasswordById(Integer id, String passwords, Car car) {

    }

    @Override
    public List<TreeBean> findRolePowerTree(Integer id) {
        List<TreeBean> powerTreeList = carMapper.findTreeCommon();
        List<RolePower> rolepowerList = carMapper.findRolePower(id);
        for (TreeBean tree : powerTreeList) {
            for (RolePower rolePower : rolepowerList) {
                if(tree.getId()==rolePower.getPowerid()) {
                    tree.setChecked(true);
                }
            }
        }
        TreeBean tree = new TreeBean();
        tree.setId(0);
        tree.setText("根节点");
        tree.setPid(-1);
        powerTreeList.add(tree);
        return powerTreeList;
    }

    @Override
    public void saverRolePower(Integer roleid, Integer[] powerids) {
        carMapper.deleteRolePowerById(roleid);

        ArrayList<RolePower> rolepowers = new ArrayList<RolePower>();
        for (int i = 0; i < powerids.length; i++) {
            RolePower rolePower = new RolePower();
            rolePower.setPowerid(powerids[i]);
            rolePower.setRoleid(roleid);
            rolepowers.add(rolePower);
        }
        carMapper.saverRolePower(rolepowers);
    }

    @Override
    public void updateRole(RoleBean rolebean) {
        carMapper.updateRole(rolebean);
    }

    @Override
    public void saveRole(RoleBean rolebean) {
        carMapper.saverRole(rolebean);
    }

    @Override
    public void deleteRoleId(Integer[] ids) {

    }

    @Override
    public RoleBean findRoleById(Integer id) {
        return carMapper.findRoleById(id);
    }

    @Override
    public void delPowerTree(Integer id) {
        //统计所有的子级节点
        ArrayList<Integer> childrens = new ArrayList<>();
        childrens.add(id);
        //递归查询出所有的字节节点
        queryPowerTreeNode(id,childrens);
        //删除节点
        carMapper.delPowerTree(childrens);

    }
    private void queryPowerTreeNode(Integer id,ArrayList<Integer> childrens) {
        List<TreeBean> navs = carMapper.findPowerTreeChildren(id);
        for (TreeBean tree : navs) {
            childrens.add(tree.getId());
            queryPowerTreeNode(tree.getId(),childrens);
        }
    }

    @Override
    public TreeBean findTreeById(Integer id) {
        return carMapper.findTreeById(id);
    }

    @Override
    public TreeBean saveTree(TreeBean tree) {
        return carMapper.saveTree(tree);
    }

    @Override
    public TreeBean updateTree(TreeBean tree) {
        return carMapper.updateTree(tree);
    }

    @Override
    public List<PowerMenu> findPowerMenuList(Integer powerid) {
        return carMapper.findPowerMenuList(powerid);
    }

    @Override
    public void deleteMenuId(Integer[] ids) {
        carMapper.deleteMenuId(ids);
    }

    @Override
    public PowerMenu queryMenuById(Integer id) {
        return carMapper.queryMenuById(id);
    }

    @Override
    public void updateMenu(PowerMenu powermenu) {
        carMapper.updateMenu(powermenu);
    }

    @Override
    public void saveMenu(PowerMenu powermenu) {
        carMapper.saveMenu(powermenu);
    }

    @Override
    public void deleteManyLogId(String[] ids) {

    }
}
