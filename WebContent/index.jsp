<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hurtownia</title>
</head>
<body>
<h1> Strona główna</h1>

<form action="productsServlet" method="post">
Wprowadz nazwę <input type = "Text" name="name"> <br>
Wprowadz nazwę producenta <input type = "text" name="producer"><br>
Wprowadz cenę produktu <input type="number" name="price">
<br>
<table>
<tr><td> Dodaj nowy produkt <input type ="radio"  name ="choice" value = "addProduct"></td>
	<td> Wyswietl wszystkie produkty <input type ="radio" name="choice" value="getAll" ></td>
		<tr><td>Znajdz produkt  <input type="radio" name ="choice"  value="search"></td>
		<td>Według producenta <input type= "radio"  name="findingMethod" value= "byProducer"></td>
		<td>Według numeruId <input type= "radio"  name="findingMethod" value= "byNumerId"></td>
		<td>Według nazwy <input type= "radio"  name="findingMethod" value= "byName"></td>
	
</tr> 

</table>

<input type = "submit" value="wyslij">


</form>


</body>
</html>