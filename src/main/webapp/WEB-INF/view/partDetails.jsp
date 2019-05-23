<%--
  Created by IntelliJ IDEA.
  User: GeneGenie
  Date: 17.05.2019
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .blue-button{
            background: #25A6E1;
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:12px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            width: 50%;
        }
        th {
            background: SteelBlue;
            color: white;
        }
        td,th{
            border: 1px solid gray;
            width: 25%;
            text-align: left;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<h3>Part List</h3>
<c:forEach begin="1" end="${pages}" step="1" varStatus="i">
    <c:url value="/" var="url">
        <c:param name="page" value="${i.index}"/>
        <c:param name="par" value="${par}"/>
        <c:param name="search" value="${search}"/>
    </c:url>
    <a href="${url}">${i.index}</a>
</c:forEach>

<c:if test="${!empty listParts}">



<table>
    <tr>
    <td>

    <table class="tg">
        <tr>
            <th width="120">Название</th>
            <th width="120">Количество</th>
            <th width="120">Необходимость</th>
            <th width="60">Редактировать</th>
            <th width="60">Удалить</th>
        </tr>
        <c:forEach items="${listParts}" var="part">
            <tr>
                <td>${part.name}</td>
                <td>${part.amount}</td>
                <td> <c:if
                        test="${part.need==true}"> Да </c:if>
                    <c:if
                            test="${part.need==false}"> Нет </c:if></td>
            <td><a href="<c:url value='/edit/${part.id}' />" >Редактировать</a></td>
            <td><a href="<c:url value='/remove/${part.id}' />" >Удалить</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>

    </td>
    <td  valign="top" width="320">
<div>
    <table border="1" cellpadding="4">
        <tr>
            <td>

                <form method="get" action="<c:url value='/' />" >
                    <INPUT id="all" TYPE="radio" name="par" value="all" <c:if
                            test="${par.equals('all')}"> checked="checked" </c:if>>Выбрать все
                    <br>
                    <INPUT id="true" TYPE="radio" name="par" value="true"
                            <c:if test="${par.equals('true')}"> checked="checked" </c:if>/>Только обязательные
                    <br>
                    <INPUT id="false" TYPE="radio" name="par" value="false" <c:if
                            test="${par.equals('false')}"> checked="checked" </c:if>/>Необязательные
                    <br>
                    <br>
                    <label for="search">Выборка по названию</label>

                    <input type="text" name="search" id="search" value="${search}">
                    <br>
                    <br>
                    <input type="submit" value="Выбрать">
                </form>

            </td>
        </tr>

    </table>
</div>
        <br>
        <a href="<c:url value='/add' />" > Добавить деталь</a>
    </td>
    </tr>
    <tr>
        <td>
        Всего можно собрать "${complect}" компьютеров
        </td>
    </tr>
</table>
</body>
</html>