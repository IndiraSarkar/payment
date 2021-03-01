<h1>Refund</h1>

<!DOCTYPE html>
<html>

<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<title>Refund Page</title>
	<style>
		table, td, th {
			border: 1px solid black;
		}

		table {
			border-collapse: collapse;
		}
	</style>
</head>

<body>
 <form action="s2s" method="post"> 
 
  <label for="Msg">Msg:</label>
	    <input type="text" id="msg" name="msg"  required=true />
	    <input type="submit" value="Submit">
     </form>
	     
  
<c:if test="${not empty response}">
<h3>${response}</h3>

</c:if>


</body>

</html>