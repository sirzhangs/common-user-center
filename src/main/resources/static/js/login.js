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
//		$(".login-button").click(function() {
//			var param = {
//				"loginAccount" : $("#loginAccount").val(),
//				"userPassword" : $("#userPassword").val()
//			};
//			console.log("哈哈");
//			$.ajax({
//				type : "POST",
//				url : "http://localhost:12001/user/manage/signIn",
//				contentType : "application/json",
//				data : JSON.stringify(param),
//				success : function(msg) {
//					alert("Data Saved: " + msg);
//				}
//			});
//		});
	};

	return oInit;
};