<%@ page import="pl.danielsiwulec.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 25.07.2020
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wszystkie zamówienia</title>
</head>
<body>
    <h2>Zamówienia:</h2>
    <table style="width:50%" border="1">
        <tr>
            <th>ID</th>
            <th>Produkt</th>

        </tr>
        <% List<Product> productList = (List<Product>) request.getAttribute("productList");
        if(productList != null)
            for (Product product:productList) {

        %>
        <tr>
            <td><%= product.getIdProduct()%></td>
            <td><%= product.getProductName()%></td>
        </tr>
        <%}%>

    </table>
<a href="index.jsp">Strona główna</a>
</body>
</html>
