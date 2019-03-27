<%@ page import="com.kai.chap.pojo.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: kai369
  Date: 2019/3/27
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试@SessionAttributes</title>
</head>
<body>
    <%
        //从Session中获取数据
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        Long id = (Long) session.getAttribute("id_new");
        //展示数据
        out.print("<br>user_name = " + userInfo.getUserName());
        out.println("<br>id_name = " + id);
    %>
</body>
</html>
