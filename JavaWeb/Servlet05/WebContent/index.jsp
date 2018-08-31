<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	这是主页:
	<br />

	<c:choose>
		<c:when test="${empty sessionScope.user }">

			<form name="f1" action="<c:url value='/LoginServlet'/>" method="post">
				Name:<input type="text" name="name"><br /> Pwd:<input
					type="text" name="pwd"><br /> <input type="checkbox"
					value="1" name="autoLogin">自动登录(小心选择)<br /> <input
					type="submit" value="登录">
			</form>
		</c:when>
		<c:otherwise>
		
		欢迎:${user.name }<br />
			<a href="<c:url value='/jsps/q.jsp'/>">Query</a>
	|
	<a href="<c:url value='/jsps/add.jsp'/>">Add</a>
	|
	<a href="<c:url value='/jsps/del.jsp'/>">Del</a>
	|<!-- 1:删除session中的数据，2：删除cookie -->
			<a href="<c:url value='/ExitServlet'/>">退出</a>
		</c:otherwise>
	</c:choose>





</body>
</html>