<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Product, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rezultat szukania</title>
</head>
<body>
	<h1>rezultat szukania</h1>
	<%
		List<Product> productList = (List<Product>) request.getAttribute("productFound");
		Iterator<Product> prodIter = productList.iterator();
		while (prodIter.hasNext()) {
			Product prod = prodIter.next();
	%>
	<%=prod%>
<br>

	<%
		}
	%>
</body>
</html>