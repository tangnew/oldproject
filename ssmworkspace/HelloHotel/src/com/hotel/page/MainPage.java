package com.hotel.page;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.hotel.service.ClientHouseService;
import com.hotel.service.HouseTypeService;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 2:34:02 PM
 *
 * com.hotel.page.MainFrame
 */
public class MainPage extends JFrame {
	
	private static final long serialVersionUID = -8458938667629225331L;
	
	private JMenuBar menuBar = new JMenuBar();
	private JLabel mainLabel = new JLabel("欢迎来到JW酒店!!!");
	private JPanel centerPanel = new JPanel(new BorderLayout());
	private CheckInPage checkInPage = null;
	private InHousePage inHousePage = null;
	private HouseTypePage houseTypePage = null;
	private HouseListPage houseListPage = null;

	private MainPage() {
		//初始化服务
		initService();
		
		initComponents();
	}

	private void initComponents() {
		//初始化菜单
		initMenus();
		
		//初始化主界面
		initMainPage();
	}

	private void initService(){
		ClientHouseService.loadService();
		HouseTypeService.loadService();
	}
	/**
	 * 初始化菜单
	 */
	private void initMenus() {
		// 客户信息菜单 -s
		JMenu clientMenu = new JMenu("客户信息");
		JMenuItem checkInItem = new JMenuItem("登记入住");
		JMenuItem inHouseItem = new JMenuItem("入住情况");
		clientMenu.add(checkInItem);
		clientMenu.addSeparator();// 添加子菜单之间的分隔符
		clientMenu.add(inHouseItem);
		checkInItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeCenterPanelPage(checkInPage);
				checkInPage.clearData();
				checkInPage.loadComboxData();
			}
		});
		
		inHouseItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeCenterPanelPage(inHousePage);
			}
		});
		// 客户信息菜单 -e

		// 房间信息菜单 -s
		JMenu houseMenu = new JMenu("房间信息");
		JMenuItem houseTypeItem = new JMenuItem("房间类型");
		JMenuItem houseListItem = new JMenuItem("房间基本信息");
		houseMenu.add(houseTypeItem);
		houseMenu.addSeparator();
		houseMenu.add(houseListItem);
		houseTypeItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeCenterPanelPage(houseTypePage);
				houseTypePage.clearData();
			}
		});
		
		houseListItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeCenterPanelPage(houseListPage);
				houseListPage.loadComboxData();
				JOptionPane.showMessageDialog(null,
						"房间基本信息功能正在开发,请稍后关注..." , "提示",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// 房间信息菜单 -e

		// 退出菜单 -s
		JMenu exitMenu = new JMenu("主页");
		JMenuItem mainPageItem = new JMenuItem("主页面");
		JMenuItem exitItem = new JMenuItem("退出");
		mainPageItem.addActionListener(new ActionListener() {// 系统退出事件
			@Override
			public void actionPerformed(ActionEvent e) {
				homePage();
			}
		});
		
		exitItem.addActionListener(new ActionListener() {// 系统退出事件
			@Override
			public void actionPerformed(ActionEvent e) {
				int ok = JOptionPane.showConfirmDialog(null, "确定退出系统?", "退出系统",
						JOptionPane.YES_NO_OPTION);
				if (ok == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		exitMenu.add(mainPageItem);
		exitMenu.addSeparator();
		exitMenu.add(exitItem);
		// 退出菜单 -e

		// 帮助菜单 -s
		JMenu helpMenu = new JMenu("帮助");
		JMenuItem helpItem = new JMenuItem("帮助");
		JMenuItem versionItem = new JMenuItem("版本");
		helpMenu.add(helpItem);
		exitMenu.addSeparator();
		helpMenu.add(versionItem);
		
		helpItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"JW帮助文档正在维护中,请稍后关注..." , "帮助",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		versionItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"JW-0.5" , "版本信息",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		// 帮助菜单 -e

		//将菜单添加到菜单栏  -s
		menuBar.add(clientMenu);
		menuBar.add(houseMenu);
		menuBar.add(exitMenu);
		menuBar.add(helpMenu);
		//将菜单添加到菜单栏  -e
		
		//将菜单栏添加到主界面中  -s
		setJMenuBar(menuBar);
		//将菜单栏添加到主界面中  -e
	}

	/**
	 * 初始化主界面
	 */
	private void initMainPage() {
		setTitle("JW酒店管理");
		setSize(768, 520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		checkInPage = new CheckInPage();
		inHousePage = new InHousePage();
		houseTypePage = new HouseTypePage();
		houseListPage = new HouseListPage();
		
		setLayout(new BorderLayout());
		homePage();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
	}
	
	private void homePage(){
		centerPanel.removeAll();
		centerPanel.setLayout(new FlowLayout());
		centerPanel.add(mainLabel);
		centerPanel.repaint();
		centerPanel.revalidate();
	}
	
	private void changeCenterPanelPage(Component page){
		centerPanel.removeAll();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(page, BorderLayout.CENTER);
		centerPanel.repaint();
		centerPanel.revalidate();
	}
	
	public static void main(String[] args) {
		MainPage mainPage = new MainPage();
		mainPage.setVisible(true);
	}
}
