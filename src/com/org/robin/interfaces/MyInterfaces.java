package com.org.robin.interfaces;

import java.util.List;

import com.org.robin.DTO.Address;
import com.org.robin.viewbean.AddressBean;

public interface MyInterfaces {
	public List<Address> getData();
	public String saveData(AddressBean data);
	public String isValiduser(String userId, String password);
}
