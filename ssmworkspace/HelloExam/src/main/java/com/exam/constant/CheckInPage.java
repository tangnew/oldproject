package com.hotel.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 23, 2016 
 * Time: 3:59:36 PM
 * 
 * com.hotel.page.CheckInPage
 * 
 * 登记入住信息界面
 * 
 */
public class CheckInPage extends JPanel {

	private MainPage mainPage;

	public CheckInPage(MainPage mainPage) {
		this.mainPage = mainPage;
		initComponents();
	}

	private void initComponents(){
		JPanel p = new JPanel(new FlowLayout());
		p.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton b1 = new JButton("one");
		JButton b2 = new JButton("two");
		JButton b3 = new JButton("three");

	
		p.add(b3);

		JPanel p1 = new JPanel();
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		add(p);
		add(p1,BorderLayout.WEST);
	}
}
