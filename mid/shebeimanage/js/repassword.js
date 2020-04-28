function to_repassword(){
	mui.init();
	mui.openWindow({
		url:'repassword.html',
	});
}

function repassword_m(request_url){
	mui.init();
	var o_password = document.getElementById("o_password").value;
	var n_password = document.getElementById("n_password").value;
	var useraccount = document.getElementById("account").value;
		
	if(useraccount.length==0){
		mui.toast("账号不能为空！");
		return;
		
	}
		
	else if(o_password.length==0){
		mui.toast("请填写旧密码！");
		return;
	}
		
	else if(n_password.length==0){
		mui.toast("请填写新密码！");
		return;
	}
	else{
		if(o_password==n_password){
			mui.toast("旧密码和新密码一致！");
			return;
		}else{
				var repasswordurl=request_url+'userUpdatePassword?userAccount='+useraccount+'&userOldPassword='+o_password+'&userNewPassword='+n_password;
				mui.plusReady(function(){
					mui.ajax({
						type:'GET',
						url:repasswordurl,
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
}