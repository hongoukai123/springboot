<%--
  Created by IntelliJ IDEA.
  User: kai369
  Date: 2019/3/26
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="/international/page?language=zh_CN">简体中文</a>
    <a href="/international/page?language=en_US">美国英文</a>
    <h1>
        <!-- 找到属性文件变量名 -->
        <spring:message code="msg"/>
    </h1>
    <!-- 当前国际化区域 -->
    Locale: ${pageContext.response.locale}
</body>
</html>
