package com.jk.xinx.controller.car;

import java.util.List;


import javax.servlet.http.HttpServletRequest;


import com.jk.xinx.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



import com.jk.xinx.pojo.car.AreaBean;
import com.jk.xinx.pojo.car.Car;
import com.jk.xinx.pojo.car.CarType;
import com.jk.xinx.pojo.car.ColorTable;
import com.jk.xinx.pojo.car.PowerMenu;
import com.jk.xinx.pojo.car.RoleBean;

import com.jk.xinx.pojo.tree.TreeBean;


import com.jk.xinx.util.FileUtil;
import com.jk.xinx.util.ResultUtil;



@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping("queryByPage")
	@ResponseBody
	public ResultUtil queryByPage(Integer page,Integer rows,Car car) {

		return carService.queryByPage(page,rows,car);

	}
	@RequestMapping("queryCarTypeList")
	@ResponseBody
	public List<CarType> queryCarTypeList(){
		return carService.queryCarTypeList();
	}

	@RequestMapping("deleteManyId")
	@ResponseBody
	public Boolean deleteManyId(Integer[] ids) {
		try {
			carService.deleteManyId(ids);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}



	}

	@RequestMapping("queryCarColorList")
	@ResponseBody
	public List<ColorTable> queryCarColorList(){
		return carService.queryCarColorList();
	}

	@RequestMapping("queryCarType")
	@ResponseBody
	public List<CarType> queryCarType(){
		return carService.queryCarType();
	}

	@RequestMapping("saveCar")
	@ResponseBody
	public Boolean saveCar(Car car) {

        try {
        	if(car.getCid()!=null) {
        		carService.updateCar(car);
        	}else{
        		carService.saveCar(car);

			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

		@RequestMapping("upload")
		@ResponseBody
		public String updlaod(MultipartFile img,HttpServletRequest request) throws Exception, Exception {
			String fileUpload = FileUtil.uploadFile(img, request);
			return fileUpload;
		}

		@RequestMapping("findCarById")
		@ResponseBody
		public Car findCarById(Integer id) {
			return carService.findCarById(id);
		}

		@RequestMapping("TopOrDown")
		@ResponseBody
		public void TopOrDown(Integer id) {
			carService.TopOrDown(id);
		}

		@RequestMapping("TopOrDowntwo")
		@ResponseBody
		public void TopOrDowntwo(Integer id) {
			carService.TopOrDowntwo(id);
		}

		@RequestMapping("findRoleList")
		@ResponseBody
		public List<RoleBean> findRoleList(){
			return carService.carService();

		}

		@RequestMapping("findprovince")
		@ResponseBody
		public List<AreaBean> findprovince(Integer id){
			return carService.findprovince(id);

		}

		@RequestMapping("findPasswordById")
		@ResponseBody
		public void findPasswordById(Integer id,String passwords,Car car) {
			 carService.findPasswordById(id,passwords,car);
		}

		@RequestMapping("findRolePowerTree")
		@ResponseBody
		public List<TreeBean> findRolePowerTree(Integer id){
			return carService.findRolePowerTree(id);

		}

		@RequestMapping("saveRolePower")
		@ResponseBody
		public Boolean saveRolePower(Integer roleid,Integer[] powerids) {
			try {
				carService.saverRolePower(roleid,powerids);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@RequestMapping("saveRole")
		@ResponseBody
		public Boolean saveRole(RoleBean rolebean) {
			try {
	        	if(rolebean.getId()!=null) {
	        		carService.updateRole(rolebean);

	        	}else{
	        		carService.saveRole(rolebean);

				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}


		@RequestMapping("deleteRoleId")
		@ResponseBody
		public Boolean deleteRoleId(Integer[] ids) {
			try {
				carService.deleteRoleId(ids);

				return true;

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}



		}


		@RequestMapping("findRoleById")
		@ResponseBody
		public RoleBean findRoleById(Integer id) {
			return carService.findRoleById(id);

		}

		@RequestMapping("delPowerTree")
		@ResponseBody
		public Boolean delPowerTree(Integer id) {
			try {
				carService.delPowerTree(id);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@RequestMapping("findTreeById")
		@ResponseBody
		public TreeBean findTreeById(Integer id) {
			return carService.findTreeById(id);

		}

		@RequestMapping("saveTree")
		@ResponseBody
		public TreeBean saveTree(TreeBean tree) {
			return carService.saveTree(tree);

		}

		@RequestMapping("updateTree")
		@ResponseBody
		public TreeBean updateTree(TreeBean tree) {
			return carService.updateTree(tree);
		}

		@RequestMapping(value="findPowerMenuList",method=RequestMethod.POST)
		@ResponseBody
		public List<PowerMenu> findPowerMenuList(Integer powerid){
			return carService.findPowerMenuList(powerid);
		}


		@RequestMapping("deleteMenuId")
		@ResponseBody
		public Boolean deleteMenuId(Integer[] ids) {
			try {
				carService.deleteMenuId(ids);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@RequestMapping("queryMenuById")
		@ResponseBody
		public PowerMenu queryMenuById(Integer id) {
			return carService.queryMenuById(id);

		}

		@RequestMapping("saveMenu")
		@ResponseBody
		public Boolean updateMenu(PowerMenu powermenu) {
			try {
	        	if(powermenu.getId()!=null) {
	        		carService.updateMenu(powermenu);
	        	}else{
	        		carService.saveMenu(powermenu);
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}


		}




		@RequestMapping("deleteManyLogId")
		@ResponseBody
		public Boolean deleteManyLogId(String[] ids) {
			try {
				carService.deleteManyLogId(ids);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}








}
