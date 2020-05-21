var buy_new = new Array();
var buy_history = new Array();
var new_len=0;
function to_buymore(){
	mui.init();
	is_first=1;
	mui.openWindow({
		url:'buymore.html',
	});
}
	
function load_new(){
	mui.init();	
		  // window.preload()=function(){
			 mui.plusReady(function(){
					var buy_more = plus.webview.currentWebview();
					 var flag=buy_more.fin_flag;
					 var buymore_new=buy_more.buymore_new;
					 // var s ="";
					 	
					 // for (var p in buy_more) {
					 // 	s= s+"n "+p+": "+buy_more[p];
					 // }
					 // alert(s);
					 alert(flag);
		 			if(flag==1){
						buy_new[new_len]=buymore_new;
						new_len++;
						var temp_new= document.getElementById('temp_new').innerHTML;
						document.getElementById('buy_new').innerHTML = template(temp_new,{list:buy_new});
					} 
						
					else if(flag==0){
						return;
						
					}
		 			 // var s ="";
		 			 	
		 			 // for (var p in user) {
		 			 // 	s= s+"n "+p+": "+user[p];
		 			 // }
		 			 // alert(s);
		         });
}