<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--pageContext: 获取其他的内置对象  -->

	<%
		ServletRequest req = pageContext.getRequest();//request
		boolean isReq = (req == request);
	%>
	<%=isReq%>

	<!-- 四大作用域 pageContext request session application -->
	<%
		pageContext.setAttribute("name", "zhangsan");
	%>

	<%=pageContext.getAttribute("name")%>
	<%=request.getAttribute("name")%>
	<%=session.getAttribute("name")%>
	<%=application.getAttribute("name")%>
	<a href="index.jsp">index.jsp</a>

	<!-- pageContext设置指定范围的属性 -->
	<%
		pageContext.setAttribute("sex", "男", PageContext.SESSION_SCOPE);
		pageContext.getAttribute("sex", PageContext.SESSION_SCOPE);
	
		pageContext.forward("/index.jsp");
		
	
	
	%>
	
	
	

</body>
</html>