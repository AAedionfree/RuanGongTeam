	
function load_dai(request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var arrange_load_url=request_url+'devFindScrapRecord?userAccount='+user.userAccount;
				 // alert(user.userAuthority);
				 mui.ajax({
					 type:'GET',
					 url:arrange_load_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if((data.data!=null)&&(user.userAuthority==0)){
							var bao_data = new Array();
								bao_data=data.data;
								var temp_arrange= document.getElementById('temp_arrange').innerHTML;
								document.getElementById('bao_arrange').innerHTML = template(temp_arrange,{list:bao_data});
							}
						// 	var s ="";
								
						// 	for (var p in dev_chadata) {
						// 		s= s+"\n"+p+": "+dev_chadata[p];
						// 	}
						// 	alert(s);
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
	        });
}
	
function yes_arrange(logid,request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var arrange_yes_url=request_url+'devDealScrapRecord?userAccount='+user.userAccount+'&logId='+logid+'&logStatus=1';
				 // alert(search_url);
				 mui.ajax({
					 type:'GET',
					 url:arrange_yes_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if((data.code==0)){
							mui.toast("确认成功！")
							load_dai(request_url);
							}
						// 	var s ="";
								
						// 	for (var p in dev_chadata) {
						// 		s= s+"\n"+p+": "+dev_chadata[p];
						// 	}
						// 	alert(s);
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
	        });
}
	
function no_arrange(logid,request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var arrange_no_url=request_url+'devDealScrapRecord?userAccount='+user.userAccount+'&logId='+logid+'&logStatus=2';
				 mui.ajax({
					 type:'GET',
					 url:arrange_no_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if((data.code==0)){
							mui.toast("驳回成功！")
							load_dai(request_url);
							}
						// 	var s ="";
								
						// 	for (var p in dev_chadata) {
						// 		s= s+"\n"+p+": "+dev_chadata[p];
						// 	}
						// 	alert(s);
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
	        });
}
	
function more_arr(lognum,request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var arrange_load_url=request_url+'devFindScrapRecord?userAccount='+user.userAccount;
				 // alert(user.userAuthority);
				 mui.ajax({
					 type:'GET',
					 url:arrange_load_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
						if((data.data!=null)){
							var log_data = new Array();
							log_data=data.data;
							xian_log=log_data[lognum];
							var s ="";
								
							for (var p in xian_log) {
								if(p=="logId"){
									s= s+"\n"+p+": "+xian_log[p];
								}
									
								else if(p=="devId"){
									s= s+"\n"+p+": "+xian_log[p];
								}
								else if(p=="devStatus"){
									if(xian_log[p]==1){
										s= s+"\n"+"设备出借状态"+": "+"空闲";
									}
									else if(xian_log[p]==2){
										s= s+"\n"+"设备出借状态"+": "+"出借";
									}
								}
								else if(p=="devWorkStatus"){
									if(xian_log[p]==1){
										s= s+"\n"+"设备状态"+": "+"正常";
									}
									else if(xian_log[p]==2){
										s= s+"\n"+"设备状态"+": "+"报废";
									}
									else if(xian_log[p]==3){
										s= s+"\n"+"设备状态"+": "+"故障";
									}
									else if(xian_log[p]==4){
										s= s+"\n"+"设备状态"+": "+"维修";
									}
									else if(xian_log[p]==5){
										s= s+"\n"+"设备状态"+": "+"待报废";
									}
								}
								else if(p=="tokenId"){
									if(xian_log[p]==0){
										s= s+"\n"+"指令编号"+": "+"购置";
									}
									else if(xian_log[p]==1){
										s= s+"\n"+"指令编号"+": "+"借取";
									}
									else if(xian_log[p]==2){
										s= s+"\n"+"指令编号"+": "+"归还";
									}
									else if(xian_log[p]==3){
										s= s+"\n"+"指令编号"+": "+"修理";
									}
									else if(xian_log[p]==4){
										s= s+"\n"+"指令编号"+": "+"故障";
									}
									else if(xian_log[p]==5){
										s= s+"\n"+"指令编号"+": "+"报废";
									}
									else if(xian_log[p]==6){
										s= s+"\n"+"指令编号"+": "+"确认";
									}
								}
								else if(p=="tokenStatus"){
									if(xian_log[p]==1){
										s= s+"\n"+"指令执行状态"+": "+"执行成功";
									}
									else if(xian_log[p]==2){
										s= s+"\n"+"指令执行状态"+": "+"执行失败";
									}
									else if(xian_log[p]==3){
										s= s+"\n"+"指令执行状态"+": "+"代办";
									}
									else if(xian_log[p]==4){
										s= s+"\n"+"指令执行状态"+": "+"已撤回";
									}
								}
								else if(p=="senderAccount"){
									s= s+"\n"+"执行操作用户账号"+": "+xian_log[p];
								}
								else if(p=="receiver_account"){
									s= s+"\n"+"接收人账号"+": "+xian_log[p];
								}
								else if(p=="change_time"){
									s= s+"\n"+"更改日期"+": "+xian_log[p];
								}
									
								else if(p=="auth"){
									s= s+"\n"+p+": "+xian_log[p];
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
}