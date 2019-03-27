<%--
  Created by IntelliJ IDEA.
  User: kai369
  Date: 2019/3/27
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
    <%
        //session记录数据
        session.setAttribute("id", 1L);
        //转发URL
        response.sendRedirect("/session/test");
    %>
</body>
</html>
