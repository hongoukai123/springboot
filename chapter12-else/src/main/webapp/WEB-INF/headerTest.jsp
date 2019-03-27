<%--
  Created by IntelliJ IDEA.
  User: kai369
  Date: 2019/3/27
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取请求头参数</title>
    <!-- 加载jquery文件 -->
    <script src="static/js/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $.post({
            url: "/test",
            //设置请求头参数
            headers: {id: '1'},
            //成功后的方法
            success: function(userInfo){
                if(userInfo == null || userInfo.id == null){
                    alert("获取失败");
                    return;
                }
                //弹出请求返回的用户信息
                alert("id=" + userInfo.id + ", user_name=" + userInfo.userName + ", note=" + userInfo.note);
            }
        })
    </script>
</head>
<body>

</body>
</html>
