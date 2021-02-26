package com.ingenico.payment.domain;

import java.io.Serializable;

public class MerchantData implements Serializable{
	
	 private String utf8;
	 private String authenticityToken; 
	 private String merchantCode;
	 private String merchantSchemeCode;
	 private String salt;
	 private String currency;
	 private String typeOfPayment;
	 private String primaryColor;
	 private String secondaryColor;
	 private String buttonColor1;
	 private String buttonColor2;
	 private String logoURL;
	 private String enableExpressPay;
	 private String separateCardMode;
	 private String enableNewWindowFlow;
	 private String merchantMessage;
	 private String disclaimerMessage;
	 private String paymentMode;
	 private String paymentModeOrder;
	 private String enableInstrumentDeRegistration;
	 private String transactionType;
	 private String hideSavedInstruments;
	 private String saveInstrument;
	 private String displayTransactionMessageOnPopup;
	 private String embedPaymentGatewayOnPage;
	 private String commit;
	 private String controller;
	 private String action;
	 
	 
	public MerchantData(String utf8, String authenticityToken, String merchantCode, String merchantSchemeCode,
			String salt, String currency, String typeOfPayment, String primaryColor, String secondaryColor,
			String buttonColor1, String buttonColor2, String logoURL, String enableExpressPay, String separateCardMode,
			String enableNewWindowFlow, String merchantMessage, String disclaimerMessage, String paymentModeall,
			String paymentModeOrder, String enableInstrumentDeRegistration, String transactionType,
			String hideSavedInstruments, String saveInstrument, String displayTransactionMessageOnPopup,
			String embedPaymentGatewayOnPage, String commit, String controller, String action, String paymentMode) {
		super();
		this.utf8 = utf8;
		this.authenticityToken = authenticityToken;
		this.merchantCode = merchantCode;
		this.merchantSchemeCode = merchantSchemeCode;
		this.salt = salt;
		this.currency = currency;
		this.typeOfPayment = typeOfPayment;
		this.primaryColor = primaryColor;
		this.secondaryColor = secondaryColor;
		this.buttonColor1 = buttonColor1;
		this.buttonColor2 = buttonColor2;
		this.logoURL = logoURL;
		this.enableExpressPay = enableExpressPay;
		this.separateCardMode = separateCardMode;
		this.enableNewWindowFlow = enableNewWindowFlow;
		this.merchantMessage = merchantMessage;
		this.disclaimerMessage = disclaimerMessage;
		this.paymentMode = paymentMode;
		this.paymentModeOrder = paymentModeOrder;
		this.enableInstrumentDeRegistration = enableInstrumentDeRegistration;
		this.transactionType = transactionType;
		this.hideSavedInstruments = hideSavedInstruments;
		this.saveInstrument = saveInstrument;
		this.displayTransactionMessageOnPopup = displayTransactionMessageOnPopup;
		this.embedPaymentGatewayOnPage = embedPaymentGatewayOnPage;
		this.commit = commit;
		this.controller = controller;
		this.action = action;
	}
	public String getUtf8() {
		return utf8;
	}
	public void setUtf8(String utf8) {
		this.utf8 = utf8;
	}
	
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getMerchantSchemeCode() {
		return merchantSchemeCode;
	}
	public void setMerchantSchemeCode(String merchantSchemeCode) {
		this.merchantSchemeCode = merchantSchemeCode;
	}
	public String getAuthenticityToken() {
		return authenticityToken;
	}
	public void setAuthenticityToken(String authenticityToken) {
		this.authenticityToken = authenticityToken;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTypeOfPayment() {
		return typeOfPayment;
	}
	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}
	public String getPrimaryColor() {
		return primaryColor;
	}
	public void setPrimaryColor(String primaryColor) {
		this.primaryColor = primaryColor;
	}
	public String getSecondaryColor() {
		return secondaryColor;
	}
	public void setSecondaryColor(String secondaryColor) {
		this.secondaryColor = secondaryColor;
	}
	public String getButtonColor1() {
		return buttonColor1;
	}
	public void setButtonColor1(String buttonColor1) {
		this.buttonColor1 = buttonColor1;
	}
	public String getButtonColor2() {
		return buttonColor2;
	}
	public void setButtonColor2(String buttonColor2) {
		this.buttonColor2 = buttonColor2;
	}
	public String getLogoURL() {
		return logoURL;
	}
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	public String getEnableExpressPay() {
		return enableExpressPay;
	}
	public void setEnableExpressPay(String enableExpressPay) {
		this.enableExpressPay = enableExpressPay;
	}
	public String getSeparateCardMode() {
		return separateCardMode;
	}
	public void setSeparateCardMode(String separateCardMode) {
		this.separateCardMode = separateCardMode;
	}
	public String getEnableNewWindowFlow() {
		return enableNewWindowFlow;
	}
	public void setEnableNewWindowFlow(String enableNewWindowFlow) {
		this.enableNewWindowFlow = enableNewWindowFlow;
	}
	public String getMerchantMessage() {
		return merchantMessage;
	}
	public void setMerchantMessage(String merchantMessage) {
		this.merchantMessage = merchantMessage;
	}
	public String getDisclaimerMessage() {
		return disclaimerMessage;
	}
	public void setDisclaimerMessage(String disclaimerMessage) {
		this.disclaimerMessage = disclaimerMessage;
	}
	
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentModeOrder() {
		return paymentModeOrder;
	}
	public void setPaymentModeOrder(String paymentModeOrder) {
		this.paymentModeOrder = paymentModeOrder;
	}
	public String getEnableInstrumentDeRegistration() {
		return enableInstrumentDeRegistration;
	}
	public void setEnableInstrumentDeRegistration(String enableInstrumentDeRegistration) {
		this.enableInstrumentDeRegistration = enableInstrumentDeRegistration;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getHideSavedInstruments() {
		return hideSavedInstruments;
	}
	public void setHideSavedInstruments(String hideSavedInstruments) {
		this.hideSavedInstruments = hideSavedInstruments;
	}
	public String getSaveInstrument() {
		return saveInstrument;
	}
	public void setSaveInstrument(String saveInstrument) {
		this.saveInstrument = saveInstrument;
	}
	public String getDisplayTransactionMessageOnPopup() {
		return displayTransactionMessageOnPopup;
	}
	public void setDisplayTransactionMessageOnPopup(String displayTransactionMessageOnPopup) {
		this.displayTransactionMessageOnPopup = displayTransactionMessageOnPopup;
	}
	public String getEmbedPaymentGatewayOnPage() {
		return embedPaymentGatewayOnPage;
	}
	public void setEmbedPaymentGatewayOnPage(String embedPaymentGatewayOnPage) {
		this.embedPaymentGatewayOnPage = embedPaymentGatewayOnPage;
	}
	public String getCommit() {
		return commit;
	}
	public void setCommit(String commit) {
		this.commit = commit;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "{utf8=" + utf8 + ", authenticityToken=" + authenticityToken + ", merchantCode="
				+ merchantCode + ", merchantSchemeCode=" + merchantSchemeCode + ", salt=" + salt + ", currency="
				+ currency + ", typeOfPayment=" + typeOfPayment + ", primaryColor=" + primaryColor + ", secondaryColor="
				+ secondaryColor + ", buttonColor1=" + buttonColor1 + ", buttonColor2=" + buttonColor2 + ", logoURL="
				+ logoURL + ", enableExpressPay=" + enableExpressPay + ", separateCardMode=" + separateCardMode
				+ ", enableNewWindowFlow=" + enableNewWindowFlow + ", merchantMessage=" + merchantMessage
				+ ", disclaimerMessage=" + disclaimerMessage + ", paymentMode=" + paymentMode + ", paymentModeOrder="
				+ paymentModeOrder + ", enableInstrumentDeRegistration=" + enableInstrumentDeRegistration
				+ ", transactionType=" + transactionType + ", hideSavedInstruments=" + hideSavedInstruments
				+ ", saveInstrument=" + saveInstrument + ", displayTransactionMessageOnPopup="
				+ displayTransactionMessageOnPopup + ", embedPaymentGatewayOnPage=" + embedPaymentGatewayOnPage
				+ ", commit=" + commit + ", controller=" + controller + ", action=" + action + "}";
	}
	 
	
	 
	 
	 

}
