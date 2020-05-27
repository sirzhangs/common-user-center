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
		$(".checkcode-btn").click(function() {

			var telephone = $(".phone-text input").val();
			console.log("哈哈" + telephone);
			
			if(telephone == ""){
				console.log(telephone);
				return;
			}

			$.ajax({
				type : "GET",
				url : "/user/manage/sendCode/",
				data : {
					"telephone":telephone,
					"type":300,
				},
				success : function(msg) {
					alert("Data Saved: " + msg);
				}
			});
		});
		
		/*$(".register-button").click(function() {

			console.log("哈哈");
			var param = {
				"userName" : $("#userName").val(),
				"userPassword" : $("#userPassword").val(),
				"telephone" : $("#telephone").val(),
				"code" : $("#checkcode").val()
			};

			$.ajax({
				type : "POST",
				url : "/user/manage/register",
				contentType : "application/json",
				data : JSON.stringify(param),
				success : function(msg) {
					alert("Data Saved: " + JSON.stringify(msg));
				}
			});
		});*/
	};

	return oInit;
};