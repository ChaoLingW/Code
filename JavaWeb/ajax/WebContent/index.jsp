<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/js/jquery-3.1.1.js">
	
</script>

<script type="text/javascript">


$(function() {
	//id为username的元素失去焦点的时候向服务器发送请求
	$("#username").blur(function() {

		//向服务器发送ajax请求
		$.ajax({
			//请求的url
			url : "${pageContext.request.contextPath}/one",
			//请求的方式
			type : "post",
			//数据
			data : {
				"username":$("#username").val()
			},
			//服务器返回的数据类型
			dataType:"json",
			//async 是否异步
			//contentType 编码
			
			//success：成功之后的操作，参数为函数
			success:function(data){
				var flag = data.flag;
				
				if(flag == 1) {
					
					$("#errInfo").text("存在此用户");
				}
			}
			
		})

	})
})
</script>


<title>Insert title here</title>
</head>
<body>

	<input type="text" id="name" value="点击按钮后看我变身">
	<button>点我</button>
	<hr>

	<form id="form1" action="" method="post">
		用户名<input id="username" type="text" name="username" /> <span
			style="color: red" id="errInfo"></span><br /> <input type="button"
			id="btn" value="注册" />
	</form>

</body>
</html>