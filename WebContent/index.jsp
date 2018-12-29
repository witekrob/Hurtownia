<%@page import="java.text.Normalizer.Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import = "controller.ProductDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hurtownia</title>
</head>
<body bgcolor="lightBlue">
<jsp:include page ="WEB-INF/Header.jspf"></jsp:include>
_________________________________________________________________________________________
<br>
<h1> Strona główna</h1>
<br>




<form action="productsServlet" method="post">
Wprowadz nazwę <input type = "Text" name="name"> <br>
Wprowadz nazwę producenta <input type = "text" name="producer"><br>
Wprowadz cenę produktu <input type="number" name="price">
Wprowadz ilość <input type="number" name="quantity">
<br>
<table>
<tr>	<td>Według producenta <input type= "radio"  name="findingMethod" value= "byProducer"></td>
		<td>Według nazwy <input type= "radio"  name="findingMethod" value= "byName"></td>
		<tr>
			</td>  <input type = "submit" value="getAll" name="choice"></td>
			</td>  <input type = "submit" value="search" name="choice"></td>
			</td>  <input type = "submit" value="addProduct" name="choice"></td>
		</tr>
		
</tr> 

</table>

</form>
<br>


_________________________________________________________________________________________
<br>
STOPKA
<%@include  file ="/WEB-INF/footer.jspf"%>

</body>
</html>