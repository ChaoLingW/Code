<%@page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--  判断是否已完成登录 -->
<c:if test="${empty user }">
	<c:redirect url="/login.jsp"></c:redirect>
</c:if>

<!DOCTYPE html>
<html lang="en">
<head>
<title>修改用户</title>
<meta charset="UTF-8">
<base href="<%=basePath%>">
</head>
<body>

	<h1>修改用户</h1>
	<p>&nbsp;</p>

	<form name = "form" method="post">
		<input type="hidden" name="id" value=<%=request.getParameter("id")%> />
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
			<td>性别：</td>
				<td>
				<input type="radio" name="sex" value="男" />男 
				<input type="radio" name="sex" value="女" />女 <span id="sex_span"></span>
				</td>
			</tr>
			<tr>
				<td>真实姓名：</td>
				<td><input type="text" name="realName" value="" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置" /> <input type="button"
					value="修改" /></td>
			</tr>

		</table>
	</form>
</body>
<script src='<c:url value="/js/jquery-3.1.1.min.js" />'></script>

<script type="text/javascript">
$().ready(function() {
	
	$("input[type='button']").click(
		function() {
			
			username = $("input[name='username']").val;
			password = $("input[name='password']").val;
			sex = $("input[name='sex']").val;
			realName = $("input[name='realName']").val;
			alert(username);
			if (username==''&&password==''&&sex==null&&realName==''){
				alert("必须修改一项");
				//return;
			}
			//alert(username + password + sex + realName);
			document.form.action = "<%=request.getContextPath()%>/userServlet?action=updateById";
			document.form.submit();
		}		
	)
	
	
})
</script>
</html>
