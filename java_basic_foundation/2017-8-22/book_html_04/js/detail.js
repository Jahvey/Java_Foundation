
$(function(){

			$("#addShopCar1").click(function(){

	window.location.href="shopCar.html"

});

	$("#purchase1").click(function(){
			if(confirm("您是否确定要购买？")){
		window.location.href="shopCar.html"
	}else{
		window.location.href="list.html"
	}
		
	});

});


