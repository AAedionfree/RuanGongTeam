function is_special(a){
		var flag=0;
	for(var i =0;i<a.length;i++){
			
		if((0<=a[i]&&a[i]<=9)||('a'<=a[i]&&a[i]<='z')||('A'<=a[i]&&a[i]<='Z')){
			continue;
			
		}else{
			flag = 1;
		}
	}
	return flag;
}


function login_m(request_url){
		mui.init();
		var password = document.getElementById("password").value;
		var useraccount = document.getElementById("account").value;
		var cha_psd=is_special(password);
		var cha_ua=is_special(useraccount);
			
		if(cha_psd==1||cha_ua==1){
			mui.toast("输入的格式不正确！应输入数字或字母！");
			return;
		}
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
					dataType:"json",
					success: function(data){
						var user_s = JSON.stringify(data.data);
						user_s=user_s.substring(1,user_s.length-1);
						var user = JSON.parse(user_s);
						// var s ="";
							
						// for (var p in user) {
						// 	s= s+"n "+p+": "+user[p];
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