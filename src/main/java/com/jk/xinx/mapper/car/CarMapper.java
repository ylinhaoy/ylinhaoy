package com.jk.xinx.mapper.car;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jk.xinx.pojo.car.AreaBean;
import com.jk.xinx.pojo.car.Car;
import com.jk.xinx.pojo.car.CarType;
import com.jk.xinx.pojo.car.ColorTable;
import com.jk.xinx.pojo.car.PowerMenu;
import com.jk.xinx.pojo.car.RoleBean;
import com.jk.xinx.pojo.car.RolePower;
import com.jk.xinx.pojo.car.UserRoleBean;
import com.jk.xinx.pojo.car.Weatherbean;
import com.jk.xinx.pojo.car.kuaidi;
import com.jk.xinx.pojo.tree.TreeBean;

public interface CarMapper {

	

	

	@Select("select * from cartype")
	List<CarType> queryCarTypeList();

	void deleteManyId(Integer[] ids);
    @Select("select * from colortable")
	List<ColorTable> queryCarColorList();
    @Select("select * from cartype")
	List<CarType> queryCarType();
 
    
	void saveCar(Car car);

	int findCarListPageCount(HashMap<String, Object> params);

	List<Car> queryByPage(HashMap<String, Object> params);

	@Select("SELECT GROUP_CONCAT(tro.id) as roleid,c.cid,c.username,c.cnumber,c.password,c.price,c.people,tap.id as provincecode,tac.id as citycode,ct.color as color,cp.typeid as typeid,c.ctime,c.status,c.cimg FROM car c left join colortable ct on c.color = ct.color left join cartype cp on c.typeid = cp.typeid  left join t_area tap on c.provincecode = tap.id  left join t_area tac on c.citycode = tac.id  left join t_user_role tur on c.cid = tur.userid left join t_role tro on tur.roleid = tro.id group by c.cid having c.cid = #{value}")
	Car findCarById(Integer id);

	@Update("update car set username = #{username},cimg = #{cimg},people = #{people},price = #{price},color=#{color},typeid=#{typeid},ctime = #{ctime},status = #{status},provincecode = #{provincecode},citycode=#{citycode} where cid = #{cid}")
	void updateCar(Car car);

	@Update("update car set status = 2 where cid = #{value}")
	void TopOrDown(Integer id);
	@Update("update car set status = 1 where cid = #{value}")
	void TopOrDowntwo(Integer id);

	@Select("select * from t_role")
	List<RoleBean> carService();

	@Select("select * from t_area where pid=#{value}")
	List<AreaBean> findprovince(Integer id);

	void saveUserRole(ArrayList<UserRoleBean> arrayList);

	@Delete("delete from t_user_role where userid = #{value}")
	void deleteRoleById(Integer cid);

	@Select("select cpassword from car where cid = #{value}")
	String findPasswordById(Integer id);

	@Select("select * from tree")
	List<TreeBean> findTreeCommon();

	@Select("select powerid from t_role_power where roleid = #{value}")
	List<RolePower> findRolePower(Integer id);

	@Delete("delete from t_role_power where roleid = #{value}")
	void deleteRolePowerById(Integer roleid);

	
	void saverRolePower(ArrayList<RolePower> rolepowers);

	@Update("update t_role set name = #{name} where id = #{id}")
	void updateRole(RoleBean rolebean);

	@Insert("insert into t_role(name) values(#{name})")
	void saverRole(RoleBean rolebean);
	
	void deleteRoleId(Integer[] ids);

	@Select("select * from t_role where id = #{value}")
	RoleBean findRoleById(Integer id);

	List<TreeBean> findPowerTreeChildren(Integer id);

	void delPowerTree(ArrayList<Integer> childrens);

	@Select("select id,text,url,pid from tree where id = #{value}")
	TreeBean findTreeById(Integer id);

	@Insert("insert into tree(text,url,pid) values(#{text},#{url},#{pid})")
	TreeBean saveTree(TreeBean tree);

	@Update("update tree set text=#{text},url=#{url} where id = #{id}")
	TreeBean updateTree(TreeBean tree);

	@Select("select id,name,path,useing from t_power_menu where powerid = #{value}")
	List<PowerMenu> findPowerMenuList(Integer powerid);

	void deleteMenuId(Integer[] ids);

	@Select("select id,name,path,useing from t_power_menu where id = #{value}")
	PowerMenu queryMenuById(Integer id);

	@Update("update t_power_menu set name = #{name},path=#{path},useing=#{useing} where id = #{id}")
	void updateMenu(PowerMenu powermenu);

	@Insert("insert into t_power_menu(name,path,useing) values(#{name},#{path},#{useing})")
	void saveMenu(PowerMenu powermenu);

	@Select("SELECT name,bianma FROM t_kauidi")
	List<kuaidi> querykuaidiType();

	@Select("select * from t_cityweather")
	List<Weatherbean> querycityweathertype();


	void addCity(Weatherbean weatherbean);

	Car getUserInfoByLoginNumber(Car userBean);


	

	

	

	
}
