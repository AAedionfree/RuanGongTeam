function is_special(a) {
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
