package com.hotel.page;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.hotel.service.HouseService;
import com.hotel.service.ServiceFactory;

/**
 * Created by JW.
 * User: JW 
 * Date: Dec 23, 2016 
 * Time: 2:34:02 PM
 *
 * com.hotel.page.MainFrame
 */
public class MainPage extends JFrame {

    private HouseService houseService = ServiceFactory.getService(ServiceFactory.HOUSE_SERIVCE);

    private JMenuBar menuBar = new JMenuBar();
    private CheckInPage checkInPage = new CheckInPage(this);
    private InHousePage inHousePage = new InHousePage();;

    private MainPage() {
        initComponents();
    }

    private void initComponents() {
        //初始化菜单
        initMenus();

        //初始化主界面
        initMainPage();
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
                 System.out.println("checkInPage .actionPerformed()");
                                getContentPane().removeAll();
                getContentPane().add(checkInPage, BorderLayout.CENTER);
                 getContentPane().repaint();
                getContentPane().validate(); getContentPane().revalidate();
                
            }
        });
        inHouseItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("inHousePage .actionPerformed()");
                getContentPane().removeAll();
                getContentPane().add(inHousePage, BorderLayout.CENTER);
                 getContentPane().repaint();
                   getContentPane().validate();
                   getContentPane().revalidate();
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
        // 房间信息菜单 -e

        // 退出菜单 -s
        JMenu exitMenu = new JMenu("退出");
        JMenuItem exitItem = new JMenuItem("退出");
        exitItem.addActionListener(new ActionListener() {// 系统退出事件
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitMenu.add(exitItem);
        // 退出菜单 -e

        // 帮助菜单 -s
        JMenu helpMenu = new JMenu("帮助");
        JMenuItem helpItem = new JMenuItem("帮助");
        helpMenu.add(helpItem);
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

        setLayout(new BorderLayout());
            
//        getContentPane().add(new InHousePage(), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
        mainPage.setVisible(true);
    }
}
