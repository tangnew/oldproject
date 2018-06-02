package com;

public class AccessibleSquare {// ��ʿ8��������L��״�����X�����Y����ı仯��
	private static int horizontal[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static int vertical[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private int xpos[];// ��ʿ����X������
	private int ypos[];// ��ʿ����Y������
	private int accessibility[];// ��ʾ�ɴﵽ��
	private int ownxpos, ownypos;
	private int ownAccessibility;
	private int arrayPos;
	private int countAccessibility;

	public AccessibleSquare(int x, int y) {// ���캯��
		int testXPos;
		int testYPos;
		xpos = new int[8];// ��ʿ����X������
		ypos = new int[8];
		accessibility = new int[8];
		arrayPos = 0;
		ownxpos = x;
		ownypos = y;
		ownAccessibility = KnightTour.access[x][y];
		for (int i = 0; i < horizontal.length; i++) {// �а��ֵ�������
			testXPos = x + horizontal[i];// �ó�X,Y����Ĳ���λ��
			testYPos = y + vertical[i];
			if ((testXPos >= 0) & (testXPos < 8) & (testYPos >= 0)
					& (testYPos < 8)) {// �жϲ���λ���Ƿ���������
				xpos[arrayPos] = testXPos;// �ɲ���λ�ø�����ȷX,Y����
				ypos[arrayPos] = testYPos;
				accessibility[arrayPos] = KnightTour.access[testXPos][testYPos];
				// ���ö�Ӧ��X,Y����ó���Ӧ�Ŀɴ��·������
				// accessibility[arrayPos]=0���������ѱ�ռ��
				if (accessibility[arrayPos] > 0)
					arrayPos++;
			}// Ѱ�ҿո��ӽ���
		}// ����forѭ����Ѱ�ҽ���
		countAccessibility = arrayPos;// ͳ�ƿɴﵽ��
		if (countAccessibility > 0) {
			sortAll();
		}
		arrayPos = -1;
	}

	public boolean hasMoreAccessible() {
		// arrayPOS+1ָ����һ�����е�
		if ((arrayPos + 1) < countAccessibility) {
			return true;
		} else {
			return false;
		}
	}// hasMoreAccessible������������

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

	// ð�����򷨣�ð������Ļ��������ǣ����αȽ����ڵ�������������������ǰ�棬С�����ں���
	private void sortAll() {
		for (int begin = 0; begin < countAccessibility - 1; begin++) {
			for (int i = begin + 1; i < countAccessibility; i++) {
				if (accessibility[begin] > accessibility[i]) {
					swapAll(begin, i);
				}// end of if
			}// end of inner for
		}// end of outer for
	}// end of sortAll
		// ����������

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
	}// �����ƶ�����

	public void domoving() {
		for (int i = 0; i < countAccessibility; i++) {
			KnightTour.access[xpos[i]][ypos[i]]--;
		}// ֱ��û��·����
		KnightTour.access[ownxpos][ownypos] = 0;
	}// �����ƶ�����

	public void undomoving() {
		for (int i = 0; i < countAccessibility; i++) {
			KnightTour.access[xpos[i]][ypos[i]]++;
		}
		KnightTour.access[ownxpos][ownypos] = ownAccessibility;
	}

}
