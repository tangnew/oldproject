package com.hotel.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.hotel.model.HouseType;
import com.hotel.page.HouseTypePage;
import com.hotel.service.HouseTypeService;
import com.hotel.service.ServiceFactory;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 27, 2016 
 * Time: 10:19:31 AM
 *
 * com.hotel.listener.HouseTypeListener
 */
public class HouseTypeListener implements ActionListener {
	
	public static final String ADD_BTN_COMMAND = "addBtnCommand";
	public static final String SEARCH_BTN_COMMAND = "searchBtnCommand";
	public static final String UPDATE_BTN_COMMAND = "updateBtnCommand";
	public static final String DELETE_BTN_COMMAND = "deleteBtnCommand";

	private HouseTypePage houseTypePage;
	private HouseTypeService houseTypeService;

	/**
		 * 
		 */
	public HouseTypeListener(HouseTypePage houseTypePage) {
		houseTypeService = ServiceFactory
				.getService(ServiceFactory.HOUSE_TYPE_SERVICE);
		this.houseTypePage = houseTypePage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (ADD_BTN_COMMAND.equals(command)) {
			addHouseType();
			return;
		}

		if (SEARCH_BTN_COMMAND.equals(command)) {
			searchHouseType();
			return;
		}
		
		if (DELETE_BTN_COMMAND.equals(command)) {
			deleteHouseType();
			return;
		}
	}

	private void addHouseType() {
		String houseType = houseTypePage.getHouseTypeName();
		String desc = houseTypePage.getDescription();
		
		if(null == houseType || houseType.trim().isEmpty()){
			JOptionPane.showMessageDialog(null,
					"房间类型名称不能够为空白" , "提示",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		HouseType ht = new HouseType();
		ht.setName(houseType);
		ht.setDescription(desc);
		try {
			houseTypeService.addHouseType(ht);
			JOptionPane.showMessageDialog(null, "房间类型添加成功", "添加成功",
					JOptionPane.INFORMATION_MESSAGE);
			houseTypePage.clearData();
			searchHouseType();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "房间类型添加失败!\n" + e.getMessage(),
					"添加失败", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void searchHouseType() {
		int count = houseTypePage.getTableDataModel().getRowCount();
		for (int index = count - 1; index >= 0; index--) {
			houseTypePage.getTableDataModel().removeRow(index);
		}
		String houseType = houseTypePage.getHouseTypeName();
		if (null == houseType || houseType.trim().isEmpty()) {
			houseType = "";
		}

		List<HouseType> hts = houseTypeService.getHouseTypes(houseType);
		int size = hts.size();
		boolean hasRecord = false;
		for (int i = 0; i < size; i++) {
			HouseType ht = hts.get(i);
			if (ht.getStatus() == HouseType.STATUS.DELETED) {
				continue;
			}
			hasRecord = true;
			String[] newRecord = { ht.getName(), ht.getDescription(),
					ht.getCreatedTimeStr(), ht.getUpdatedTimeStr(), ht.getId()};
			houseTypePage.getTableDataModel().addRow(newRecord);
		}

		if (!hasRecord) {
			JOptionPane.showMessageDialog(null, "无法找到房间类型记录,清重新输入房间类型名称!",
					"无法找到房间类型记录", JOptionPane.PLAIN_MESSAGE);
			return;
		}
	}
	
	private void deleteHouseType(){
		boolean isOk = false;
		int row = 0;
		try {
			row = houseTypePage.getHouseTypeTable().getSelectedRow();
			if(row < 0){
				JOptionPane.showMessageDialog(null, "没有选中任何房间类型记录!",
						"删除失败", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			String id = (String) houseTypePage
					.getHouseTypeTable().getValueAt(row, 4);
			isOk = houseTypeService
					.deleteHouseTypeById(id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "删除失败!\n" + e.getMessage(),
					"删除失败", JOptionPane.ERROR_MESSAGE);
		}

		if (isOk) {
			JOptionPane.showMessageDialog(null, "删除成功", "删除成功",
					JOptionPane.PLAIN_MESSAGE);
			houseTypePage.getTableDataModel().removeRow(row);
		}
	}
}
