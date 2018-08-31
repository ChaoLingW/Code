<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  int x=5; %>
 <%! int x=7; %> 
 <%! int getX(){ return x; } %> 
 <% out.print("X1=" + x);      %>
  <%  out.print("X2=" + getX());   %>
</body>
</html>