<%--
  Created by IntelliJ IDEA.
  User: Daniel
  Date: 25.07.2020
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Aby dodać zamówienie uzupełnij dane:</title>
</head>
<body>
    <h1> Aby dodać zamówienie uzupełnij dane:</h1>
    <form action="OrderServlet" method="post">
        Podaj imię: <input type="text" placeholder="imię" name="firstname"><br>
        Podaj nazwisko: <input type="text" placeholder="nazwisko" name="lastname"><br>
        Napisz co chcesz zamówić:<input type="text" placeholder="np. rower" name="nameorder"><br>
        Jeżeli wszystko zostało poprawnie uzupłenione kliknij --> <input type="submit" value="Dodaj zamówienie">
    </form>
</body>
</html>
