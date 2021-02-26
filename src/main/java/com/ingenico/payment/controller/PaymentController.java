package com.ingenico.payment.controller;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.ingenico.payment.domain.MerchantData;
import com.ingenico.payment.domain.TranscationResponse;
import com.ingenico.payment.service.PaymentService;

@Controller
public class PaymentController {

	@Value("${ingenico.url}")
	private String url;

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ResourceLoader resourceLoader;


	@GetMapping("/")
	public ModelAndView passTranscationWithModelAndView(HttpServletRequest request) {

		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		try {

			Resource fileResource = resourceLoader.getResource("classpath:ConfigFile.json");
			jsonObject = (JSONObject) parser.parse(new InputStreamReader(
					new FileInputStream(fileResource.getFile())));

			MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);

			String returnUrl = url + "response/response-handler";
			int transcationId = paymentService.generateRandomNumber();


			ModelAndView modelAndView = new ModelAndView("Home");
			modelAndView.addObject("config_data", merchantData);
			modelAndView.addObject("returnUrl", returnUrl);
			modelAndView.addObject("transcationId", transcationId);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@PostMapping("/onlineTransactionHandler")
	@ResponseBody
	public JSONObject onlineTransactionHandler(HttpServletRequest request,
			@RequestParam Map<String, String> configData) {

		String data = paymentService.getHashData(configData);

		String encryptedHash = paymentService.encryptedHash(data);

		return paymentService.getHashObject(encryptedHash, configData);


	}
	
	@GetMapping("/offlineVerification")
	@ResponseBody
	public ModelAndView offlineTransaction() {
		return new ModelAndView("OfflineVerification");

	}

	@PostMapping("/offlineVerification")
	@ResponseBody
	public ModelAndView offlineTransactionHandler(HttpServletRequest request,
			@RequestParam Map<String, String> configData) {

		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		try {
			
			Resource fileResource = resourceLoader.getResource("classpath:ConfigFile.json");
			jsonObject = (JSONObject) parser.parse(new InputStreamReader(
					new FileInputStream(fileResource.getFile())));

			MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);

			JSONObject obj = paymentService.createRequestForOfflineVerification(configData, merchantData);

			String liveUrl = "https://www.paynimo.com/api/paynimoV2.req";
			String dualVerificationResult = paymentService.fetchApiResponse(liveUrl, obj);

			TranscationResponse transcationResponse = new Gson().fromJson(dualVerificationResult,
					TranscationResponse.class);
			ModelAndView modelAndView = new ModelAndView("OfflineVerification");
			modelAndView.addObject("response", transcationResponse);
			return modelAndView;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
 
	@GetMapping("/refund")
	@ResponseBody
	public ModelAndView refund() {
		return new ModelAndView("RefundHandler");

	}
	
	@PostMapping("/refund")
	@ResponseBody
	public ModelAndView refundHandler(HttpServletRequest request, @RequestParam Map<String, String> configData) {

		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		try {
			Resource fileResource = resourceLoader.getResource("classpath:ConfigFile.json");
			jsonObject = (JSONObject) parser.parse(new InputStreamReader(
					new FileInputStream(fileResource.getFile())));

			MerchantData merchantData = new Gson().fromJson(jsonObject.toString(), MerchantData.class);

			JSONObject obj = paymentService.createRequestForRefund(configData, merchantData);

			String liveUrl = "https://www.paynimo.com/api/paynimoV2.req";
			String dualVerificationResult = paymentService.fetchApiResponse(liveUrl, obj);

			TranscationResponse transcationResponse = new Gson().fromJson(dualVerificationResult,
					TranscationResponse.class);
			ModelAndView modelAndView = new ModelAndView("RefundHandler");
			modelAndView.addObject("response", transcationResponse);
			return modelAndView;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
