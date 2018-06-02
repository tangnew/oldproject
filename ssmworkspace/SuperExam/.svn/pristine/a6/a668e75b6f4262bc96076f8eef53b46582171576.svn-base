package com.exam.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.dao.MenuMapper;
import com.exam.entity.Menu;
import com.exam.service.MenuService;
import com.exam.utils.UuidUtil;
import com.exam.vo.PageItem;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 14, 2016 
 * Time: 4:19:49 PM
 *
 * com.exam.service.impl.MenuServiceImpl
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Resource(name = "menuMapper")
	private MenuMapper menuMapper;

	@Override
	public Menu createMenu(Menu menu) {
		Date now = new Date();
		menu.setId(UuidUtil.getUUID());
		menu.setCreatedTime(now);
		menu.setUpdatedTime(now);

		menuMapper.insertMenu(menu);

		return menu;
	}

	@Override
	public List<Menu> getAllMenus() {
		List<Menu> menus = menuMapper.selectAllMenus();
		return menus;
	}

	@Override
	public Menu updateMenu(Menu menu) {
		menu.setUpdatedTime(new Date());

		menuMapper.updateMenuByMenu(menu);

		menu = menuMapper.selectMenuById(menu.getId());

		return menu;
	}

	@Override
	public void deleteByMenuId(String menuId) {
		menuMapper.deleteMenuById(menuId);
	}

	@Override
	public PageItem getMenuByPage(PageItem pageItem) {
		int counts = menuMapper.selectMenuCount();
		List<Menu> menus = menuMapper.selectMenuByPage(pageItem);
		pageItem.setCounts(counts);
		pageItem.setItems(menus);
		return pageItem;
	}

}
