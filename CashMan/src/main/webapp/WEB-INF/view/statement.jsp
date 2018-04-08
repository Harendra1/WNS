<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Transaction statement</title>
<style>
input[type=text] {
	padding: 8px;
	margin: 8px;
	font-size: 15px
}

input[type=submit] {
	border: none;
	background-color: #4CAF50;
	color: white;
	padding: 8px;
	margin: 8px;
	cursor: pointer;
	font-size: 15px
}
tab1 { padding-left: 4.5em; }
tab2{padding-left: 1.5em;}
h1 {
	color: #08298A;
	text-align: center
}
h2 {
	color: #08298A;
	text-align: center
}
tab1 { padding-left: 4.5em; }
</style>
</head>
<body>

<div 
		style="position: absolute; overflow: auto; left: 10%; margin-left: 225px; width: 500px; height: 250px; height: auto; background: grey; border: 8px solid black">



		<br><b>Transaction Details</b><br>
		<hr>
		<b>Card Number --> ${transaction.cardNumber}</b><br>
		<b>Total Withdrawal Amount --> ${transaction.totalAmount}</b><br>

		<hr>


	<table>	
		<b>Denomination --> Count of Notes</b><br>
			<c:forEach items="${transaction.notes}" var="currency">
				<tr>
					<td>${currency.denomination}   <tab1>--></tab1> <tab1>    ${currency.count}</tab1></td>
				</tr>
			</c:forEach>
		</table>
<form method="get" name="form">
<input type="submit" value="Exit" onclick="javascript: form.action='login';"/>
<input type="submit" value="Withdrawal More" onclick="javascript: form.action='withdraw';"/>
</form>
		
	</div>
</body>
</html>