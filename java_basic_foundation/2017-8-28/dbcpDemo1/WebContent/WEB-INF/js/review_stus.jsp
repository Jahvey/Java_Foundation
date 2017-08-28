<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>管理界面</h1>
<table>


<tr>
<td>姓名</td>
<td>性别</td>
<td>电话</td>
<td>年龄</td>
<td>地址</td>
<td>专业</td>

</tr>

<c:forEach items="${students }" var ="stus">
<tr>
<td>${stus.name }</td>
<td>${stus.gender}</td>
<td>${stus.phone}</td>
<td>${stus.age }</td>
<td>${stus.address }</td>
<td>${stus.major }</td>

</tr>
</c:forEach>


</table>



</body>
</html>