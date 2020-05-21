function finish(){
	mui.init();
	var buymore_new = {
		dev_name:"",
		dev_type:"",
		dev_num:"",
		dev_prise:"",
		dev_period:"",
		charge_account:"",
		manager_account:"",
		dev_auth:""
	};
	buymore_new.dev_name = document.getElementById("dev_name").value;
	buymore_new.dev_type = document.getElementById("dev_type").value;
	buymore_new.dev_num = document.getElementById("dev_num").value;
	buymore_new.dev_prise = document.getElementById("dev_prise").value;
	buymore_new.dev_period = document.getElementById("dev_period").value;
	buymore_new.charge_account = document.getElementById("charge_account").value;
	buymore_new.manager_account = document.getElementById("manager_account").value;
	buymore_new.dev_auth = document.getElementById("dev_auth").value;
	// var s ="";
		
	// for (var p in buymore_new) {
	// 	s= s+"n "+p+": "+buymore_new[p];
	// }
	// alert(s);
	mui.openWindow({
		url:'buy.html',
		extras:{
			buymore_new:buymore_new,
			fin_flag:1,
		}
	});
}
	

function quit(){
	mui.init();
	mui.openWindow({
		url:'buy.html',
		extras:{
			buymore_new:null,
			fin_flag:0,
		}
	});
}
