<%--
  Created by IntelliJ IDEA.
  User: kai369
  Date: 2019/4/12
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登出</title>
</head>
<body>
    <form action="/system/logout" method="post">
        <p><input type="submit" value="登出"/></p>
        <!-- 防止CSRF攻击 -->
        <input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</body>
</html>
