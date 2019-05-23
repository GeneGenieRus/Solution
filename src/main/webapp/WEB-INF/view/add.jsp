<%--
  Created by IntelliJ IDEA.
  User: GeneGenie
  Date: 21.05.2019
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:url value="/add" var="var"/>
<form action="${var}" method="POST">

    <label for="name">Название</label>
    <input type="text" name="name" id="name">
    <br>
    <label for="need">Необходимость </label>
    <input type="checkbox" name="need" id="need">
    <br>

    <label for="amount">Количество </label>
    <input type="text" name="amount" id="amount">
    <br>

        <input type="submit" value="Добавить">

</form>
</body>
</html>
