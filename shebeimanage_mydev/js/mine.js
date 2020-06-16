function quit_login() {
		mui.plusReady(function() {
			var curr = plus.webview.currentWebview();
			var wvs = plus.webview.all();

			for (i = 0, len = wvs.length; i < len; i++) {

				if (wvs[i].getURL() != curr.getURL()) {
					plus.webview.close(wvs[i]);
				}
			}
			plus.webview.open('index.html');
			curr.close();
		});
	}


	function to_myinfo(user) {
		mui.init();
		mui.openWindow({
			url: 'myinfo.html',
			extras: {
				user: user,
			}
		});
	}
	function to_email(user) {
		mui.init();
		mui.openWindow({
			url: 'email.html',
			extras: {
				user: user,
			}
		});
	}
	function to_about() {
		mui.init();
		mui.openWindow({
			url: 'about.html',
		});
	}

	function to_question(user) {
		mui.init();
		mui.openWindow({
			url: 'question.html',
			extras: {
				user: user,
			}
		});
	}
