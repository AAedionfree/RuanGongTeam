function is_special_more5(a) {
	var flag = 0;
	if(a.length < 5){
		flag = 2;
		return flag;
	}
	for (var i = 0; i < a.length; i++) {
		if ((0 <= a[i] && a[i] <= 9) || ('a' <= a[i] && a[i] <= 'z') || ('A' <= a[i] && a[i] <= 'Z')) {
				continue;

			} else {
				flag = 1;
			}
		}
	return flag;
}

function is_special(a){
	var flag = 0;
	for (var i = 0; i < a.length; i++) {
		if ((0 <= a[i] && a[i] <= 9) || ('a' <= a[i] && a[i] <= 'z') || ('A' <= a[i] && a[i] <= 'Z')) {
				continue;
	
			} else {
				flag = 1;
			}
		}
	return flag;
}	
function is_num(a){
	var flag = 0;
	for (var i = 0; i < a.length; i++) {
		if ((0 <= a[i] && a[i] <= 9)) {
				continue;
	
			} else {
				flag = 1;
			}
		}
	return flag;
	
}
