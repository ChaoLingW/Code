<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- c:out 输出信息到界面 -->
	<% request.setAttribute("name", "zhangsan"); %>
	${name }
	<c:out value="${name }" default="lisi"></c:out>

	<!-- c:set设置属性值 -->
	<c:set var="sex" value="男" scope="request"></c:set>
	${sex }
	
	<!-- c:remove 移除属性  -->
	<c:remove var="sex" scope="session"/>
	${sex }
	
	<%-- <!-- c:if 判断 test:表达式 -->
	<hr>
	<c:if test="${param.age <20 }">
		<span style="color:red">青年</span>
	</c:if>
	<c:if test="${param.age >=20 }">
		<span style="color:red">你已经老了</span>
	</c:if> --%>
	
	<!-- cwo -->
	<%-- <c:choose>
		<c:when test="${param.age <20 }"><span style="color:red">青年</span></c:when>
		<c:when test="${param.age <20 }"></c:when>
		<c:otherwise>
			NO 青年
		</c:otherwise>
	</c:choose> --%>
	
	<c:choose>
		<c:when test="${param.age <20 }"><span style="color:red">青少年</span></c:when>
		<c:when test="${param.age < 30}"><span style="color:red">青年</span></c:when>
		<c:when test="${param.age < 60 }"><span style="color:red">中年</span></c:when>
		<c:otherwise>
			老年
		</c:otherwise>
	</c:choose>
	
	<hr>
	<!-- c:foreach items：要遍历的集合或数组 var 变量名 保存每一次遍历的元素-->
	<c:forEach var="str" items="${array}" >
	${str }
	
	</c:forEach>
		
	<c:forEach var="str" items="${list }">
	${str }
	</c:forEach>
	
	<c:forEach items="${users}" var ="user" varStatus="status">
	
	${user.name }--${status.index }--${status.count }
	
	</c:forEach>
	
	<c:forEach items="${map}" var ="ma" >
	
	${ma.key } = ${ma.value.name }
	</c:forEach>
	
	
	
	
</body>
</html>