<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>使用账号“abc/123”登录系统,感受惊喜</h1>
	<form action="userServlet?action=login" method="post">
		<h1>username:</h1>
		<input type="text" name="username"><br>
		<h1>password:</h1>
		<input type="text" name="password"><br>
		
		<input type="submit" value="提交">
		
	</form>
	
	${msg }
</body>
</html>