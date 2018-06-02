package com.exam.service;

import java.util.List;

import com.exam.entity.Menu;
import com.exam.vo.PageItem;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 14, 2016 
 * Time: 4:18:25 PM
 *
 * com.exam.service.MenuService
 */
public interface MenuService {
	public Menu createMenu(Menu menu);

	public List<Menu> getAllMenus();
	
	public Menu updateMenu(Menu menu);
	
	public void deleteByMenuId(String menuId);

	public PageItem getMenuByPage(PageItem pageItem);
}
