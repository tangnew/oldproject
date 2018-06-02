package chen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


//�޸� 2016-12-28 add-s ����applet���޸ĳ�jpanel
public class KnightTour extends JPanel {
//�޸� 2016-12-28 add-e
	
	// ��ʼλ��λ��ĳ��λ�õĿɴﵽ�����ö�ά�����ʾ
	// ������������һ��Ϊ��ʼλ�ã���ʿ�������������̵�·��
	public static int access[][] = { { 2, 3, 4, 4, 4, 4, 3, 2 },
			{ 3, 4, 6, 6, 6, 6, 4, 3 }, { 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 }, { 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 }, { 3, 4, 6, 6, 6, 6, 4, 3 },
			{ 2, 3, 4, 4, 4, 4, 3, 2 } };

	public static int accessbak[][] = arrayCopy(access);
	int countMoving = -1;
	int tourXpos[] = new int[64];// ������X,Y����64��λ��
	int tourYpos[] = new int[64];
	private int recordXpos[][];
	private int recordYpos[][];
	private int recordCount = -1;
	private boolean success = false;
	MyPanel myPanel;// ����MyPanel��һ������

	public void tour(int xpos, int ypos) {// ��Ա����
		int x, y;
		countMoving++;// ���64�����Ӷ����߹����򷵻�
		if (countMoving == 63) {
			tourXpos[countMoving] = xpos;
			tourYpos[countMoving] = ypos;
			success = true;
			countMoving--;
			return;
		}
		AccessibleSquare nextSquare = new AccessibleSquare(xpos, ypos);
		// ��ʼ��AssibleSquare���󣬸�nextSquare�����ڴ�
		while (nextSquare.hasMoreAccessible())
		// ����AccessibleSquare()�������hasMoreAccessible()��Ա����
		{// ��ʼ�ƶ�
			nextSquare.domoving();// ����nextSquare.domoving()��������һ����¼����
			tourXpos[countMoving] = xpos;
			tourYpos[countMoving] = ypos;
			// ������һ�����ƶ�
			nextSquare.nextAccessible();
			tour(nextSquare.getXpos(), nextSquare.getYpos());
			// ���64�����Ӷ����߹����򷵻�
			if (success) {
				countMoving--;
				return;
			}
			// ���ʧ�ܣ������ʼλ�ô��¿�ʼ
			nextSquare.undomoving();
		}
		countMoving--;
	}// ������������
		// ���������к���
		// �ȶ���һ������

	public static int[] arrayCopy(int array1[])// ����һ����������arrayCopy
	{
		int[] array2 = new int[array1.length];
		for (int row = 0; row < array1.length; row++) {
			array2[row] = array1[row];
		}
		;
		return array2;
	}

	// �������飬�ȶ����������
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

	// �������麯����ʼ��
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
		JButton nextMoving = new JButton("��һ��");
		JButton nextTour = new JButton("����Ϸ");
		JButton nextExit = new JButton("�˳�");
		buttonPanel.add(nextTour);
		buttonPanel.add(nextMoving);
		buttonPanel.add(nextExit);
	
		//�޸� 2016-12-28 add-s
		this.setLayout(new BorderLayout());
		this.add(buttonPanel, BorderLayout.SOUTH);
		this.add(myPanel);
		//�޸� 2016-12-28 add-e

		nextMoving.addActionListener(
		// �����ڲ��࣬������actionPerformed����������showNext������ӦNext Moving Button�¼�
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						myPanel.showNext();
					}
				});
		nextTour.addActionListener(
		// �ڲ��ඨ����actionPerformed��������ӦNext Tour Button�¼�
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
	//�޸� 2016-12-28 add-s ɾ���Ǹ�paint����
	//�޸� 2016-12-28 add-s
	
}

