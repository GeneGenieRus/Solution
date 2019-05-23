<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: GeneGenie
  Date: 18.05.2019
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:url value="/edit" var="var"/>

<form action="${var}" method="POST">
    <input type="hidden" name="id" value="${part.id}">
    <label for="name">Название</label>
    <input type="text" name="name" id="name" value="${part.name}">
    <br>
    <label for="need">Необходимость </label>
    <input type="checkbox" name="need" id="need">
    <br>
    <label for="amount">Количество </label>
    <input type="text" name="amount" id="amount" value="${part.amount}">
    <br>
    <input type="submit" value="Редактировать">

</form>

<br>


</body>
</html>
