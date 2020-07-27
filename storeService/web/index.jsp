<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 25.07.2020
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Panel zamówień</title>
  </head>
  <body>
  <h1><u>Witaj na stronie sklepu!</u></h1>
  <h2>Dodanie zamówienia</h2>
    <a href="addOrder.jsp" >Dodaj zamówienie</a>
  <h2>Wyświetlenie wszystkich zamówień</h2>
  <form action="PrintServlet" method="post"><input type="submit" value="Wyświetl zamówienia"></form>
  <h2>Wyświetlanie szczegółów zamówienia</h2>
  <form action="SearchServlet" method="post">
      Podaj ID zamówienia: <input type="number" placeholder="Podaj id" name="id">
      <br>
      <input type="submit" value="Wyszukaj">
  </form>
 <h2>Edycja zamówienia</h2>
  <a href="updateresult.jsp">Kliknij aby edytować zamówienie</a>
  </form>
  <h2>Usuń zamówienie:</h2>
  <form action="DeleteServlet" method="post">
      Podaj ID zamówienia: <input type="number" placeholder="Podaj id" name="deleteid">
      <br>
      <input type="submit" value="Usuń">
  </form>

  </body>
</html>
