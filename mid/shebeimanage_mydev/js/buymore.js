function finish(resquest_url){
	mui.init();
	var dev_name = document.getElementById("dev_name").value;
	var dev_type = document.getElementById("dev_type").value;
	var dev_num = document.getElementById("dev_num").value;
	var dev_prise = document.getElementById("dev_prise").value;
	var dev_period = document.getElementById("dev_period").value;
	var charge_account = document.getElementById("charge_account").value;
	var manager_account = document.getElementById("manager_account").value;
	var dev_auth = document.getElementById("dev_auth").value;
	mui.plusReady(function(){
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var add_buy_url=request_url+'devBuy?devName='+dev_name+'&devType='+dev_type+'&devPrise='+dev_prise+'&devPeriod='+dev_period+'&chargeAccount='+charge_account+'&managerAccount='+manager_account+'&devAuth='+dev_auth+'&number='+dev_num;
				 mui.ajax({
					 type:'GET',
					 url:add_buy_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
								
							if(data.message=="success"){
								mui.toast("添加成功！");
								mui.back();
							}
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
	        });
	// var s ="";
		
	// for (var p in buymore_new) {
	// 	s= s+"n "+p+": "+buymore_new[p];
	// }
	// alert(s);
}
	

function quit(){
	mui.init();
	mui.plusReady(function () {
			mui.back();
	});
}
