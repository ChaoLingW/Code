<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red"><%=session.getAttribute("username") %></h1>

	<%
		int a = 1;
	%>

	<h1>JSP中可以出项多个脚本片段</h1>
	<%
		int b = a + 2;
	%>

	<!-- jsp内置对象out -->

	<%
		out.print(b);
	%>
	<!--JSP表达式,没有;  -->
	<%=b%>
	<%=new Date()%>

	<!-- 在脚本片段中，可以写流程控制语句 -->

	<%
		for (int i = 0; i < 10; i++) {
			out.println("<span style='color:red'>" + i + "</span>");
		}
	%>

	<%
		for (int i = 0; i < 10; i++) {
	%>

	<span style='color: red'> <%=i%></span>
	<%
		}
	%>

	<!-- if -->
	<%
		if (b > 2) {
	%>
	<span style="color: green"><%=b%></span>
	<%
		} else {
	%>
	<span style="color: red"><%=b%></span>

	<%
		}
	%>

	<%!//成员变量
	private String name = "Jack";

	public void aa() {
		System.out.println("hello!");
	}%>

	<%-- jsp注释 忽略，不会在Java文件中--%>
	<!-- html的注释 -->

	<%@ include file="/include.jsp"%>

	<!-- forward动作标签 -->

	<%-- <jsp:forward page="/include.jsp"></jsp:forward> --%>
	<hr>
	<%=pageContext.getAttribute("name")%>
	<%=request.getAttribute("name")%>
	<%=session.getAttribute("name")%>
	<%=application.getAttribute("name")%>
	


</body>
</html>