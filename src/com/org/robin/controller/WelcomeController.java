package com.org.robin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.org.robin.interfaces.MyInterfaces;
import com.org.robin.viewbean.AddressBean;

@Controller
public class WelcomeController {

	@Autowired
	MyInterfaces myInterface;

	@RequestMapping(value = "/welcome", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = null;
		try {
			request.setAttribute("addressList", myInterface.getData());
			model = new ModelAndView("welcome");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return model;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView executeWelcome(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = null;
		try {
			model = new ModelAndView("welcome");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return model;
	}
	@RequestMapping(value = "/saveAddr", method = RequestMethod.POST)
	public ModelAndView saveAddr(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("addressBean") AddressBean addressBean) {
		ModelAndView model = null;
		try {
			String result = myInterface.saveData(addressBean);
			request.setAttribute("message", result);
			model = new ModelAndView("Address");
			if("success".equals(result)){
				AddressBean addrBean = new AddressBean();
				model.addObject("addressBean", addrBean);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return model;
	}
	
	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public ModelAndView executeAddress(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = null;
		try {
			model = new ModelAndView("Address");
			AddressBean addrBean = new AddressBean();
			model.addObject("addressBean", addrBean);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return model;
	}

}
