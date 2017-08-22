$(function(){

	
	$("#delete1").click(function(){
		if(confirm("确认要删除吗？")){
		var lg=document.querySelector("#shopCarDetail1");
		lg.style.display="none";
		}else{
			window.location.href="shopCar.html"
		}

	});
	
	$("#pay1").click(function(){
		alert("恭喜您，付款成功！")

	});
	
	
	
});
