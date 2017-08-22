$(function(){

	$("#dl").click(function(){

		var username=$("#username").val();
        var pwd = $("#pwd").val();
        if(username!="adonai"&&pwd!="123"){
        	alert("请输入正确的用户名和密码:默认adonai,123")
        }else{
        	alert("恭喜您登陆成功！")
        }
	});
	
	
	$("#zz").click(function(){

		window.location.href="regist.html"
	});

});