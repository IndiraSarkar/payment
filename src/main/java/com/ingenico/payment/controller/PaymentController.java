package com.ingenico.payment.controller;


import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.ingenico.payment.domain.MerchantData;

@Controller
public class PaymentController {
	
	
	@Value("${spring.inginco.url}")
	private String url;
		
	@GetMapping("/")
	public ModelAndView passParametersWithModelAndView(HttpServletRequest request) {

		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		try {

			jsonObject = (JSONObject) parser.parse(new InputStreamReader(
					new FileInputStream("E://inginco-payment//src//main//resources/ConfigFile.json")));

			MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);

			String returnUrl = url + "response/response-handler";
			System.out.println(merchantData.toString());
		
		ModelAndView modelAndView = new ModelAndView("Home");
		modelAndView.addObject("config_data",merchantData);
		modelAndView.addObject("returnUrl", returnUrl);
		return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
