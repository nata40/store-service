<%@ page import="pl.danielsiwulec.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 25.07.2020
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Zamówienia:</h2>
<table style="width:50%" border="1">
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>Produkt</th>
        <th>Data dodania</th>
    </tr>
    <% Product product = (Product) request.getAttribute("product");%>
    <tr>
        <td><%= product.getFirstName()%></td>
        <td><%= product.getLastName()%></td>
        <td><%= product.getProductName()%></td>
        <td><%= product.getTodayDate()%></td>
    </tr>


</table>
</body>
</html>
