package com.ingenico.payment.domain;

public class AdminPage {
	
	private String merchantCode;//t3348
	private String merchantSchemeCode; //item id  test
	private String salt; //SHA-152 1496899267KMOWJE
	private String currency;
	private String paymentType;
	private String primaryColor; //#000000
	private String secondaryColor; //#FFFFFF
	private String buttonColor1; //#1969bb
	private String buttonColor2; //#FFFFFF
	private String logoUrl; //https://www.paynimo.com/CompanyDocs/company-logo-md.png
	private String expressway; //disable,enable
	private String separateCardMode; //disable,enable
	private String newWindowFlow; //disable,enable
	private String merchantMessage;
	private String dislaimerMessage;
	private String paymentMode; //cards,wallets,netBanking,imps,cashCards,UPI,MVISA,debitPin,NEFTRTGS,emiBanks
	private String paymentModeOrder;
	private String instrumentDeregistration; //disable,enable
	private String transactionType;
	private String hideSaveInstruments; //disable,enable
	private String saveInstrument; //disable,enable
	private String displayTransactionMsg; //disable,enable
	private String embeddedPaymentGateway; //disable,enable
	private String enableSi;
	
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
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
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
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getExpressway() {
		return expressway;
	}
	public void setExpressway(String expressway) {
		this.expressway = expressway;
	}
	public String getSeparateCardMode() {
		return separateCardMode;
	}
	public void setSeparateCardMode(String separateCardMode) {
		this.separateCardMode = separateCardMode;
	}
	public String getNewWindowFlow() {
		return newWindowFlow;
	}
	public void setNewWindowFlow(String newWindowFlow) {
		this.newWindowFlow = newWindowFlow;
	}
	public String getMerchantMessage() {
		return merchantMessage;
	}
	public void setMerchantMessage(String merchantMessage) {
		this.merchantMessage = merchantMessage;
	}
	public String getDislaimerMessage() {
		return dislaimerMessage;
	}
	public void setDislaimerMessage(String dislaimerMessage) {
		this.dislaimerMessage = dislaimerMessage;
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
	public String getInstrumentDeregistration() {
		return instrumentDeregistration;
	}
	public void setInstrumentDeregistration(String instrumentDeregistration) {
		this.instrumentDeregistration = instrumentDeregistration;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getHideSaveInstruments() {
		return hideSaveInstruments;
	}
	public void setHideSaveInstruments(String hideSaveInstruments) {
		this.hideSaveInstruments = hideSaveInstruments;
	}
	public String getSaveInstrument() {
		return saveInstrument;
	}
	public void setSaveInstrument(String saveInstrument) {
		this.saveInstrument = saveInstrument;
	}
	public String getDisplayTransactionMsg() {
		return displayTransactionMsg;
	}
	public void setDisplayTransactionMsg(String displayTransactionMsg) {
		this.displayTransactionMsg = displayTransactionMsg;
	}
	public String getEmbeddedPaymentGateway() {
		return embeddedPaymentGateway;
	}
	public void setEmbeddedPaymentGateway(String embeddedPaymentGateway) {
		this.embeddedPaymentGateway = embeddedPaymentGateway;
	}
	public String getEnableSi() {
		return enableSi;
	}
	public void setEnableSi(String enableSi) {
		this.enableSi = enableSi;
	}
	@Override
	public String toString() {
		return "AdminPage [merchantCode=" + merchantCode + ", merchantSchemeCode=" + merchantSchemeCode + ", salt="
				+ salt + ", currency=" + currency + ", paymentType=" + paymentType + ", primaryColor=" + primaryColor
				+ ", secondaryColor=" + secondaryColor + ", buttonColor1=" + buttonColor1 + ", buttonColor2="
				+ buttonColor2 + ", logoUrl=" + logoUrl + ", expressway=" + expressway + ", separateCardMode="
				+ separateCardMode + ", newWindowFlow=" + newWindowFlow + ", merchantMessage=" + merchantMessage
				+ ", dislaimerMessage=" + dislaimerMessage + ", paymentMode=" + paymentMode + ", paymentModeOrder="
				+ paymentModeOrder + ", instrumentDeregistration=" + instrumentDeregistration + ", transactionType="
				+ transactionType + ", hideSaveInstruments=" + hideSaveInstruments + ", saveInstrument="
				+ saveInstrument + ", displayTransactionMsg=" + displayTransactionMsg + ", embeddedPaymentGateway="
				+ embeddedPaymentGateway + ", enableSi=" + enableSi + "]";
	}

	
	
	
	
	
	

}
