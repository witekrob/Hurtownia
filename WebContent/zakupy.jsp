<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "model.*, controller.*, servlets.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="WEB-INF/Header.jspf"></jsp:include>
<title>koszyk zakupowy</title>
</head>
<body>

<br>
<%List<CartItem> cart = (List<CartItem>) session.getAttribute("lista");
int overallPrice=0;
if (session.getAttribute("overallPrice")!=null) {
	 overallPrice =(int) session.getAttribute("overallPrice");
}
else{
	session.setAttribute("overallPrice",overallPrice);
}

%>
<br>
 <h1> wpisz swoje zamówienie</h1>

<form action="ShoppingCart" method="post">
nazwa produktu <input type="text" name="ProductName" required="required">
<br>
ilość <input type="number" name="Quantity" required="required">
 <input type = "submit">
</form>
<br>
do tej pory masz :
<br>
<%
int productPrice=0;

%>
<%
if (cart!=null){
	for (CartItem item:cart) { %>
<table border="1">	
<tr><td>Produkt : <%=item.getProd().getName() %></td></tr>
<tr><td>W ilości : <%=item.getQuantity() %></td></tr>

<%productPrice=item.getQuantity()*item.getProd().getPrice(); %>
</table>
<br>


<br>
<%}overallPrice+=productPrice; }%>
<%session.setAttribute("overallPrice", overallPrice); %>
<br>
Usun z koszyka <form action="ShoppingCartRemover" method="post">
<input type="text" name="whatToRemove" value=item>
<input type="submit">
</form>

}
Cena całkowita : <%=session.getAttribute("overallPrice") %>
<br>



</body>

</html>  