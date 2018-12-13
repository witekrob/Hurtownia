<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ page import = "model.Product " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wynik dodawania nowego produktu</title>
</head>
<body>
<h1> Wynik dodawania nowego produktu</h1>
<%String result = (String)request.getAttribute("actionResult"); 
Product prod = (Product)request.getAttribute("product");

%>
<%=result %>
<br>
<%=prod.toString() %>
</body>
</html>