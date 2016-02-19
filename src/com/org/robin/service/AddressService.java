package com.org.robin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.robin.DTO.Address;
import com.org.robin.dao.AddressDao;
import com.org.robin.dao.UserDao;
import com.org.robin.interfaces.MyInterfaces;
import com.org.robin.viewbean.AddressBean;

@Service
public class AddressService implements MyInterfaces {

	@Autowired
	private AddressDao addr;
	
	@Autowired
	private UserDao user;
	
	public List<Address> getData() {
		 return addr.getData();
	}

	@Override
	public String saveData(AddressBean data) {
		Address addrTosave = new Address();
		addrTosave.setAppNo(data.getAppNo());
		addrTosave.setCity(data.getCity());
		addrTosave.setFirstName(data.getFirstName());
		addrTosave.setLane(data.getLane());
		addrTosave.setLastName(data.getLastName());
		addrTosave.setPin(Integer.parseInt(data.getPin()));
		addrTosave.setState(data.getState());
		return addr.saveData(addrTosave);
	}

	@Override
	public String isValiduser(String userId, String password) {
		return user.isValiduser(userId,password);
	}
   
}
