$(function(){

	function isRegist(){
		//ajax check
		
	}
	function checkMail(str){
		//校验邮箱
		var reg = /^[a-zA-Z0-9_-]+@([a-zA-Z0-9]+\.)+(com|cn|net|org)$/; 
		return reg.test(str); 
		
	}
	
	$("#reset1").click(function(){
		
		window.location.href="regist.html"
	});
	
	
	$("#regist1").click(function(){
		
		//		alert($("#email").val())
		if(checkMail($("#email").val())){//特别注意email的写法
			alert("注册成功！！！！")
			
		}else{
			alert("注册失败！！请检查邮件格式是否输入正确，例如：123456789@qq.com")
			
		}
		
		window.location.href="regist.html"
	});
	


	


});