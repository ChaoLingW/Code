<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
	// http :// localhost:8080/v1_LoginDemo_servlet
%> 
<!DOCTYPE html>
<html lang="en">
<head>
	<title>注册用户</title>
    <meta charset="UTF-8">
    <base href="<%=basePath %>">
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/calendar.js"></script>
	<link type="text/css" rel="stylesheet" href="css/calendar-blue.css"></link>
</head>
<body>
	<div id="wrap">
		<div id="top_content">

			<div id="header">
				<div id="rightheader">
					<p>
						2018年8月 <br />
					</p>
				</div>

				<div id="topheader">
					<h1 id="title">
						<a href="#">我爱登陆</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>

					<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册新用户
					</h1>
					<p>
						&nbsp;
					</p>

			<form action="login/RegServlet" method="post" >
				<table>
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username" value="${regUser.username }"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input type="password" name="pwd1"></td>
					</tr>
					<tr>
						<td>性别：</td>
						<td>
							<input type="radio" name="sex" value="1" checked="checked">男
							<input type="radio" name="sex" value="0">女
							<span id="sex_span"></span>
						</td>
					</tr>
					<tr>
						<td>个人爱好：</td>
						<td>
							<input type="checkbox" name="love" value="文学">文学
							<input type="checkbox" name="love" value="影视">影视
							<input type="checkbox" name="love" value="音乐">音乐
							<input type="checkbox" name="love" value="体育">体育
						</td>
					</tr>
					<tr>
						<td>出生日期：</td>
						<td>
							 <input type="text" id="birthday" name="birthday" >
						</td>
					</tr>
					<tr>
						<td>地址：</td>
						<td><input type="text" name="address" value=""></td>
					</tr>
					<tr>
						<td>邮箱：</td>
						<td><input type="text" name="email" value=""></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" name="update" value="提交" class="button">
						<input type="reset" name="reset" value="重置" class="button">
						</td>
					</tr>
				</table>
			</form>
				</div>
			</div>

		<div id="footer">
			<div id="footer_bg">whatisJavaWeb@hope-pact.com</div>
		</div>
	</div>
</body>

<script type="text/javascript">

Calendar.setup({
inputField : "birthday",
ifFormat : "%Y-%m-%d",
showsTime : true,
timeFormat : "24"
});
</script>
</html>
