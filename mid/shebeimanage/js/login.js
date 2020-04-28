function login_m(request_url){
		mui.init();
		var password = document.getElementById("password").value;
		var useraccount = document.getElementById("account").value;
		if(useraccount.length==0){
			mui.toast("账号不能为空！");
			return;
			
		}else if(password.length==0){
			mui.toast("密码不能为空！");
			return;
		}else{
			var loginurl=request_url+'login?userAccount='+useraccount+'&userPassword='+password;
			mui.plusReady(function(){
				mui.ajax({
					type:'GET',
					url:loginurl,
					timeout:10000,	
					success: function(data){
						// var s ="";
							
						// for (var p in data) {
						// 	s= s+"n "+p+": "+data[p];
						// }
						// alert(s);
						if(data.code==0){
							mui.toast(data.message);
						}else {
							mui.toast(data.message);
						}	
					},
					error: function(xhr,type,errorThrown){
						mui.toast("服务器内部出错！");
					}
				});
			});
		}
}