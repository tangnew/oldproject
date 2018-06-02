package com.service.impl.tuser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.service.tuser.TUserService;

@Service("tuserService")
public class TUserServiceImpl implements TUserService {

	private static String highAudit="highAudit";
	private static String lowAudit = "lowAudit";
	@Override
	public List<String> getPersonNamesByPosition(String positionName) {
		List<String> persons = new ArrayList<String>();
		if(highAudit.equals(positionName)){
			persons.add("hi0");
			persons.add("hi1");
		}else{
			persons.add("low0");
			persons.add("low1");	
		}
		return persons;
	}

}
