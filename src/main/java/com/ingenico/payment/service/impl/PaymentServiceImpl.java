package com.ingenico.payment.service.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ingenico.payment.domain.MerchantData;
import com.ingenico.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Override
	public int generateRandomNumber() {
		SecureRandom random = new SecureRandom();

		return random.nextInt(999999999);
	}

	@Override
	public Map<String, String> convertToStringToHashMap(String merchantData) {
		Map<String,String> data = new HashMap<>();
		Pattern p = Pattern.compile("[\\{\\}\\=\\, ]++");
		String[] split = p.split(merchantData);
		for ( int i=1; i+2 <= split.length; i+=2 ){
			data.put( split[i], split[i+1] );
		}
		return data;
	}

	@Override
	public String getHashData(Map<String, String> configData) {
		return configData.get("MerchantCode") + "|" + configData.get("transactionID")+ "|" + configData.get("amount")+ "|" + configData.get("accNo")+ "|" +
		 configData.get("custID")+ "|" + configData.get("mobNo")+ "|" + configData.get("email")+ "|" + configData.get("debitStartDate")+ "|" + configData.get("debitEndDate") 
		+ "|" + configData.get("maxAmount")+ "|" + configData.get("amountType")+ "|" + configData.get("frequency")+ "|" + configData.get("cardNumber")+ "|" +
		 configData.get("expMonth")+ "|" + configData.get("expYear")+ "|" + configData.get("cvvCode")+ "|" + configData.get("SALT");
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getHashObject(String hashValue, Map<String, String> configData) {
		String merchantData = configData.get("config_data");
		
		Map<String,String> merchantDataMap = convertToStringToHashMap(merchantData);
		JSONObject obj = new JSONObject();
		
		
		JSONObject consumerDataObj = new JSONObject();
		consumerDataObj.put("deviceId","WEBSH2");
		consumerDataObj.put("token", hashValue);
		consumerDataObj.put("returnUrl", configData.get("ReturnUrl"));
		consumerDataObj.put("paymentMode", merchantDataMap.get("paymentMode"));
		/*
		 * String[] paymentArray =
		 * merchantDataMap.get("paymentModeOrder").trim().split(",");
		 * consumerDataObj.put("paymentModeOrder",paymentArray );
		 */
		String checkOut = null;
		if(convertStringToBool(merchantDataMap.get("embedPaymentGatewayOnPage")))
				checkOut = "#ingenico_embeded_popup";
		else
			checkOut = "";				
				
		consumerDataObj.put("checkoutElement", checkOut);
		consumerDataObj.put("merchantLogoUrl", merchantDataMap.get("logoURL"));
		consumerDataObj.put("merchantId", configData.get("MerchantCode"));
		
		consumerDataObj.put("merchantMsg", merchantDataMap.get("merchantMessage"));
		consumerDataObj.put("disclaimerMsg", merchantDataMap.get("disclaimerMessage"));
		consumerDataObj.put("currency", configData.get("currency"));
		consumerDataObj.put("consumerId", configData.get("custID"));
		
		consumerDataObj.put("consumerMobileNo", configData.get("mobNo"));
		consumerDataObj.put("consumerEmailId", configData.get("email"));
		consumerDataObj.put("txnId", configData.get("transactionID"));
		
		
		JSONObject customStyleObj = new JSONObject();
		customStyleObj.put("PRIMARY_COLOR_CODE", merchantDataMap.get("primaryColor"));
		customStyleObj.put("SECONDARY_COLOR_CODE", merchantDataMap.get("secondaryColor"));
		customStyleObj.put("BUTTON_COLOR_CODE_1", merchantDataMap.get("buttonColor1"));
		customStyleObj.put("BUTTON_COLOR_CODE_2", merchantDataMap.get("buttonColor2"));
		
		
		JSONArray itemArray = new JSONArray();
		JSONObject itemDataObj = new JSONObject();
		itemDataObj.put("itemId", configData.get("scheme"));
		itemDataObj.put("amount", configData.get("amount"));
		itemDataObj.put("comAmt", "0");

		itemArray.add(itemDataObj);

		consumerDataObj.put("items", itemArray);
		consumerDataObj.put("customStyle", customStyleObj);
		
		
		
		obj.put("consumerData", consumerDataObj);
		
		JSONObject featureObj = new JSONObject();
		featureObj.put("showPGResponseMsg", true);
		featureObj.put("enableMerTxnDetails", true);
		featureObj.put("enableAbortResponse", false);
		featureObj.put("enableSI", false);
		featureObj.put("enableNewWindowFlow", convertStringToBool(merchantDataMap.get("enableNewWindowFlow")));
		featureObj.put("enableExpressPay", convertStringToBool(merchantDataMap.get("enableExpressPay")));
		featureObj.put("enableInstrumentDeRegistration", convertStringToBool(merchantDataMap.get("enableInstrumentDeRegistration")));
		featureObj.put("hideSavedInstruments", convertStringToBool(merchantDataMap.get("hideSavedInstruments")));
		featureObj.put("separateCardMode", convertStringToBool(merchantDataMap.get("separateCardMode")));
		featureObj.put("payWithSavedInstrument", convertStringToBool(merchantDataMap.get("saveInstrument")));
		
		//add feature to a object
		
		obj.put("features", featureObj);
		
		System.out.println("json object:"+obj);
			
		
		return obj;
	}

	@Override
	public String encryptedHash(String dataToHashed) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");

			byte[] messageDigest = md.digest(dataToHashed.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			return hashtext;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	 
	boolean convertStringToBool(String data) {

		return Boolean.valueOf(data);
		

	}

	@Override
	public String fetchApiResponse(String url, JSONObject obj) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<>(obj.toString(), headers);
		return restTemplate.postForObject(url, entity, String.class);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestFortranscation(String[] data, MerchantData merchantData) {

		JSONObject obj = new JSONObject();

		JSONObject identifierObj = new JSONObject();
		identifierObj.put("identifier", merchantData.getMerchantCode());

		obj.put("merchant", identifierObj);
		JSONObject deviceIdentifierObj = new JSONObject();
		deviceIdentifierObj.put("currency", merchantData.getCurrency());
		deviceIdentifierObj.put("dateTime", data[8]);
		deviceIdentifierObj.put("token", data[5]);
		deviceIdentifierObj.put("requestType", "S");

		obj.put("transaction", deviceIdentifierObj);

		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestForOfflineVerification(Map<String, String> configData, MerchantData merchantData) {
		JSONObject obj = new JSONObject();

		JSONObject identifierObj = new JSONObject();
		identifierObj.put("identifier", merchantData.getMerchantCode());
		obj.put("merchant", identifierObj);
		JSONObject deviceIdentifierObj = new JSONObject();
		deviceIdentifierObj.put("deviceIdentifier", "S");
		deviceIdentifierObj.put("currency", merchantData.getCurrency());
		deviceIdentifierObj.put("dateTime", configData.get("date"));
		deviceIdentifierObj.put("identifier", configData.get("merchantRefNo"));
		deviceIdentifierObj.put("requestType", "O");
		obj.put("transaction", deviceIdentifierObj);

		return obj;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject createRequestForRefund(Map<String, String> configData, MerchantData merchantData) {
		JSONObject obj = new JSONObject();

		JSONObject identifierObj = new JSONObject();
		identifierObj.put("identifier", merchantData.getMerchantCode());
		obj.put("merchant", identifierObj);
		JSONObject cartObject = new JSONObject();
		obj.put("cart", cartObject);
		JSONObject deviceIdentifierObj = new JSONObject();
		deviceIdentifierObj.put("deviceIdentifier", "S");
		deviceIdentifierObj.put("currency", merchantData.getCurrency());
		deviceIdentifierObj.put("amount", configData.get("amount"));
		deviceIdentifierObj.put("token", configData.get("token"));
		deviceIdentifierObj.put("dateTime", configData.get("date"));
		deviceIdentifierObj.put("requestType", "R");
		obj.put("transaction", deviceIdentifierObj);

		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
}
