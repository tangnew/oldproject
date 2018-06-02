package chen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Game extends JFrame {
	JMenuBar gameBar = new JMenuBar();
	JMenu gameMenu = new JMenu("游戏");
	JMenuItem newGame = new JMenuItem("新游戏");
	JMenuItem exit = new JMenuItem("退出");

	JMenu windowStyleMenu = new JMenu("窗体");
	JMenuItem windowsRadio = new JMenuItem("windows");

	JMenu information = new JMenu("关于");
	JMenuItem author = new JMenuItem("作者：Chen");

	public Game() {
		/* 以下把文件菜单项加入到gameMenu菜单中 */
		gameMenu.add(newGame);
		gameMenu.add(exit);
		/* 以下把风格菜单项加入到windowStyleMenu菜单中 */
		windowStyleMenu.add(windowsRadio);
		/* 以下把信息菜单项加入到information菜单中 */
		information.add(author);
		/* 以下把所有菜单加入到菜单栏中 */
		gameBar.add(gameMenu);
		gameBar.add(windowStyleMenu);
		gameBar.add(information);
		this.setJMenuBar(gameBar);// 将菜单栏加入框架窗口

		// 修改 2016-12-28 add-s
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				KnightTour application = new KnightTour();
				application.init();
				application.tour(0, 0);
				getContentPane().removeAll();
				getContentPane().add(application, BorderLayout.CENTER);
				getContentPane().repaint();
				getContentPane().validate();
			}
		});
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// 修改 2016-12-28 add-e

		this.setLayout(new BorderLayout());
		this.setTitle("骑士游历游戏");
		this.setSize(335, 450);
		// this.setResizable(false);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Game();
	}
}
