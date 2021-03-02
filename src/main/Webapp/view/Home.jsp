<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script
	src="https://www.paynimo.com/paynimocheckout/client/lib/jquery.min.js"
	type="text/javascript"></script>
<script
	src='https://www.paynimo.com/Paynimocheckout/server/lib/checkout.js'
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/onlinetransactionhandler.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/checkout.js"></script>	
	
	
<title>Insert title here</title>
</head>
<body>
  
  <h1>Online Transaction</h1>
	<form id ="form" class = "form">
		<table border="1" cellpadding="2" cellspacing="0">
			<tr>
				<td> <label for="Merchant Code">Merchant Code</label> </td>
				<td> <input type="text" id="MerchantCode" name="MerchantCode" value="${config_data.merchantCode}"><br></td>

			</tr>

			<tr>
				<td> <label for="Transaction ID">Transaction ID</label></td>
				<td><input type="text" id="Transaction ID" name="transactionID" value="${transcationId}"></td>
				
			</tr>

			<tr>
				<td> <label for="Amount">Amount</label></td>
				<td><input type="text" id="Amount" name="amount"></td>
			</tr>

			<tr>
				<td> <label for="Scheme">Scheme</label></td>
				<td><input type="text" id="scheme" name="scheme" value="${config_data.merchantSchemeCode}"></td>
				
			</tr>

			<tr>
				<td> <label for="CustomerID">Customer ID</label></td>
				<td><input type="text" id="custID" name="custID"></td>
				
			</tr>

			<tr>
				<td> <label for="Mobile Number">Mobile Number</label> </td>
				<td><input type="text" id="mobNo" name="mobNo"></td>
				
			</tr>

			<tr>
				<td> <label for="Email">Email</label> </td>
				<td><input type="email" id="email" name="email"></td>
				

			<tr>
				<td> <label for="Customer Name">Customer Name</label>  </td>
				<td><input type="text" id="name" name="name"></td>
			</tr>

			<tr>
				<td> <label for="Currency">Currency</label> </td>
				<td><input type="text" id="currency" name="currency" value="${config_data.currency}"></td>
				
			</tr>

			<tr>
				<td> <label for="SALT">SALT</label></td>
				<td><input type="text" id="SALT" name="SALT" value="${config_data.salt}" ></td>
				
			</tr>

			<tr>
				<td> <label for="ReturnUrl">Return Url</label> </td>
				<td><input type="text" id="ReturnUrl" name="ReturnUrl" value="${returnUrl}"></td>
			</tr>
			</table>
			<input type="hidden" id="accNo" name="accNo" />
			<input type="hidden" id="debitStartDate" name="debitStartDate" >
			<input type="hidden" id="debitEndDate" name="debitEndDate" >
			<input type="hidden" id="maxAmount" name="maxAmount" >
			<input type="hidden" id="amountType" name="amountType" >
			<input type="hidden" id="frequency" name="frequency" >
			<input type="hidden" id="cardNumber" name="cardNumber" >
			<input type="hidden" id="expMonth" name="expMonth" >
			<input type="hidden" id="expYear" name="expYear" >
			<input type="hidden" id="cvvCode" name="cvvCode" >
			<input type="hidden" id="expYear" name="expYear" >
			<input type="hidden" id="config_data" name="config_data" value="${config_data}">
			
			
		
		  <div><button id="btnSubmit">Submit</button>
			</div>
		 <div id="ingenico_embeded_popup"></div>	
			
		</form>
		

</body>
</html>