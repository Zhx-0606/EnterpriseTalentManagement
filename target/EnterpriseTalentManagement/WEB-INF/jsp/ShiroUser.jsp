<%--
  Created by IntelliJ IDEA.
  User: 周海鑫
  Date: 2020/5/23
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/enter/login" method="post">
        用户名：<input name="username" value="" type="text" />
        密码：<input name="password" value="" type="text" />
        <input value="登陆" type="submit" />
    </form>
</body>
</html>
