<%--
  Created by IntelliJ IDEA.
  User: kai369
  Date: 2019/4/12
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <form action="/system/login" method="post">
        <p>名称：<input id="username" name="username" type="text" value=""/></p>
        <p>描述：<input id="password" name="password" type="password" value=""/></p>
        <p>记住我：<input id="remember_me" name="remember-me" type="checkbox" value=""/></p>
        <p><input type="submit" value="登录"/></p>
        <!-- 避免CSRF攻击 -->
        <input type="hidden" id="${_csrf.parameterName}" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</body>
</html>
