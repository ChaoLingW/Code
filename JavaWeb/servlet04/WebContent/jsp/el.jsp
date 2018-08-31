<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		pageContext.setAttribute("name", "pageContext");
		request.setAttribute("name", "request");
		session.setAttribute("name", "session");
		application.setAttribute("name", "application");
	%>

	<!-- 方式一 -->
	<%
		out.println(request.getAttribute("name"));
	%>

	<!-- 方式二 -->
	<%=request.getAttribute("name")%>

	<hr>
	<!-- 方式三:el表达式 pageScope/requestScope/sessionScope/applicationScope.属性名的方式，精确查找-->
	${requestScope.name } ${sessionScope.name }
	
	
	<hr>
	${array[0]}
	${list[0] }
	
	<hr>
	${user.name }<!-- 调用的是getName() -->
	
	<hr>
	${users[1].name }
	
	<hr>
	${map.dw.age }
	
	<!-- 构建路径 -->
	<a href="two">twoServlet</a>

	${1 eq 1 }
	
	${empty users }
	${empty users1 }

</body>
</html>