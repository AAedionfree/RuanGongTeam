function search_fuze(request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 
				 var s ="";
				 	
				 for (var p in user) {
				 	s= s+"n "+p+": "+user[p];
				 }
				 alert(s);
				 var search_man_url=request_url+'devManagerAccount?managerAccount='+user.userAccount;
				 // alert(search_url);
				 mui.ajax({
					 type:'GET',
					 url:search_man_url,
					 timeout:10000,	
					 dataType:"json",
					 success:function(data){
							
						if(data.data!=null){
							var dev_data = new Array();
							dev_data=data.data;
							var temp_stable = document.getElementById('temp_stable').innerHTML;
							document.getElementById('fuze').innerHTML = template(temp_stable,{list:dev_data});
						}
					 },
					 error: function(xhr,type,errorThrown){
					 	mui.toast("服务器内部出错！");
					 }
				 });
	        });
}