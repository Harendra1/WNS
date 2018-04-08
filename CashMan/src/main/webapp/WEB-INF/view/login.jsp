<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
input[type=radio] {
	padding: 20px;
	margin: 20px;
	font-size: 20px
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

h1, h2 {
	color: #08298A;
	text-align: center
}
</style>

</head>
<body>


	Welcome to the ATM Machine
	</br>
<div 
		style="position: absolute; overflow: auto; left: 10%; margin-left: 225px; width: 500px; height: 250px; height: auto; background: grey; border: 8px solid black">


		<h2>Please select one of the options</h2>

<form action="present" method="get">
<input type="submit" name="Refurbish Cash" value="Refurbish Cash">
</form>

<form action="withdraw" method="get">
<input type="submit" name="Cash Withdrawal" value="Cash Withdrawal">
</form>

	</div>

</body>
</html>