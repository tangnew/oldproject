package com;

public class AccessibleSquare {// 骑士8个方向走L形状所需的X坐标和Y坐标的变化量
	private static int horizontal[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int vertical[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private int xpos[];// 骑士所处X轴坐标
	private int ypos[];// 骑士所处Y轴坐标
	private int accessibility[];// 表示可达到数
	private int ownxpos, ownypos;
	private int ownAccessibility;
	private int arrayPos;
	private int countAccessibility;

	public AccessibleSquare(int x, int y) {// 构造函数
		int testXPos;
		int testYPos;
		xpos = new int[8];// 骑士所处X轴坐标
		ypos = new int[8];
		accessibility = new int[8];
		arrayPos = 0;
		ownxpos = x;
		ownypos = y;
		ownAccessibility = KnightTour.access[x][y];
		for (int i = 0; i < horizontal.length; i++) {// 有八种到达的情况
			testXPos = x + horizontal[i];// 得出X,Y坐标的测试位置
			testYPos = y + vertical[i];
			if ((testXPos >= 0) & (testXPos < 8) & (testYPos >= 0)
					& (testYPos < 8)) {// 判断测试位置是否在棋盘内
				xpos[arrayPos] = testXPos;// 由测试位置给出正确X,Y坐标
				ypos[arrayPos] = testYPos;
				accessibility[arrayPos] = KnightTour.access[testXPos][testYPos];
				// 利用对应的X,Y坐标得出相应的可达的路径总数
				// accessibility[arrayPos]=0表明格子已被占据
				if (accessibility[arrayPos] > 0)
					arrayPos++;
			}// 寻找空格子结束
		}// 结束for循环，寻找结束
		countAccessibility = arrayPos;// 统计可达到数
		if (countAccessibility > 0) {
			sortAll();
		}
		arrayPos = -1;
	}

	public boolean hasMoreAccessible() {
		// arrayPOS+1指向下一个可行的
		if ((arrayPos + 1) < countAccessibility) {
			return true;
		} else {
			return false;
		}
	}// hasMoreAccessible（）方法结束

	public AccessibleSquare nextAccessible() {
		arrayPos++;
		return this;
	}

	public AccessibleSquare accessibleAt(int pos) {
		if ((pos >= 0) & (pos < countAccessibility))
			arrayPos = pos;
		return this;
	}

	public int getXpos() {
		return xpos[arrayPos];
	}

	public int getYpos() {
		return ypos[arrayPos];
	}

	public int getAccessibility() {
		return accessibility[arrayPos];
	}

	public int getTotalAccessible() {
		return countAccessibility;
	}

	// 冒泡排序法，冒泡排序的基本概念是：依次比较相邻的两个数，将大数放在前面，小数放在后面
	private void sortAll() {
		for (int begin = 0; begin < countAccessibility - 1; begin++) {
			for (int i = begin + 1; i < countAccessibility; i++) {
				if (accessibility[begin] > accessibility[i]) {
					swapAll(begin, i);
				}// end of if
			}// end of inner for
		}// end of outer for
	}// end of sortAll
		// 交换两个数

	private void swapAll(int i, int j) {
		int temp;
		temp = xpos[i];
		xpos[i] = xpos[j];
		xpos[j] = temp;
		temp = ypos[i];
		ypos[i] = ypos[j];
		ypos[j] = temp;
		temp = accessibility[i];
		accessibility[i] = accessibility[j];
		accessibility[j] = temp;
	}// 进行移动操作

	public void domoving() {
		for (int i = 0; i < countAccessibility; i++) {
			KnightTour.access[xpos[i]][ypos[i]]--;
		}// 直到没有路径了
		KnightTour.access[ownxpos][ownypos] = 0;
	}// 撤销移动操作

	public void undomoving() {
		for (int i = 0; i < countAccessibility; i++) {
			KnightTour.access[xpos[i]][ypos[i]]++;
		}
		KnightTour.access[ownxpos][ownypos] = ownAccessibility;
	}

}
