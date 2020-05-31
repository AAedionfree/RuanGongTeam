	
function check_equ(request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var search_check_url = request_url+'devUserAccount?userAccount='+user.userAccount;
				 // alert(search_check_url);
				 mui.ajax({
					 type:'GET',
					 url:search_check_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if((data.data!=null)){
							var dev_data = new Array();
							dev_data=data.data;
							// var s ="";
								
							// for (var p in dev_data[0]) {
							// 	s= s+"n "+p+": "+dev_data[0][p];
							// }
							// alert(s);
							var temp_check = document.getElementById('temp_check').innerHTML;
							document.getElementById('c_euq').innerHTML = template(temp_check,{list:dev_data});
						}
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
			});
}

function more(dev_data_num,request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var search_check_url=request_url+'devUserAccount?userAccount='+user.userAccount;
				 // alert(search_url);
				 mui.ajax({
					 type:'GET',
					 url:search_check_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if((data.data!=null)){
							var dev_data = new Array();
							dev_data=data.data;
							var dev_chadata=dev_data[dev_data_num];
							var s ="";
								
							for (var p in dev_chadata) {
									
								if((p=="devWorkStatus")||(p=="devStatus")){
										
									if(p=="devWorkStatus"){
										if(dev_chadata[p]==1){
											s= s+"\n"+"设备状态"+": "+"正常";
										}
										else if(dev_chadata[p]==2){
											s= s+"\n"+"设备状态"+": "+"报废";
										}
										else if(dev_chadata[p]==3){
											s= s+"\n"+"设备状态"+": "+"故障";
										}
										else if(dev_chadata[p]==4){
											s= s+"\n"+"设备状态"+": "+"维修";
										}
										else if(dev_chadata[p]==5){
											s= s+"\n"+"设备状态"+": "+"待报废";
										}
									}
									
									else if(p=="devStatus"){
										if(dev_chadata[p]==1){
											s= s+"\n"+"设备出借状态"+": "+"空闲";
										}
										else if(dev_chadata[p]==2){
											s= s+"\n"+"设备出借状态"+": "+"出借";
										}
									}
								}
									
								else if(p=="devId"){
									s= s+"\n"+"设备序号"+": "+dev_chadata[p];
								}
								else if(p=="devName"){
									s= s+"\n"+"设备名称"+": "+dev_chadata[p];
								}
								else if(p=="devType"){
									s= s+"\n"+"设备类型"+": "+dev_chadata[p];
								}
								else if(p=="devPrise"){
									s= s+"\n"+"设备价格"+": "+dev_chadata[p];
								}
								else if(p=="devDate"){
									s= s+"\n"+"设备日期"+": "+dev_chadata[p];
								}
								else if(p=="devPeriod"){
									s= s+"\n"+"设备保质期"+": "+dev_chadata[p];
								}
								else if(p=="chargeAccount"){
									s= s+"\n"+"经办人"+": "+dev_chadata[p];
								}
								else if(p=="managerAccount"){
									s= s+"\n"+"设备负责人"+": "+dev_chadata[p];
								}
								else if(p=="devAuth"){
									s= s+"\n"+"设备权限"+": "+dev_chadata[p];
								}
								else if(p=="userAccount"){
									s= s+"\n"+"用户账号"+": "+dev_chadata[p];
								}
							}
							alert(s);
						}
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
	        });
	
	// var s ="";
		
	// for (var p in dev_data) {
	// 	s= s+"n "+p+": "+dev_data[p];
	// }
	// alert(s);
}
