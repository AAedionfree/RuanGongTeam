
	
function search_m(request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // mui.toast(s);
				 var search_url=request_url+'devUserAccount?userAccount='+user.userAccount;
				 // alert(search_url);
				 mui.ajax({
					 type:'GET',
					 url:search_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if(data.data!=null){
							var dev_data = new Array();
							dev_data=data.data;
							var temp_stable = document.getElementById('temp_stable').innerHTML;
							document.getElementById('tb').innerHTML = template(temp_stable,{list:dev_data});
						}
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
	        });
}

function search_s(dev_id,request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var search_url=request_url+"devLend?userAccount="+user.userAccount+"&devId="+dev_id;
				 // alert(search_url);
				 mui.ajax({
					 type:'GET',
					 url:search_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if(data.data!=null){
							var dev_data = new Array();
							dev_data=data.data;
							alert("租借成功");
							search_m(request_url);
						}
						else{
							alert(dev_data);
							print(dev_data);
							search_m(request_url);
						}
					 },
					 error: function(xhr,type,errorThrown){
					 	alert("服务器内部出错！");
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
				 var search_url=request_url+'devUserAccount?userAccount='+user.userAccount;
				 // alert(search_url);
				 mui.ajax({
					 type:'GET',
					 url:search_url,
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
									
								else {
									s= s+"\n"+p+": "+dev_chadata[p];
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