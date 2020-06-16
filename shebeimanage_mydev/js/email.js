	
function yes_email(){
	mui.init();
	var user_email = document.getElementById("user_email ").value;
	var user_password=document.getElementById("user_password").value;
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
		// var s ="";
	
		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		if(user_password.length==0){
			mui.toast("密码不能为空！");
		}	
		else if(user.userPassword!=user_password){
			mui.toast("您输入的密码不正确，请重新输入！");
		}
		if(user_email.length==0){
			mui.toast("邮箱不能为空！");
		}
		else if(user_email.length!=0){
			var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
			isok= reg.test(user_email);
			if(!isok){
				mui.toast("您输入的邮箱格式不正确！");
			}
		}
		var add_buy_url = request_url + 'devBuyTemp?devName='
		mui.ajax({
			type: 'GET',
			url: add_buy_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {
	
				if (data.message == "success") {
					mui.toast("添加成功！");
					mui.back();
				} else {
					mui.toast(data.message);
				}
	
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}