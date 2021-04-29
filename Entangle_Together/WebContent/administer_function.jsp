<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<%@ page import="java.util.* ,Entity.Membership"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<!-- 管理者介面 -->
	<% 
	    String user = (String)session.getAttribute("name");
		
		System.out.println("我是user：" + user);
	
	%>
	
	 <h3>Hello World , <%=(String)session.getAttribute("name")%> 世界你好 ! 這個是管理者介面 </h3>
	
	<%
		System.out.println("我是administer_function.jsp，我有被獨到");
	%>


	<form name="FunctionList"
		action="<%=request.getContextPath()%>/administer_logIn" method="POST">
		<input type="hidden" name="action" value="select_all"> <input
			type="submit" value="查詢全部會員">
	</form>
	
	
	
	<%
		List<Membership> list = (List<Membership>) request.getAttribute("list");
		pageContext.setAttribute("list", list);
		System.out.println(list);
	%>
	

	<c:if test="${list != null}">
		<jsp:include page="/membershipData.jsp" flush="true" />
	</c:if>


</body>
</html>