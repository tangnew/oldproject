/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.page;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.hotel.listener.InHouseListener;

/**
 *
 * @author Administrator
 */
public class InHousePage extends javax.swing.JPanel {

	private static final long serialVersionUID = -3305951089004899491L;
	/**
     * Creates new form InHousePage
     */
    public InHousePage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clientPanel = new javax.swing.JPanel();
        serachPanel = new javax.swing.JPanel();
        房间号 = new javax.swing.JLabel();
        houseNumberTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientHouseTable = new javax.swing.JTable();
        btnPanel = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "入住情况", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 1, 14))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        serachPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("查询条件"));

        房间号.setText("房间号");

        searchBtn.setText("查询");

        javax.swing.GroupLayout serachPanelLayout = new javax.swing.GroupLayout(serachPanel);
        serachPanel.setLayout(serachPanelLayout);
        serachPanelLayout.setHorizontalGroup(
            serachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serachPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(房间号)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        serachPanelLayout.setVerticalGroup(
            serachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serachPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(serachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(房间号)
                    .addComponent(houseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("入住信息"));
		dataModel = new javax.swing.table.DefaultTableModel(new String[][] {},
				new String[] { "房间号", "房间类型", "入住人数", "入住时间", "退房时间", "入住人信息", "房间物品", "编号" }) {
			private static final long serialVersionUID = 7276940403186273826L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class, 
					java.lang.String.class  };

			@SuppressWarnings("rawtypes")
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
        clientHouseTable.setModel(dataModel);
        TableColumn headerColumn = clientHouseTable.getTableHeader()
				.getColumnModel().getColumn(7);
		headerColumn.setMinWidth(0);
		headerColumn.setMaxWidth(0);
		headerColumn.setPreferredWidth(0);
		TableColumn rowColumn = clientHouseTable.getColumnModel().getColumn(7);
		rowColumn.setMinWidth(0);
		rowColumn.setMaxWidth(0);
		rowColumn.setPreferredWidth(0);
		
        jScrollPane1.setViewportView(clientHouseTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout clientPanelLayout = new javax.swing.GroupLayout(clientPanel);
        clientPanel.setLayout(clientPanelLayout);
        clientPanelLayout.setHorizontalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(serachPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        clientPanelLayout.setVerticalGroup(
            clientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientPanelLayout.createSequentialGroup()
                .addComponent(serachPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(clientPanel, java.awt.BorderLayout.CENTER);

        deleteBtn.setText("删除");
        btnPanel.add(deleteBtn);

        logoutBtn.setText("退房");
        btnPanel.add(logoutBtn);

        add(btnPanel, java.awt.BorderLayout.PAGE_END);
        
        initDefaultData();
        
        initEventListener();
    }// </editor-fold>//GEN-END:initComponents

    private void initDefaultData(){
    	int count = dataModel.getRowCount();
		for (int index = count - 1; index >= 0; index--) {
			dataModel.removeRow(index);
		}
    }

    private void initEventListener(){
    	searchBtn.setActionCommand(InHouseListener.search_btn_command);
    	searchBtn.addActionListener(new InHouseListener(this));
    	
    	deleteBtn.setActionCommand(InHouseListener.delete_btn_command);
    	deleteBtn.addActionListener(new InHouseListener(this));
    	
    	logoutBtn.setActionCommand(InHouseListener.logout_btn_command);
    	logoutBtn.addActionListener(new InHouseListener(this));
    }
    
    public String getHouseNumber(){
    	return houseNumberTextField.getText();
    }
    
    public DefaultTableModel getTableDataModel(){
    	return dataModel;
    }
    
    public javax.swing.JTable getClientHouseTable(){
    	return clientHouseTable;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnPanel;
    private javax.swing.JTable clientHouseTable;
    private javax.swing.JPanel clientPanel;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField houseNumberTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel serachPanel;
    private javax.swing.JLabel 房间号;
    // End of variables declaration//GEN-END:variables
    private  DefaultTableModel dataModel;
}
