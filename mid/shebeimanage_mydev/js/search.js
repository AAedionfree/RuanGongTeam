
	
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