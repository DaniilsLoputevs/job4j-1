<%@ page import="ru.job4j.servletapi.crud.User" %>
<%@ page import="ru.job4j.servletapi.crud.ValidateService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    <b>Добавление пользователя</b>
</h2>
<form action="<%=request.getContextPath()%>/" method="post">
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
    <% for (User value : ValidateService.getInstance().findAll()) {%>
    <tr>
        <td><%=value.getId()%>
        </td>
        <td><%=value.getLogin()%>
        </td>
        <td><%=value.getName()%>
        </td>
        <td><%=value.getEmail()%>
        </td>

    </tr>

    <% }%>
    </th>
</table>
<br>
<br>
<br>
<h2><b>Редактирование пользователя </b></h2>

<form action="<%=request.getContextPath()%>/edit" method="post">
    <input type="text" name="id" placeholder="id"><br>
    <input type="text" name="name" placeholder="name"><br>
    <input type="text" name="login" placeholder="login"><br>
    <input type="text" name="email" placeholder="email"><br>
    <input type="submit" update><br>
    <input type="hidden" name="action" value="edit">
</form>

<h2><b>Удаление пользователя</b></h2>
<form action="<%=request.getContextPath()%>/delete" method="post">
    <input type="text" name="id" placeholder="insert id">
    <input type="submit" delete>
    <input type="hidden" name="action" value="delete">

</form>

</body>
</html>
