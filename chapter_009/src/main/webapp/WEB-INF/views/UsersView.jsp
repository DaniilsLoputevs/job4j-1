<%@ page import="ru.job4j.servletapi.crud.User" %>
<%@ page import="ru.job4j.servletapi.crud.ValidateService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <b>Добавление пользователя</b>
</h2>
<form action="${pageContext.servletContext.contextPath}/" method="post">
    Name:<input type="text" name="name"><br>
    Login:<input type="text" name="login"><br>
    Email:<input type="text" name="email"><br>
    <input type="hidden" name="action" value="add">
    <input type="submit">
</form>
<br>

<h2><b>Таблица пользователей</b></h2>
<table>
    <th>
    <td>id</td>
    <td>Name</td>
    <td>Login</td>
    <td>Email</td>
    <td>action</td>
    <c:forEach items="${users}" var="user">

        <tr>
            <td><c:out value="${user.id}"> </c:out>
            </td>
            <td><c:out value="${user.name}"> </c:out>
            </td>
            <td><c:out value="${user.login}"> </c:out>
            </td>
            <td><c:out value="${user.email}"> </c:out>
            </td>

        </tr>


        </th>

    </c:forEach>

</table>
<br>
<br>
<br>
<h2><b>Редактирование пользователя </b></h2>

<form action="${pageContext.servletContext.contextPath}/edit" method="post">
    <input type="text" name="id" placeholder="id"><br>
    <input type="text" name="name" placeholder="name"><br>
    <input type="text" name="login" placeholder="login"><br>
    <input type="text" name="email" placeholder="email"><br>
    <input type="submit" update><br>
    <input type="hidden" name="action" value="edit">
</form>

<h2><b>Удаление пользователя</b></h2>
<form action="${pageContext.servletContext.contextPath}/delete" method="post">
    <input type="text" name="id" placeholder="insert id">
    <input type="submit" delete>
    <input type="hidden" name="action" value="delete">

</form>

</body>
</html>
