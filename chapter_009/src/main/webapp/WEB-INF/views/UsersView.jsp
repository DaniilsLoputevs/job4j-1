<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>

<h2><b>Таблица пользователей</b></h2>
<table>
    <th>
    <td>id</td>
    <td>Name</td>
    <td>Login</td>
    <td>Email</td>
    <td>Role</td>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}">

            </c:out>
            </td>
            <td><c:out value="${user.name}"> </c:out>
            </td>
            <td><c:out value="${user.login}"> </c:out>
            </td>
            <td><c:out value="${user.email}"> </c:out>
            <td><c:out value="${user.role}"> </c:out>
        </tr>

        </th>

    </c:forEach>

</table>
<br>
<h2>
    <b>Добавление пользователя</b>
</h2>
<form action="${pageContext.servletContext.contextPath}/create" method="post">
    Name:<input type="text" name="name"><br>
    Login:<input type="text" name="login"><br>
    Password<input type="password"name="password"><br>
    Email:<input type="text" name="email"><br>
    Role:<select name="role">
        <option value="USER">User</option>
    </select>
    <input type="hidden" name="action" value="add">
    <input type="submit">

</form>
</body>
</html>
