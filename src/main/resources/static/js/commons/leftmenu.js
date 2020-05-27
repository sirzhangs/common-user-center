$(function() {

    // 1.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});

var ButtonInit = function() {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function() {
        // 初始化页面
        console.log("哈哈");
        $.ajax({
            type: "POST",
            url: "http://localhost:12001/menu/getLeftMenu",
            contentType: "application/json",
            success: function(data) {
                $(".commonMenu").html(data);
            }
        });
    };

    return oInit;
};