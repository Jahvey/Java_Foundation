<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理界面</title>
</head>
<body>
	<table>
		<tr>
			<td>姓名</td>
			<td>相片</td>
			<td>性别</td>
			<td>电话</td>
			<td>年龄</td>
			<td>专业</td>
			<td>地址</td>		
		</tr>
		<c:forEach items="${students }" var="stu" varStatus="index">
			<tr id="tr${stu.stuId}">
				<td>${stu.name }</td>
				<td>${stu.img }</td>
				<td>${stu.gender }</td>
				<td>${stu.phone }</td>
				<td>${stu.age }</td>
				<td>${stu.major }</td>
				<td>${stu.address }</td>
				<td><button onclick="deleteStudent('${stu.stuId}')" id="${stu.stuId}">删除</button></td><%-- ${index.count} --%>
			</tr>
		</c:forEach>		
	</table>
</body>
<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
	/* $(function(){		
		$("button").click(function(){
			var index = $(this).attr('id');
			$.ajax({
				url:"DeleteStudentServlet?stuId="+index,
				asyn:true,
				type:"post",
				dataType:'json',//此处必须要，否则js不知道返回的数据类型，无法解析
				success:function(result){
					if(result.msg=='ok'){
						$("#tr"+index).remove();
					}
				},
				error:function(){
					alert("action error!");
				}
			});
		});
	}); */
	function deleteStudent(stuId){
		$.ajax({
			url:"DeleteStudentServlet?stuId="+stuId,
			asyn:true,
			type:'post',
			dataType:'json',
			success:function(result){
				if(result.msg == 'ok'){
					$("#tr"+stuId).remove();
				}
			},
			error:function(){
				alert("action error!");
			}		
		});
	}
</script>
</html>