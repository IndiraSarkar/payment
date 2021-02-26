package com.ingenico.payment.service.impl;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingenico.payment.domain.AdminPage;
import com.ingenico.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Override
	public String saveAdmin(AdminPage adminPageDetails) {
		
        // Creating Object of ObjectMapper define in Jakson Api
        ObjectMapper objectMapper = new ObjectMapper();
        FileWriter file = null;
        try {
 
            // get Oraganisation object as a json string
            String jsonStr = objectMapper.writeValueAsString(adminPageDetails);
 
            // Displaying JSON String
            System.out.println(jsonStr);
            
             file = new FileWriter("F:/workspace For Java/payment/src/main/json/admin.json");
	         file.write(jsonStr);
	         
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	if(file!=null) {
        		try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
		}
	      
		return null;
	}
	
}
