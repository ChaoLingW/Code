$(document).ready(function() {

	var isPass1 = false;
	var isPass2 = false;
	var isPass3 = false;
	var isPass4 = false;
	
	$("#userName").focus(function() {
		//获取焦点
		$(this).addClass("focus")
	}).blur(function() {
		//失去焦点
		//1.正则表达式
		var pattern = /^[a-zA-Z]{1}[a-zA-Z0-9]{5,19}$/;
		if(!pattern.test($(this).val())) {
			//不符合
			//文本框变红
			$(this).addClass("blur");
			//span内容改为用户名有误，颜色有误
			$(this).next().text("用户名格式有误").removeClass("default").addClass("fail");
		} else {
			$(this).removeClass();
			$(this).next().text("√").removeClass().addClass("success");
			isPass1 = true;
		}

	})

	$("#userPwd").focus(function() {
		$(this).addClass("focus")
	}).blur(function() {
		var pattern = /^[a-zA-Z0-9]{6,20}$/;
		if(!pattern.test($(this).val())) {
			$(this).addClass("blur");
			$(this).next().text("密码格式有误").removeClass("default").addClass("fail");
		} else {
			$(this).removeClass();
			$(this).next().text("√").removeClass().addClass("success");
			isPass2 = true;
		}
	})

	$("#userSPwd").focus(function(){
		$(this).addClass("focus")
	}).blur(function(){
		if($(this).val()!= $("#userPwd").val()){
			$(this).addClass("blur");
			$(this).next().text("两次密码不一致").removeClass("default").addClass("fail");
		} else {
			$(this).removeClass();
			$(this).next().text("√").removeClass().addClass("success");
			isPass3 = true;
		}
	})
	
	$("#userEmail").focus(function(){
		$(this).addClass("focus")
	}).blur(function(){
		var pattern=/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
		if(!pattern.test($(this))){
			$(this).addClass("blur");
			$(this).next().text("邮箱格式不正确").removeClass("default").addClass("fail");
		} else {
			$(this).removeClass();
			$(this).next().text("√").removeClass().addClass("success");
			isPass4 = true;
		}
	})
	
	/**
	 * 提交
	 */
	$("#btnRegister").click(function(){
		if(isPass1&&isPass2&&isPass3&&isPass4){
			//提交
			$("form").submit();
		} else {
			//提交
			alert("信息有误，无法注册");
		}
		
	})
});
