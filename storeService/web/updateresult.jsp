<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 26.07.2020
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja zamówienia</title>
</head>
<body>
<form action="UpdateServlet" method="post">
    Podaj id zamówienia, którego chcesz edytować: <input type="number" placeholder="podaj id" name="updateid" ><br>
    Podaj nowe imię: <input type="text" placeholder="imię" name="firstname"><br>
    Podaj nowe nazwisko: <input type="text" placeholder="nazwisko" name="lastname"><br>
    Podaj nową nazwę zamawianego produktu: <input type="text" placeholder="np. hulajnoga" name="productname">
    <input type="submit" name="Edytuj!">
</form>

</body>
</html>
