function load_xian(){
	// document.getElementById("").innerHTML=user.username; 
}
	
function to_myequ(user){
	mui.init();
	mui.openWindow({
		url:'myequipment.html',
		extras:{
			user:user,
		}
	});
}
function to_arrange(user){
	mui.init();
	mui.openWindow({
		url:'arrange.html',
		extras:{
			user:user,
		}
	});
}
function to_mine(user){
	mui.init();
	mui.openWindow({
		url:'mine.html',
		extras:{
			user:user,
		}
	});
}
function to_main(user){
	mui.init();
	mui.openWindow({
		url:'main.html',
		extras:{
			user:user,
		}
	});
}
function to_search(user){
	mui.init();
	mui.openWindow({
		url:'search.html',
		extras:{
			user:user,
		}
	});
}