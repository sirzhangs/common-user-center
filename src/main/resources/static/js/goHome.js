$(function() {

	// 1.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();

});

var ButtonInit = function() {
	var oInit = new Object();
	var postdata = {};

	oInit.Init = function() {
		// 初始化页面上面的按钮事件
		var count = 15;
		var timer = setInterval(() => {
			$(".time").text(count);
			if(count == 0){
				clearTime();
				location.href="/home";
			}
			count--;
		}, 1000);
		function clearTime() {
			clearInterval(timer);
		}
	};

	return oInit;
};