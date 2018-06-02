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
	JMenu gameMenu = new JMenu("��Ϸ");
	JMenuItem newGame = new JMenuItem("����Ϸ");
	JMenuItem exit = new JMenuItem("�˳�");

	JMenu windowStyleMenu = new JMenu("����");
	JMenuItem windowsRadio = new JMenuItem("windows");

	JMenu information = new JMenu("����");
	JMenuItem author = new JMenuItem("���ߣ�Chen");

	public Game() {
		/* ���°��ļ��˵�����뵽gameMenu�˵��� */
		gameMenu.add(newGame);
		gameMenu.add(exit);
		/* ���°ѷ��˵�����뵽windowStyleMenu�˵��� */
		windowStyleMenu.add(windowsRadio);
		/* ���°���Ϣ�˵�����뵽information�˵��� */
		information.add(author);
		/* ���°����в˵����뵽�˵����� */
		gameBar.add(gameMenu);
		gameBar.add(windowStyleMenu);
		gameBar.add(information);
		this.setJMenuBar(gameBar);// ���˵��������ܴ���

		// �޸� 2016-12-28 add-s
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
		// �޸� 2016-12-28 add-e

		this.setLayout(new BorderLayout());
		this.setTitle("��ʿ������Ϸ");
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
