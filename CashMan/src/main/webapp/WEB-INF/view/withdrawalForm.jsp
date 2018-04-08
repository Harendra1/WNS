<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cash Withdrawal</title>
<style>
.cb{
    color:#DF0101
}
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
</style>
</head>
<body>

<div 
		style="position: absolute; overflow: auto; left: 10%; margin-left: 225px; width: 700px; height: 350px; background: grey; border: 8px solid black">


		<br><b>WithDraw Cash</b><br>
		<br><b>${mesage}</b>
	<br><hr>
	<form:form action="statement" method="post" modelAttribute="withdrawal">

		Please enter your Card Number   <tab2></tab2>   <form:input path="cardNumber"
			placeholder="card number" />
			<form:errors path="cardNumber" cssClass="cb"/><br>
		<br>
		Please enter amount for withdrawal <form:input path="withdrawalAmount"
			placeholder="Amount" />
						<form:errors path="withdrawalAmount" cssClass="cb"/><br>
			<br>
	<input type="submit" value="Submit" onclick="javascript: form.action='statement';"/>
	<input type="submit" value="Exit" onclick="javascript: form.action='login';form.method='get';"/>
	</form:form>
		<hr>
	</div>

</body>
</html>