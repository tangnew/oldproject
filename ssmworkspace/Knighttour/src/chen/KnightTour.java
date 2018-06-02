package chen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


//修改 2016-12-28 add-s 不走applet，修改成jpanel
public class KnightTour extends JPanel {
//修改 2016-12-28 add-e
	
	// 初始位置位于某个位置的可达到数采用二维数组表示
	// 即以棋盘任意一点为初始位置，骑士游历完整个棋盘的路径
	public static int access[][] = { { 2, 3, 4, 4, 4, 4, 3, 2 },
			{ 3, 4, 6, 6, 6, 6, 4, 3 }, { 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 }, { 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 }, { 3, 4, 6, 6, 6, 6, 4, 3 },
			{ 2, 3, 4, 4, 4, 4, 3, 2 } };

	public static int accessbak[][] = arrayCopy(access);
	int countMoving = -1;
	int tourXpos[] = new int[64];// 游历中X,Y都有64个位置
	int tourYpos[] = new int[64];
	private int recordXpos[][];
	private int recordYpos[][];
	private int recordCount = -1;
	private boolean success = false;
	MyPanel myPanel;// 声明MyPanel的一个对象

	public void tour(int xpos, int ypos) {// 成员函数
		int x, y;
		countMoving++;// 如果64个格子都被走过，则返回
		if (countMoving == 63) {
			tourXpos[countMoving] = xpos;
			tourYpos[countMoving] = ypos;
			success = true;
			countMoving--;
			return;
		}
		AccessibleSquare nextSquare = new AccessibleSquare(xpos, ypos);
		// 初始化AssibleSquare对象，给nextSquare分配内存
		while (nextSquare.hasMoreAccessible())
		// 利用AccessibleSquare()对象调用hasMoreAccessible()成员函数
		{// 开始移动
			nextSquare.domoving();// 调用nextSquare.domoving()函数把这一步记录下来
			tourXpos[countMoving] = xpos;
			tourYpos[countMoving] = ypos;
			// 尝试下一步的移动
			nextSquare.nextAccessible();
			tour(nextSquare.getXpos(), nextSquare.getYpos());
			// 如果64个格子都被走过，则返回
			if (success) {
				countMoving--;
				return;
			}
			// 如果失败，则从起始位置从新开始
			nextSquare.undomoving();
		}
		countMoving--;
	}// 游历方法结束
		// 定义棋盘行和列
		// 先定义一行棋盘

	public static int[] arrayCopy(int array1[])// 定义一个整形数组arrayCopy
	{
		int[] array2 = new int[array1.length];
		for (int row = 0; row < array1.length; row++) {
			array2[row] = array1[row];
		}
		;
		return array2;
	}

	// 复制数组，既定义出棋盘列
	public static int[][] arrayCopy(int array1[][]) {
		int[][] array2 = new int[array1.length][array1[0].length];
		for (int row = 0; row < array1.length; row++) {
			for (int column = 0; column < array1[0].length; column++) {
				array2[row][column] = array1[row][column];
			}
			;
		}
		;
		return array2;
	}

	// 棋盘数组函数初始化
	public void initialArray(int chessBoard[][]) {
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				chessBoard[row][column] = 0;
			}
			;
		}
		;
	}

//	public static void main(String args[]) {
//		KnightTour application = new KnightTour();
//		application.tour(0, 0);
//		application.init();
//	}

	
	public void init() {
		recordCount = -1;
		recordXpos = new int[64][64];
		recordYpos = new int[64][64];
		for (int row = 0; row < 8; row++) {
			for (int column = 0; column < 8; column++) {
				success = false;
				countMoving = -1;
				access = arrayCopy(accessbak);
				tour(row, column);
				recordCount++;
				recordXpos[recordCount] = arrayCopy(tourXpos);
				recordYpos[recordCount] = arrayCopy(tourYpos);

			}
		}
		recordCount = 0;

		myPanel = new MyPanel(recordXpos[0], recordYpos[0]);
		JPanel buttonPanel = new JPanel();
		JButton nextMoving = new JButton("下一步");
		JButton nextTour = new JButton("新游戏");
		JButton nextExit = new JButton("退出");
		buttonPanel.add(nextTour);
		buttonPanel.add(nextMoving);
		buttonPanel.add(nextExit);
	
		//修改 2016-12-28 add-s
		this.setLayout(new BorderLayout());
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(myPanel);
		//修改 2016-12-28 add-e

		nextMoving.addActionListener(
		// 匿名内部类，定义了actionPerformed函数，调用showNext函数响应Next Moving Button事件
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myPanel.showNext();
					}
				});
		nextTour.addActionListener(
		// 内部类定义了actionPerformed函数，响应Next Tour Button事件
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (recordCount < recordXpos.length - 1) {
					recordCount++;
				} else {
					recordCount = 0;
				}
				myPanel.initboard(recordXpos[recordCount],
						recordYpos[recordCount]);
				myPanel.repaint();
			}
		});
		nextExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.setSize(340, 340);
		this.setVisible(true);
	}
	//修改 2016-12-28 add-s 删掉那个paint方法
	//修改 2016-12-28 add-s
	
}

