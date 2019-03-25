<%--
  Created by IntelliJ IDEA.
  User: kai369
  Date: 2019/3/25
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
    <p>使用HttpServletRequest作为参数进行上传：</p>
    <form method="post" action="/file/upload/request" enctype="multipart/form-data">
        <input type="file" name="file" value="请选择上传的文件"/>
        <input type="submit" value="提交" />
    </form>
    <p>使用SpringMVC的MultipartFile类进行上传：</p>
    <form method="post" action="/file/upload/multipart" enctype="multipart/form-data">
        <input type="file" name="file" value="请选择上传的文件"/>
        <input type="submit" value="提交" />
    </form>
    <p>使用Servlet的API（Part）来进行上传：</p>
    <form method="post" action="/file/upload/part" enctype="multipart/form-data">
        <input type="file" name="file" value="请选择上传的文件"/>
        <input type="submit" value="提交" />
    </form>
</body>
</html>
