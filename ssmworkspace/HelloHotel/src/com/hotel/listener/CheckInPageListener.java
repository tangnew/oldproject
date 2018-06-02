package com.hotel.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.hotel.model.Client;
import com.hotel.model.ClientHouse;
import com.hotel.page.CheckInPage;
import com.hotel.service.ClientHouseService;
import com.hotel.service.ServiceFactory;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 6:27:06 PM
 *
 * com.hotel.listener.CheckInPageListener
 */
public class CheckInPageListener implements ActionListener {
    public static final String CHECK_IN_BTN_COMMAND = "checkInBtnCommand";
	private CheckInPage checkInPage;
	private ClientHouseService clientHouseService;
	/**
	 * 
	 */
	public CheckInPageListener(CheckInPage checkInPage) {
		clientHouseService = ServiceFactory.getService(ServiceFactory.CLIENT_HOUSE_SERIVCE);
		this.checkInPage = checkInPage;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(CHECK_IN_BTN_COMMAND.equals(command)){
				addClientAndHouse();
				return;
			}
	}
	
	private void addClientAndHouse() {
		boolean isOk = false;
		try {
			String clientNumber = checkInPage.getClientNumber();
			String houseNumber = checkInPage.getHouseNumber();
			String houseThingInfo = checkInPage.getHouseThingInfo();
			String houseType = checkInPage.getHouseType();
			List<Client> clients = checkInPage.getClients();

			if (null == houseNumber || houseNumber.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "请添加入住房间号!", "提示",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (null == clientNumber || clientNumber.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "请添加入住客人人数!", "提示",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				Integer.parseInt(clientNumber);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "入住客人人数必须为数字", "登记失败",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (null == clients || clients.size() == 0) {
				JOptionPane.showMessageDialog(null, "请添加入住客人身份信息!", "提示",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			ClientHouse clientHouse = new ClientHouse();
			clientHouse.setHouseNumber(houseNumber);
			clientHouse.setHouseThing(houseThingInfo);
			clientHouse.setClientNumber(Integer.parseInt(clientNumber));
			clientHouse.setHouseType(houseType);
			isOk = clientHouseService.addClientAndHouse(clients, clientHouse);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"登记失败,清检查填入信息是否正确!\n" + e.getMessage(), "登记失败",
					JOptionPane.ERROR_MESSAGE);
		}
		if (isOk) {
			JOptionPane.showMessageDialog(null, "登记成功", "登记成功",
					JOptionPane.PLAIN_MESSAGE);
			checkInPage.clearData();
		}
	}
}
