/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel.page;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.hotel.model.HouseType;
import com.hotel.service.HouseTypeService;
import com.hotel.service.ServiceFactory;

/**
 *
 * @author Administrator
 */
public class HouseListPage extends javax.swing.JPanel {
	private HouseTypeService houseTypeService; 

    /**
	 * 
	 */
	private static final long serialVersionUID = -3161924879025907486L;
	/**
     * Creates new form HouseListPage
     */
    public HouseListPage() {
		houseTypeService = ServiceFactory.getService(ServiceFactory.HOUSE_TYPE_SERVICE);

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

        housePanel = new javax.swing.JPanel();
        addOrSearchPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        houseNumberTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        houseTypeComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descTextArea = new javax.swing.JTextArea();
        searchBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        houseInfoPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        houseTable = new javax.swing.JTable();
        btnPanel = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "房间基本信息", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 1, 14))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        addOrSearchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("查询增加"));

        jLabel1.setText("房间号");

        jLabel2.setText("房间类型");

        jLabel3.setText("备注");

        descTextArea.setColumns(20);
        descTextArea.setRows(5);
        jScrollPane2.setViewportView(descTextArea);

        searchBtn.setText("查询");

        addBtn.setText("增加");

        javax.swing.GroupLayout addOrSearchPanelLayout = new javax.swing.GroupLayout(addOrSearchPanel);
        addOrSearchPanel.setLayout(addOrSearchPanelLayout);
        addOrSearchPanelLayout.setHorizontalGroup(
            addOrSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addOrSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addOrSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addOrSearchPanelLayout.createSequentialGroup()
                        .addComponent(houseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(houseTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 151, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(addOrSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBtn)
                    .addComponent(addBtn))
                .addGap(159, 159, 159))
        );
        addOrSearchPanelLayout.setVerticalGroup(
            addOrSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addOrSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addOrSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addBtn)
                    .addGroup(addOrSearchPanelLayout.createSequentialGroup()
                        .addGroup(addOrSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(houseNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(houseTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn))
                        .addGroup(addOrSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addOrSearchPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addOrSearchPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        houseInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("房间信息"));

        jScrollPane1.setViewportView(houseTable);

        javax.swing.GroupLayout houseInfoPanelLayout = new javax.swing.GroupLayout(houseInfoPanel);
        houseInfoPanel.setLayout(houseInfoPanelLayout);
        houseInfoPanelLayout.setHorizontalGroup(
            houseInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        houseInfoPanelLayout.setVerticalGroup(
            houseInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout housePanelLayout = new javax.swing.GroupLayout(housePanel);
        housePanel.setLayout(housePanelLayout);
        housePanelLayout.setHorizontalGroup(
            housePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addOrSearchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(houseInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        housePanelLayout.setVerticalGroup(
            housePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(housePanelLayout.createSequentialGroup()
                .addComponent(addOrSearchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(houseInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(housePanel, java.awt.BorderLayout.CENTER);

        editBtn.setText("编辑");
        btnPanel.add(editBtn);

        deleteBtn.setText("删除");
        btnPanel.add(deleteBtn);

        add(btnPanel, java.awt.BorderLayout.PAGE_END);
        
        initDefaultData();
        initEventListener();
    }// </editor-fold>//GEN-END:initComponents

	private void initDefaultData() {
		editBtn.setVisible(false);
		dataModel = new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "房间号", "房间类型", "当前入住状态", "描述", "创建时间", "更新时间",
						"编号" }) {
			private static final long serialVersionUID = 5886189813677606405L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class, java.lang.String.class };

			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		};
		houseTable.setModel(dataModel);
		TableColumn headerColumn = houseTable.getTableHeader().getColumnModel()
				.getColumn(6);
		headerColumn.setMinWidth(0);
		headerColumn.setMaxWidth(0);
		headerColumn.setPreferredWidth(0);
		TableColumn rowColumn = houseTable.getColumnModel().getColumn(6);
		rowColumn.setMinWidth(0);
		rowColumn.setMaxWidth(0);
		rowColumn.setPreferredWidth(0);
		
		loadComboxData();
	}

	private void initEventListener() {

	}

	public void loadComboxData(){
		List<HouseType> hts = houseTypeService.getHouseTypes("");
		boolean isHas = false;
		if(null == hts || 0 == hts.size()){
		}else{
			List<String> types = new ArrayList<String>();
			for(int i = 0 ; i < hts.size(); i++){
				HouseType ht = hts.get(i);
				int status = ht.getStatus();
				if(status == HouseType.STATUS.USED){
				types.add(ht.getName());
				  isHas = true;
				}
			}
			if(isHas){
				String[] newTypes = new String[types.size() + 1];
				for(int i = 0 ; i < types.size(); i++){
					newTypes[i] = types.get(i);
				}
				newTypes[types.size()] = "标准间";
				comboBoxModel = new javax.swing.DefaultComboBoxModel<>(newTypes);
			}
		}
		
		if (!isHas) {
			comboBoxModel = new javax.swing.DefaultComboBoxModel<>(
					new String[] { "标准间" });
		}
		
		houseTypeComboBox.setModel(comboBoxModel);
	}
	
	public javax.swing.JTable getHouseTable() {
		return houseTable;
	}

	public DefaultTableModel getTableDataModel() {
		return dataModel;
	}

	private DefaultTableModel dataModel;
	private DefaultComboBoxModel<String> comboBoxModel;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton addBtn;
	private javax.swing.JPanel addOrSearchPanel;
	private javax.swing.JPanel btnPanel;
	private javax.swing.JButton deleteBtn;
	private javax.swing.JTextArea descTextArea;
	private javax.swing.JButton editBtn;
	private javax.swing.JPanel houseInfoPanel;
	private javax.swing.JTextField houseNumberTextField;
	private javax.swing.JPanel housePanel;
	private javax.swing.JTable houseTable;
	private javax.swing.JComboBox<String> houseTypeComboBox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton searchBtn;
    // End of variables declaration//GEN-END:variables
}
