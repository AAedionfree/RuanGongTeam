	
function quit_login(){
	mui.plusReady(function () {
	    var curr = plus.webview.currentWebview();
		var wvs = plus.webview.all();
			
		for(i=0,len=wvs.length;i<len;i++){
				
			if(wvs[i].getURL()!=curr.getURL()){
				plus.webview.close(wvs[i]);
			}
		}
		plus.webview.open('index.html');
		curr.close();
	});
}