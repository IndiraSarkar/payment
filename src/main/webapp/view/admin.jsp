<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Ingenico Admin</title>
	<style >
		table, td, th {
 			border: 1px solid black;
		}
		table {
			width: 100%;
  			border-collapse: collapse;
		}
		#success{
			font: 15px Arial, sans-serif;
			color: green;
    		background:lightgreen;
  			padding: 25px;
		}
		#error{
			font: 15px Arial, sans-serif;
			color: darkred;
    		background:salmon;
  			padding: 25px;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
  		/* $("button").click(function(){ */
    		$("#success").fadeIn().delay(1000).fadeOut('slow');
    		$("#error").fadeIn().delay(1000).fadeOut('slow');
  		/* 	}); */
		});
	</script>
</head>

<body>

<c:if test="${not empty response}">
	<div id ="success">
   		${response}
  	</div>
</c:if>
<c:if test="${not empty error}">
	<div id ="error">
   		${error}
  	</div>
</c:if>


	<h2>Ingenico Admin</h2>
	<%-- <%= form_for 'payment/admin' do %> --%>
	<form action="admin" method="post" >
		<table  cellpadding="10" cellspacing="10">
			<tr>
				<th>
					<label for="description">Description</label>
				</th>
				<td>
					Ingenico ePayments (a Worldline brand) is India's leading digital payment solutions company. Being a company with more than 45 years of global payment experience, we are present in India for over 20 years and are powering over 550,000 businesses with our tailored payment solution. 
				</td>
			</tr>

			<tr>
				<th>
					<label for="merchantCode">Merchant Code</label>
				</th>
				<td>
					<input type="text" id="merchantCode" name="merchantCode" value="${merchantData.merchantCode}" required=true/>
				</td>
			</tr>

			<tr>
				<th>
					<label for="merchantSchemeCode">Merchant Scheme Code</label>
				</th>
				<td>
					<input type="text" id="merchantSchemeCode" name="merchantSchemeCode" value="test" required=true/>
				</td>
			</tr>

			<tr>
				<th>
					<label for="salt">S.A.L.T</label>
				</th>
				<td>
					<input type="text" id="salt" name="salt" value="1496899267KMOWJE" required=true/>
				</td>
			</tr>

			<tr>
				<th>
					<label for="currency">Currency</label>
				</th>
				<td>
					<select id="currency" name="currency">
   						<option value="INR" ${merchantData.currency =='INR'? 'selected="true"' : '' }>INR</option>
   						<option value="USD" ${merchantData.currency =='USD'? 'selected="true"' : '' }>USD</option>
   						<%-- <c:forEach var="currency" items="${currency}">
        					<option value="${item.key}" ${item.key == selectedDept ? 'selected="selected"' : ''}>${item.value}</option>
    					</c:forEach> --%>
					</select> 
					<br><br>
				</td>
			</tr>

			<tr>
				<th>
					<label for="paymentType">Type of Payment</label>
				</th>
				<td>
					<select id="paymentType" name="typeOfPayment">
   						<option value="TEST"${merchantData.typeOfPayment =='TEST'? 'selected="true"' : '' }>TEST</option>
   						<option value="LIVE"${merchantData.typeOfPayment =='LIVE'? 'selected="true"' : '' }>LIVE</option>
					</select> 
					<br><br>
					For TEST mode amount will be charge 1
				</td>
			</tr>

			<tr>
				<th>
					<label for="primaryColor">Primary Color</label>
				</th>
				<td>
					<input type="text" id="primaryColor" name="primaryColor" value="${merchantData.primaryColor}" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="secondaryColor">Secondary Color</label>
				</th>
				<td>
					<input type="text" id="secondaryColor" name="secondaryColor"  value="${merchantData.secondaryColor}" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="buttonColor1">Button Color 1</label>
				</th>
				<td>
					<input type="text" id="buttonColor1" name="buttonColor1" value="${merchantData.buttonColor1}" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="buttonColor2">Button Color 2</label>
				</th>
				<td>
					<input type="text" id="buttonColor2" name="buttonColor2" value="${merchantData.buttonColor2}" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="logoUrl">logo URL</label>
				</th>
				<td>
					<input type="text" id="logoUrl" name="logoURL" value="${merchantData.logoURL}" required=true/>
					<br><br>
					An absolute URL pointing to a logo image of merchant which will show on checkout popup
				</td>
			</tr>

			<tr>
				<th>
					<label for="expressway">Enable ExpressPay</label>
				</th>
				<td>
					<select id="expressway" name="enableExpressPay">
   						<option value="false"${merchantData.enableExpressPay ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.enableExpressPay ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					To enable saved payments set its value to yes
				</td>
			</tr>

			<tr>
				<th>
					<label for="separateCardMode">Separate Card Mode</label>
				</th>
				<td>
					<select id="separateCardMode" name="separateCardMode">
   						<option value="false"${merchantData.separateCardMode ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.separateCardMode ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					If this feature is enabled checkout shows two separate payment mode(Credit Card and Debit Card)
				</td>
			</tr>

			<tr>
				<th>
					<label for="newWindowFlow">Enable New Window Flow</label>
				</th>
				<td>
					<select id="newWindowFlow" name="enableNewWindowFlow">
   						<option value="false"${merchantData.enableNewWindowFlow ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.enableNewWindowFlow ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					If this feature is enabled, then bank page will open in new window
				</td>
			</tr>

			<tr>
				<th>
					<label for="merchantMessage">Merchant Message</label>
				</th>
				<td>
					<input type="text" id="merchantMessage" name="merchantMessage"  value="${merchantData.merchantMessage}"/>
					<br><br>
					Customize message from merchant which will be shown to customer in checkout page
				</td>
			</tr>

			<tr>
				<th>
					<label for="dislaimerMessage">Disclaimer Message</label>
				</th>
				<td>
					<input type="text" id="dislaimerMessage" name="disclaimerMessage" value="${merchantData.disclaimerMessage}"/>
					<br><br>
					Customize disclaimer message from merchant which will be shown to customer in checkout page
				</td>
			</tr>

			<tr>
				<th>
					<label for="paymentMode">Payment Mode</label>
				</th>
				<td>
					<select id="paymentMode" name="paymentMode">
   						<option value="all"${merchantData.paymentMode =='all'? 'selected="true"' : '' }>all</option>
   						<option value="cards"${merchantData.paymentMode =='cards'? 'selected="true"' : '' }>cards</option>
   						<option value="netBanking"${merchantData.paymentMode =='netBanking'? 'selected="true"' : '' }>netBanking</option>
   						<option value="UPI"${merchantData.paymentMode =='UPI'? 'selected="true"' : '' }>UPI</option>
   						<option value="imps"${merchantData.paymentMode =='imps'? 'selected="true"' : '' }>imps</option>
   						<option value="wallets"${merchantData.paymentMode =='wallets'? 'selected="true"' : '' }>wallets</option>
   						<option value="cashCards"${merchantData.paymentMode =='cashCards'? 'selected="true"' : '' }>cashCards</option>
   						<option value="NEFTRTGS"${merchantData.paymentMode =='NEFTRTGS'? 'selected="true"' : '' }>NEFTRTGS</option>
   						<option value="emiBanks"${merchantData.paymentMode =='emiBanks'? 'selected="true"' : '' }>emiBanks</option>
					</select>
					<br><br>
					If Bank selection is at Ingenico ePayments India Pvt. Ltd. (a Worldline brand) end then select all, if bank selection at Merchant end then pass appropriate mode respective to selected option
				</td>
			</tr>

			<tr>
				<th>
					<label for="paymentModeOrder">Payment Mode Order</label>
				</th>
				<td>
					<textarea id="paymentModeOrder" name="paymentModeOrder" required=true style="margin: 0px; width: 576px; height: 36px;">${merchantData.paymentModeOrder}</textarea>
					<br><br>
					Please pass order in this format: cards,netBanking,imps,wallets,cashCards,UPI,MVISA,debitPin,NEFTRTGS,emiBanks.
       				Merchant can define their payment mode order
				</td>
			</tr>

			<tr>
				<th>
					<label for="instrumentDeregistration">Enable Instrument De-Registration</label>
				</th>
				<td>
					<select id="instrumentDeregistration" name="enableInstrumentDeRegistration">
   						<option value="false"${merchantData.enableInstrumentDeRegistration ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.enableInstrumentDeRegistration ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					If this feature is enabled, you will have an option to delete saved cards
				</td>
			</tr>

			<tr>
				<th>
					<label for="transactionType">Transaction Type</label>
				</th>
				<td>
					<select id="transactionType" name="transactionType">
   						<option value="SALE">SALE</option>
					</select>
				</td>
			</tr>

			<tr>
				<th>
					<label for="hideSaveInstruments">Hide SavedInstruments</label>
				</th>
				<td>
					<select id="hideSaveInstruments" name="hideSavedInstruments">
   						<option value="false"${merchantData.hideSavedInstruments ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.hideSavedInstruments ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					If enabled checkout hides saved payment options even in case of enableExpressPay is enabled
				</td>
			</tr>

			<tr>
				<th>
					<label for="saveInstrument">Save Instrument</label>
				</th>
				<td>
					<select id="saveInstrument" name="saveInstrument">
   						<option value="false"${merchantData.saveInstrument ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.saveInstrument ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
					<br><br>
					Enable this feature to vault instrumen
				</td>
			</tr>

			<tr>
				<th>
					<label for="displayTransactionMsg">Display Transaction Message on Popup</label>
				</th>
				<td>
					<select id="displayTransactionMsg" name="displayTransactionMessageOnPopup">
   						<option value="false"${merchantData.displayTransactionMessageOnPopup ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.displayTransactionMessageOnPopup ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
				</td>
			</tr>

			<tr>
				<th>
					<label for="embeddedPaymentGateway">Embed Payment Gateway On Page</label>
				</th>
				<td>
					<select id="embeddedPaymentGateway" name="embedPaymentGatewayOnPage">
   						<option value="false"${merchantData.embedPaymentGatewayOnPage ==false? 'selected="true"' : '' }>Disabled</option>
   						<option value="true"${merchantData.embedPaymentGatewayOnPage ==true? 'selected="true"' : '' }>Enabled</option>
					</select>
				</td>
			</tr>
			

		</table>
		<div><input type="submit" value="Submit"></div>
	</form>

</body>
</html>




