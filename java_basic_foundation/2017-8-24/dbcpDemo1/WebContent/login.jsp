<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		<input type="text" name="username" placeholder="用户名"/><br/>
		<input type = "password" name="password" placeholder="密码"/><br/>
		<input type="submit"  value="登录"></input>
	</form>
</body>
</html>