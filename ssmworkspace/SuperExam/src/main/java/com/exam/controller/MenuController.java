package com.exam.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.entity.Account;
import com.exam.entity.Menu;
import com.exam.service.MenuService;
import com.exam.vo.PageItem;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 7, 2016 
 * Time: 10:45:01 AM
 *
 * com.exam.controller.MenuController
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

	@Resource(name="menuService")
	private MenuService menuService;
	
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	@ResponseBody
	public List<Menu> getMenuByAccount(Account account) {
		return menuService.getAllMenus();
	}
	
	@RequestMapping(value = "/pageMenus", method = RequestMethod.POST)
	@ResponseBody
	public PageItem getMenuByPage(PageItem pageItem){
		pageItem = menuService.getMenuByPage(pageItem);
		return pageItem;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public Menu createByMenu(Menu menu) {
		return menuService.createMenu(menu);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Menu updateByMenu(Menu menu) {
		return menuService.updateMenu(menu);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public void deleteByMenuId(String menuId) {
		 menuService.deleteByMenuId(menuId);
	}
}
