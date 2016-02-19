package com.org.robin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.org.robin.interfaces.MyInterfaces;
import com.org.robin.viewbean.AddressBean;
import com.org.robin.viewbean.LoginBean;

@Controller
public class springMVCController {

	@Autowired
	MyInterfaces myInterface;


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = new ModelAndView("login");
		LoginBean loginBean = new LoginBean();
		model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		ModelAndView model = null;
		try {
			String userName="";
			HttpSession session = request.getSession(false);
			if(null !=session.getAttribute("loggedInUser"))
				userName = session.getAttribute("loggedInUser").toString();
			else
				userName = myInterface.isValiduser(loginBean.getUsername(), loginBean.getPassword());
			if (!"".equals(userName)&&null!=userName) {
				session.setAttribute("loggedInUser", userName);
				request.setAttribute("loggedInUser", userName);
				
				//model = new ModelAndView("welcome");
				model = new ModelAndView("Address");
				AddressBean addrBean = new AddressBean();
				model.addObject("addressBean", addrBean);
			} else {
				model = new ModelAndView("login");
				model.addObject("loginBean", loginBean);
				request.setAttribute("message", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

}
