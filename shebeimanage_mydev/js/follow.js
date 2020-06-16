function follow_m(request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;
		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// mui.toast(s);
		var search_url = request_url + 'AttentionDevices?userAccount=' + user.userAccount;
		// alert(search_url);
		mui.ajax({
			type: 'GET',
			url: search_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if (data.data != null) {
					var dev_data = new Array();
					dev_data = data.data;
					for(i=0;i<dev_data.length;i++){
								if (dev_data[i].devWorkStatus == 1) {
									dev_data[i].devWorkStatus= "正常";
								} else if (dev_data[i].devWorkStatus == 2) {
									dev_data[i].devWorkStatus= "报废";
								} else if (dev_data[i].devWorkStatus == 3) {
									dev_data[i].devWorkStatus= "故障";
								} else if (dev_data[i].devWorkStatus == 4) {
									dev_data[i].devWorkStatus= "维修";
								} else if (dev_data[i].devWorkStatus == 5) {
									dev_data[i].devWorkStatus="待报废";
								}
					}
					var follow_text = document.getElementById('follow_texts').innerHTML;
					document.getElementById('follow_tb').innerHTML = template(follow_text, {
						list: dev_data
					});
				}
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});
}

function more(dev_data_num, request_url) {
	mui.init();
	mui.plusReady(function() {
		var self = plus.webview.currentWebview();
		var user = self.user;

		// var s ="";

		// for (var p in user) {
		// 	s= s+"n "+p+": "+user[p];
		// }
		// alert(s);
		var follow_url = request_url + "devId?devId=" + dev_data_num;
		
		mui.ajax({
			type: 'GET',
			url: follow_url,
			timeout: 10000,
			dataType: "json",
			success: function(data) {

				if ((data.data != null)) {
					var dev_data = data.data[0];
					var s ="";
					//alert(dev_data);
					for (var p in dev_data) {
						if ((p == "devWorkStatus") || (p == "devStatus")) {

							if (p == "devWorkStatus") {
								if (dev_data[p] == 1) {
									s = s + "\n" + "设备状态" + ": " + "正常";
								} else if (dev_data[p] == 2) {
									s = s + "\n" + "设备状态" + ": " + "报废";
								} else if (dev_data[p] == 3) {
									s = s + "\n" + "设备状态" + ": " + "故障";
								} else if (dev_data[p] == 4) {
									s = s + "\n" + "设备状态" + ": " + "维修";
								} else if (dev_data[p] == 5) {
									s = s + "\n" + "设备状态" + ": " + "待报废";
								}
							} else if (p == "devStatus") {
								if (dev_data[p] == 1) {
									s = s + "\n" + "设备出借状态" + ": " + "空闲";
								} else if (dev_data[p] == 2) {
									s = s + "\n" + "设备出借状态" + ": " + "出借";
								}
							}
						} 
						else if(p=="devId"){
							s= s+"\n"+"设备序号"+": "+dev_data[p];
						}
						else if(p=="devName"){
							s= s+"\n"+"设备名称"+": "+dev_data[p];
						}
						else if(p=="devType"){
							s= s+"\n"+"设备类型"+": "+dev_data[p];
						}
						else if(p=="devPrise"){
							s= s+"\n"+"设备价格"+": "+dev_data[p];
						}
						else if(p=="devDate"){
							s= s+"\n"+"设备日期"+": "+dev_data[p];
						}
						else if(p=="devPeriod"){
							s= s+"\n"+"设备保质期"+": "+dev_data[p];
						}
						else if(p=="chargeAccount"){
							s= s+"\n"+"经办人"+": "+dev_data[p];
						}
						else if(p=="managerAccount"){
							s= s+"\n"+"设备负责人"+": "+dev_data[p];
						}
						else if(p=="devAuth"){
							s= s+"\n"+"设备权限"+": "+dev_data[p];
						}
						else if(p=="userAccount"){
							s= s+"\n"+"用户账号"+": "+dev_data[p];
						}
					}
					alert(s);
				}
			},
			error: function(xhr, type, errorThrown) {
				mui.toast("服务器内部出错！");
			}
		});
	});

	// var s ="";

	// for (var p in dev_data) {
	// 	s= s+"n "+p+": "+dev_data[p];
	// }
	// alert(s);
}