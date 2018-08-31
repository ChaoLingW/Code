<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<form action="login" method="post">

		用户名：<input type="text" name="name"><br> 密&nbsp;&nbsp;码： <input
			type="password" name="pwd"><br> 验证码：<input type="text"
			name="vCode"><br> <img id="img" src="image" /> <a
			href='#' onclick='javascript:changeCode()'><label
			style="color: red;">看不清？</label></a><br> <input type="submit"
			value="登录">
	</form>

	<script type="text/javascript">
		function changeCode() {
			document.getElementById("img").src="image?date=" + new Date();
		}
	</script>
</body>
</html>