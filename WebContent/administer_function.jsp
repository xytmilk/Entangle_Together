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
	
		<!-- 20210430
		因為你下面的是用 jsp:include 進來頁面，我印象中要用 requestScope 才能把資料傳到 include的頁面中
		用pageContext好像傳不進去，所以我幫你改成request了
		
		1.從 servlet來的資料要先取出【List<Membership> list = (List<Membership>) request.getAttribute("list");】
		2.然後把取出的資料放到JSP的頁面中【request.setAttribute("list", list);】
		3.最後c:if 要用的時候，從你放進去的scope【requestScope】中取出來用【test="${requestScope.list != null}"】
	 -->

	<%
		List<Membership> list = (List<Membership>) request.getAttribute("list");
		request.setAttribute("list", list);
		System.out.println(list);
	%>
	

	<c:if test="${requestScope.list != null}">
		<jsp:include page="/membershipData.jsp" flush="true" />
	</c:if>


</body>
</html>