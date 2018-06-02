package chen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	public static final int WHITE = 0; // 用于显示棋盘
	public static final int BIACK = 1;
	public static final int WKNIGHT = 2;// 用于显示骑士
	public static final int BKNIGHT = 3;

	private int chessboard[][];
	private int xrecord[];
	private int yrecord[];
	private int displayCount;
	private int lastxpos, lastypos, nextxpos, nextypos;
	ImageIcon images[];
	private boolean start;

	// public MyPanel() {// MyPanel构造函数
	// initvariance();
	// }

	public MyPanel(int[] newxrecord, int[] newyrecord) {// 重载构造函数
		setLayout(new BorderLayout());
		initvariance();
		initboard(newxrecord, newyrecord);
	}

	public void initvariance() {
		chessboard = new int[8][8];
		xrecord = new int[64];
		yrecord = new int[64];
		images = new ImageIcon[4];

		// 修改 2016-12-28 add-s 路径要修改正确
		ClassLoader cloader = MyPanel.class.getClassLoader();
		String path = "images/";
		images[0] = new ImageIcon(cloader.getResource(path + "white.png"));
		images[1] = new ImageIcon(cloader.getResource(path + "black.png"));
		images[2] = new ImageIcon(cloader.getResource(path + "WKnight.png"));
		images[3] = new ImageIcon(cloader.getResource(path + "BKnight.png"));
		// 修改 2016-12-28 add-e

	}// 给棋盘上色

	public void initboard(int[] newxrecord, int[] newyrecord) {
		start = true;
		displayCount = -1;
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				// 0表示白的，1表示黑的
				chessboard[row][column] = (row + column) % 2;
			}
		}// end of outer for
		for (int row = 0; row < newxrecord.length; row++) {
			xrecord[row] = newxrecord[row];
			yrecord[row] = newyrecord[row];
		}
		displayCount = 0;
		chessboard[xrecord[displayCount]][yrecord[displayCount]] += 2;
	}// end of initboard

	public void showNext() {
		if (displayCount < xrecord.length - 1) {
			displayCount++;
			chessboard[xrecord[displayCount]][yrecord[displayCount]] += 2;
			repaint();
			validate();
		}
	}

	public void paintComponent(Graphics g) {
		// 用于显示运行时态的颜色
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				images[chessboard[row][column]].paintIcon(this, g, 40 * row,
						40 * column);
			}// end of inner for
		}// end of outer for
		if (displayCount > 0) {
			lastxpos = xrecord[displayCount - 1];
			lastypos = yrecord[displayCount - 1];
			nextxpos = xrecord[displayCount];
			nextypos = yrecord[displayCount];
			g.setColor(Color.green);
			g.drawRect(40 * xrecord[displayCount - 1] + 2,
					40 * yrecord[displayCount - 1] + 2, 36, 36);
			g.setColor(Color.green);// 刚走过的步显示为绿色
			g.drawRect(40 * xrecord[displayCount] + 2,
					40 * yrecord[displayCount] + 2, 36, 36);
			g.setColor(Color.blue);// 当前步显示为蓝色
			g.drawRect(40 * Math.min(nextxpos, lastxpos),
					40 * Math.min(nextypos, lastypos),
					(Math.abs(nextxpos - lastxpos) + 1) * 40,
					(Math.abs(nextypos - lastypos) + 1) * 40);
		}// end of it
		g.setColor(Color.red);// 起始位置显示为红色
		g.drawRect(40 * xrecord[0] + 2, 40 * yrecord[0] + 2, 36, 36);
	}// end of the method paintCompoent
}