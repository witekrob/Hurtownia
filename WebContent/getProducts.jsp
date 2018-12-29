<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista produktów</title>
</head>
<body bgcolor="lightBlue">
<jsp:include page ="WEB-INF/Header.jspf"></jsp:include>
<h1> Lista produktów</h1>
<%List<Product> lista = new ArrayList<Product>();
lista = (List)request.getAttribute("productsList"); %>

<table border="2">
<tr>
<th>Nazwa</th><th>Producent</th><th>NumerId</th><th>Cena</th><th>Ilość</th>
</tr>
<%Iterator<Product> prodIter = lista.iterator(); 
Product prod = new Product();
while (prodIter.hasNext()) {
	prod=prodIter.next();
%>

<tr> <td> <%= prod.getName()%></td>
	<td> <%= prod.getProducer()%></td>
	<td> <%= prod.getNumerId()%></td>
	<td> <%= prod.getPrice()%></td>
	<td> <%= prod.getQuantity()%></td>
	
	<%} %>
</tr>

</table>
</body>
</html>