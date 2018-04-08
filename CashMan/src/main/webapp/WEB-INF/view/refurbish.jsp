<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<spring:url value="/atm.css" var="atmCSS" />
<link href="${atmCSS}" rel="stylesheet" />

<title>Refurbish Cash</title>
<style>
.cb {
	color: #DF0101
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

tab1 {
	padding-left: 4.5em;
}

tab2 {
	padding-left: 1.5em;
}

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
		style="position: absolute; overflow: auto; left: 10%; margin-left: 225px; width: 700px; height: 250px; height: auto; background: grey; border: 8px solid black">



		<br>
		<b>Transaction Details</b><br>
		<hr>

		<b>Total Cash in ATM --> ${cashStatus.sum}</b><br>
		<hr>
		


		<form:form name="form" modelAttribute="deposit">
Enter Denomination value <tab2></tab2>
			<form:input path="denomination" placeholder="denomination"
				cssClass="cinput" />
			<form:errors path="denomination" cssClass="cb" />
			<br>
Enter Count of denomination <tab2></tab2>
			<form:input path="count" placeholder="count" cssClass="cinput" />
			<form:errors path="count" cssClass="cb" />
			<br>
			<input type="submit" value="Exit"
				onclick="javascript: form.action='login';form.method='get';"
				class="csubmit" //>
			<input type="submit" value="Add Cash"
				onclick="javascript: form.action='refurbish';form.method='post';"
				class="csubmit" //>
			<input type="submit" value="Initialize"
				onclick="javascript: form.action='initialize';form.method='post';"
				class="csubmit" //>
		</form:form>

	</div>

</body>
</html>