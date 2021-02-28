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
					<input type="text" id="merchantCode" name="merchantCode" value="t3348" required=true/>
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
   						<option value="INR">INR</option>
   						<option value="USD">USD</option>
					</select> 
					<br><br>
				</td>
			</tr>

			<tr>
				<th>
					<label for="paymentType">Type of Payment</label>
				</th>
				<td>
					<select id="paymentType" name="paymentType">
   						<option value="TEST">TEST</option>
   						<option value="LIVE">LIVE</option>
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
					<input type="text" id="primaryColor" name="primaryColor" value="#000000" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="secondaryColor">Secondary Color</label>
				</th>
				<td>
					<input type="text" id="secondaryColor" name="secondaryColor"  value="#FFFFFF" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="buttonColor1">Button Color 1</label>
				</th>
				<td>
					<input type="text" id="buttonColor1" name="buttonColor1" value="#1969bb" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="buttonColor2">Button Color 2</label>
				</th>
				<td>
					<input type="text" id="buttonColor2" name="buttonColor2" value="#FFFFFF" required=true/>
					<br><br>
					Color value can be hex, rgb or actual color name
				</td>
			</tr>

			<tr>
				<th>
					<label for="logoUrl">logo URL</label>
				</th>
				<td>
					<input type="text" id="logoUrl" name="logoUrl" value="https://www.paynimo.com/CompanyDocs/company-logo-md.png" required=true/>
					<br><br>
					An absolute URL pointing to a logo image of merchant which will show on checkout popup
				</td>
			</tr>

			<tr>
				<th>
					<label for="expressway">Enable ExpressPay</label>
				</th>
				<td>
					<select id="expressway" name="expressway">
   						<option value="Disabled">Disabled</option>
   						<option value="Enabled">Enabled</option>
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
   						<option value="Disabled">Disabled</option>
   						<option value="Enabled">Enabled</option>
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
					<select id="newWindowFlow" name="newWindowFlow">
   						<option value="Disabled">Disabled</option>
   						<option value="Enabled">Enabled</option>
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
					<input type="text" id="merchantMessage" name="merchantMessage" />
					<br><br>
					Customize message from merchant which will be shown to customer in checkout page
				</td>
			</tr>

			<tr>
				<th>
					<label for="dislaimerMessage">Disclaimer Message</label>
				</th>
				<td>
					<input type="text" id="dislaimerMessage" name="dislaimerMessage" />
					<br><br>
					Customize disclaimer message from merchant which will be shown to customer in checkout page
				</td>
			</tr>

			<tr>
				<th>
					<label for="paymentMode">Disclaimer Message</label>
				</th>
				<td>
					<select id="paymentMode" name="paymentMode">
   						<option value="all">all</option>
   						<option value="cards">cards</option>
   						<option value="netBanking">netBanking</option>
   						<option value="UPI">UPI</option>
   						<option value="imps">imps</option>
   						<option value="wallets">wallets</option>
   						<option value="cashCards">cashCards</option>
   						<option value="NEFTRTGS">NEFTRTGS</option>
   						<option value="emiBanks">emiBanks</option>
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
					<textarea id="paymentModeOrder" name="paymentModeOrder" required=true style="margin: 0px; width: 576px; height: 36px;">cards,wallets,netBanking,imps,cashCards,UPI,MVISA,debitPin,NEFTRTGS,emiBanks</textarea>
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
					<select id="instrumentDeregistration" name="instrumentDeregistration">
   						<option value="Disabled">Disabled</option>
   						<option value="Enabled">Enabled</option>
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
					<select id="hideSaveInstruments" name="hideSaveInstruments">
   						<option value="Disabled">Disabled</option>
   						<option value="Enabled">Enabled</option>
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
   						<option value="Disabled">Disabled</option>
   						<option value="Enabled">Enabled</option>
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
					<select id="displayTransactionMsg" name="displayTransactionMsg">
   						<option value="Disabled">Disabled</option>
   						<option value="Enabled">Enabled</option>
					</select>
				</td>
			</tr>

			<tr>
				<th>
					<label for="embeddedPaymentGateway">Embed Payment Gateway On Page</label>
				</th>
				<td>
					<select id="embeddedPaymentGateway" name="embeddedPaymentGateway">
   						<option value="Disabled">Disabled</option>
   						<option value="Enabled">Enabled</option>
					</select>
				</td>
			</tr>

		</table>
		<div><input type="submit" value="Submit"></div>
	</form>

</body>
</html>




