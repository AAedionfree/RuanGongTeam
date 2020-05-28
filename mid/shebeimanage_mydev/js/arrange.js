	
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
				 // alert(search_url);
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
				 var arrange_no_url=request_url+'devDealScrapRecord?userAccount='+user.userAccount+'&logId='+logid+'&logStatus=0';
				 // alert(search_url);
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