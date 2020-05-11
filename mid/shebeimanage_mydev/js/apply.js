	
function my_apply(request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 // var s ="";
				 	
				 // for (var p in user) {
				 // 	s= s+"n "+p+": "+user[p];
				 // }
				 // alert(s);
				 var search_app_url=request_url+'userLogs?userAccount='+user.userAccount;
				 // alert(search_url);
				 mui.ajax({
					 type:'GET',
					 url:search_app_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if((data.data!=null)){
							var log_data = new Array();
							log_data=data.data;
							var now_data=new Array();
							var al_data=new Array();
							for(i=0,j=0,k=0;i<log_data.length;i++){
								if(log_data[i].tokenStatus==1){
									al_data[j]=log_data[i];
									j++;
								}
									
								else if(log_data[i].tokenStatus==3){
									now_data[k]=log_data[i];
									k++;
								}
							}
							var temp_now_shen= document.getElementById('temp_now_shen').innerHTML;
							document.getElementById('shen_now').innerHTML = template(temp_now_shen,{list:now_data});
							var temp_al_shen= document.getElementById('temp_al_shen').innerHTML;
							document.getElementById('shen_al').innerHTML = template(temp_al_shen,{list:al_data});
						// 	var s ="";
								
						// 	for (var p in dev_chadata) {
						// 		s= s+"\n"+p+": "+dev_chadata[p];
						// 	}
						// 	alert(s);
						}
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
	        });
}