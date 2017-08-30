<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">

/* form{
	border:solid 1px red;
	width:350px; 
	margin:auto;
	margin-top:150px;
} */
#myform{
	/* border:solid 1px red; */
	width:350px; 
	margin:auto;
	margin-top:150px;
	padding: 0px;


}
p{
text-align:center;
}

input{
	width:336px;
	margin-top:20px;
	margin-buttom:30px;
	padding: 10px;
	padding-right: 0px;
}
#login1{
	width:350px;

}

</style>
</head>
<body>
	<!-- <form action="LoginServlet" method="post">
		<input type="text" name="username" placeholder="用户名"/><br/>
		<input type = "password" name="password" placeholder="密码"/><br/>
		<input type="submit"  value="登录"></input>
	</form> -->
	<dir id="myform">
	
	
	<form action="AdminServlet" method="post" onsubmit="return check()" >
		<input type="text" name="username"  id="username"  placeholder="用户名"/><br/>
		<p id="userReg"></p>
		<input type = "password" name="password" id="password" placeholder="密码"/><br/>
		<p id="pwdReg"></p>
		<input type="submit" id="login1" value="登录"></input>
	</form>
	</dir>
</body>

<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
<script type="text/javascript">

$(function(){
	$("#username").focus(function(){
		$("#userReg").hide();
	});
	$("#password").focus(function(){
		$("#pwdReg").hide();
	});
	
});




function check(){
	
	var flag=true;
	var userReg=/^(_|[a-zA-Z]|\\$)\w{5,14}$/;
	var pwdReg=/^\w{6,15}$/;
	if(!userReg.test($("input[type='text']").val())){
		$("#userReg").text("用户名的首字符必须由首字符为$,_,字母所组成的6-15的字符").css('color','red').show();
		flag=false;
	}else if(!pwdReg.test($("#password").val())){
		$('#pwdReg').text("密码必须由6-15的字符组成").css('color','red').show();
		flag=false;
	}
	
	return flag;
	
	
}


</script>

</html>