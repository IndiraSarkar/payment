package com.ingenico.payment.service;

import com.ingenico.payment.domain.AdminPage;
	
import java.util.Map;

import org.json.simple.JSONObject;

import com.ingenico.payment.domain.MerchantData;

public interface PaymentService {
	
	String saveAdmin(AdminPage admin);
	
	int generateRandomNumber();
	
	Map <String,String> convertToStringToHashMap(String merchantData);
	
	String getHashData(Map<String,String> configData);
	
	String encryptedHash(String dataToHashed);
	
	JSONObject getHashObject(String hashValue,Map<String,String> configData);
	
	String fetchApiResponse(String url,JSONObject obj);
	
	JSONObject createRequestFortranscation(String[]data,MerchantData merchantData);
	
	JSONObject createRequestForOfflineVerification(Map<String,String> configData,MerchantData merchantData);

	JSONObject createRequestForRefund(Map<String, String> configData, MerchantData merchantData);

}
