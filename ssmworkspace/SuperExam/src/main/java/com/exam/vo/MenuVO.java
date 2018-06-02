package com.exam.vo;

import java.util.ArrayList;
import java.util.List;

import com.exam.entity.Menu;

/**
 * Created by JW. 
 * User: JW 
 * Date: Nov 7, 2016 
 * Time: 11:11:45 AM
 *
 * com.exam.vo.Menu
 */
public class MenuVO extends Menu {
	
	public static List<MenuVO> getSuperUserMeuns() {
		List<MenuVO> list = new ArrayList<MenuVO>();
		MenuVO classMenu = new MenuVO();
		classMenu.setModuleName("class");
		classMenu.setMenuName("班级管理");
		classMenu.setSeq(1);

		MenuVO menuMenu = new MenuVO();
		menuMenu.setModuleName("menu");
		menuMenu.setMenuName("菜单管理");
		menuMenu.setSeq(2);
		
		MenuVO questionMenu = new MenuVO();
		questionMenu.setModuleName("question");
		questionMenu.setMenuName("问题管理");
		questionMenu.setSeq(3);
		
		list.add(classMenu);
		list.add(menuMenu);
		list.add(questionMenu);
		
		return list;
	}
}
