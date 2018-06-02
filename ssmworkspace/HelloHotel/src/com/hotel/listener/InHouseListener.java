package com.hotel.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.hotel.model.Client;
import com.hotel.model.ClientHouse;
import com.hotel.page.InHousePage;
import com.hotel.service.ClientHouseService;
import com.hotel.service.ServiceFactory;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 11:54:39 PM
 *
 * com.hotel.listener.InHouseListener
 */
public class InHouseListener implements ActionListener {
	public static final String search_btn_command = "searchBtnCommand";
	public static final String delete_btn_command = "deleteBtnCommand";
	public static final String logout_btn_command = "logoutBtnCommand";
	private InHousePage inHousePage;
	private ClientHouseService clientHouseService;

	public InHouseListener(InHousePage inHousePage) {
		clientHouseService = ServiceFactory
				.getService(ServiceFactory.CLIENT_HOUSE_SERIVCE);
		this.inHousePage = inHousePage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (search_btn_command.equals(command)) {
			searchBtn();
			return;
		}
		if (delete_btn_command.equals(command)) {
			deleteBtn();
			return;
		}

		if (logout_btn_command.equals(command)) {
			logoutBtn();
			return;
		}

	}

	private void searchBtn() {
		int count = inHousePage.getTableDataModel().getRowCount();
		for (int index = count - 1; index >= 0; index--) {
			inHousePage.getTableDataModel().removeRow(index);
		}

		String houseNumber = inHousePage.getHouseNumber();
		List<ClientHouse> chs = clientHouseService
				.getClientAndHouseByHouseNumber(houseNumber);
		int size = chs.size();
		boolean hasRecord = false;
		for (int i = 0; i < size; i++) {
			ClientHouse ch = chs.get(i);
			if (ch.getStatus() == ClientHouse.STATUS.DELETED) {
				continue;
			}
			hasRecord = true;
			StringBuilder clients = new StringBuilder();
			for(int j = 0; j < ch.getClients().size(); j++){
				Client temp = ch.getClients().get(j);
				clients.append("姓名:").append(temp.getName())
						.append(" 身份证:").append(temp.getIdentity())
						.append(" 性别:").append(temp.getGender())
						.append("\n");
			}
			String[] newClient = { ch.getHouseNumber(), ch.getHouseType(),
					String.valueOf(ch.getClientNumber()), ch.getStartTime(),
					ch.getEndTime(), clients.toString(), ch.getHouseThing(),
					ch.getId() };
			inHousePage.getTableDataModel().addRow(newClient);
		}

		if (!hasRecord) {
			JOptionPane.showMessageDialog(null, "无法找到入住记录,清重新输入房间号!",
					"无法找到入住记录", JOptionPane.PLAIN_MESSAGE);
			return;
		}
	}

	private void deleteBtn() {
		boolean isOk = false;
		int row = 0;
		try {
			row = inHousePage.getClientHouseTable().getSelectedRow();
			if(row < 0){
				JOptionPane.showMessageDialog(null, "没有选中任何记录!",
						"提示", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			isOk = clientHouseService
					.deleteClientAndHouseById((String) inHousePage
							.getClientHouseTable().getValueAt(row, 7));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "删除失败!\n" + e.getMessage(),
					"删除失败", JOptionPane.ERROR_MESSAGE);
		}

		if (isOk) {
			JOptionPane.showMessageDialog(null, "删除成功", "删除成功",
					JOptionPane.PLAIN_MESSAGE);
			inHousePage.getTableDataModel().removeRow(row);
		}
	}

	private void logoutBtn() {
		boolean isOk = false;
		int row = 0;
		try {
			row = inHousePage.getClientHouseTable().getSelectedRow();
			if(row < 0){
				JOptionPane.showMessageDialog(null, "没有选中任何记录!",
						"提示", JOptionPane.PLAIN_MESSAGE);
				return;
			}
			Object endTime = inHousePage.getClientHouseTable().getValueAt(row, 4);
			if (null != endTime && !((String) endTime).trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "改房间已经退了，无需再退", "退房",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
			isOk = clientHouseService
					.updateClientAndHouseStatusById((String) inHousePage
							.getClientHouseTable().getValueAt(row, 7));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "退房失败!\n" + e.getMessage(),
					"退房失败", JOptionPane.ERROR_MESSAGE);
		}

		if (isOk) {
			JOptionPane.showMessageDialog(null, "退房成功", "退房成功",
					JOptionPane.PLAIN_MESSAGE);
			searchBtn();
		}
	}
}
