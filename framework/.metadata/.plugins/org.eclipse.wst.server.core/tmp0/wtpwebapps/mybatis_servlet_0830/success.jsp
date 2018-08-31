<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.hpe.po.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!--  判断是否已完成登录 -->
<c:if test="${empty user }">
	<c:redirect url="/login.jsp"></c:redirect>
</c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src='<c:url value="/js/jquery-3.1.1.min.js" />'></script>

<body>
	${msg }
	<h1>欢迎你，${user.username }</h1>
	<h1>用户列表</h1>
	<!-- 模糊查询表单 -->
	<form name="form" method="post">
		<table class="condition">
			<tr>
				<td>用户名</td>
				<td><input type="text" name="username"
					value="${formUser.username }" /></td>
				<td>id</td>
				<td><input type="text" name="id" value="${formUser.id }" /></td>
				<td>性别</td>
				<td><select name="sex">
						<option value="">请选择</option>
						<option value="男">男</option>
						<option value="女">女</option>
				</select></td>

			</tr>
			<tr>
				<td><input type="reset" value="重置" /> <input type="button"
					value="查询" /></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td><input type="checkbox" id = "selectAll"></td>
			<td>id</td>
			<td>用户名</td>
			<td>密码</td>
			<td>性别</td>
			<td>真实姓名</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${users }" var="user" varStatus="num">
			<tr class="userInfo">
				<td><input type="checkbox"></td>
				<td class = "id">${user.id }</td>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td><c:if test="${user.sex == '男'}">男</c:if> <c:if
						test="${user.sex == '女'}">女</c:if></td>
				<td>${user.realName }</td>
				<td><a href="javascript:updateUser(${user.id })">修改</a> <a
					href="deleteUser(${user.id })">删除</a></td>
			</tr>
		</c:forEach>
	</table>

</body>

<script type="text/javascript">
//全选按钮
$().ready(function() {
	
	$(".condition input[type='button']").click(
		function() {
		
			document.form.action = "<%=request.getContextPath()%>/userServlet?action=select";
			document.form.submit();
		}		
	)
	
	$("#selectAll").click(
		function() {
		
			cheak = $(this).prop("checked"); 
			$(".userInfo input[type='checkbox']").prop("checked",cheak); 
			//alert(cheak);
			
		}		
	)
	
	
	
})

//修改方法
function updateUser(userId){

	document.form.action = "<%=request.getContextPath()%>/update.jsp"+ "?id=" + userId;
		document.form.submit();
	}
	
// 删除方法

function deleteUser(userId){

	document.form.action = "<%=request.getContextPath()%>/userServlet?action=deleteOne" + "&id=" + userId;

		document.form.submit();
	}
</script>
</html>