package com.org.robin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.org.robin.DTO.Address;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	
	public ModelAndView executeLogin(HttpServletRequest request,HttpServletResponse response)
	{
		List<Address> addrList = new ArrayList<Address>();
		ModelAndView model = null;
		try {
			  for(int i=1;i<10;i++){
			    Address addr = new Address();
			    addr.setAppNo(String.valueOf(100 + i));
			    addr.setCity("City "+ String.valueOf(i));
			    addr.setFirstName("Fisrt name "+ String.valueOf(i));
			    addr.setId(i);
			    addr.setLane("Lane name " + String.valueOf(i));
			    addr.setLastName("Last Name "+String.valueOf(i));
			    addr.setPin(50096);
			    addr.setState("GA");
			    addrList.add(addr);
			  }
				request.setAttribute("addressList", addrList);
				model = new ModelAndView("welcome");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

}
