package com.exam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.exam.entity.Menu;
import com.exam.vo.PageItem;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 14, 2016 
 * Time: 4:08:34 PM
 *
 * com.exam.dao.MenuMapper
 */
@Repository("menuMapper")
public interface MenuMapper {
	public void insertMenu(Menu menu);

	public List<Menu> selectAllMenus();

	public void updateMenuByMenu(Menu menu);
	
	public void deleteMenuById(String id);
	
	public Menu selectMenuById(String id);

	public int selectMenuCount();
	
	public List<Menu> selectMenuByPage(PageItem pageItem);
}
