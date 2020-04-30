	
function search_m(request_url){
	mui.init();
	mui.plusReady(function(){
	            var self = plus.webview.currentWebview();
				 var user = self.user;
				 var search_url=request_url+'devUserAccount?userAccount='+user.userAccount;
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