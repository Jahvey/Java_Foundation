<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/17
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
This is getFilterTestServlet!
这是使用get方式提交的
<form action="getFilterTestServlet" method="get">
    <input type="text" name="username">姓名<br/>
    <input type="text" name="password">密码<br/>
    <input type="submit" value="提交">

</form>
</body>
</html>
