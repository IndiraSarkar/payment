package com.ingenico.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ingenico.payment.domain.AdminPage;
import com.ingenico.payment.service.PaymentService;

@Controller
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/adminForm")  
    public ModelAndView adminDisplay()  
    {  
		System.out.println("ADMIN CONTROLLER");
        return new ModelAndView("adminForm", "command", new AdminPage());
    } 
	
	
	@PostMapping("/saveAdminPageDetails")
	public String saveAdmin(@ModelAttribute("admin") AdminPage adminPage) {
		System.out.println("adminPage :"+adminPage);  
		 return "admin";
	}

}
