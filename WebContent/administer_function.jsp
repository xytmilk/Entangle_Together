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
	<!-- �޲z�̤��� -->
	<% 
	    String user = (String)session.getAttribute("name");
		
		System.out.println("�ڬOuser�G" + user);
	
	%>
	
	 <h3>Hello World , <%=(String)session.getAttribute("name")%> �@�ɧA�n ! �o�ӬO�޲z�̤��� </h3>
	
	<%
		System.out.println("�ڬOadminister_function.jsp�A�ڦ��Q�W��");
	%>


	<form name="FunctionList"
		action="<%=request.getContextPath()%>/administer_logIn" method="POST">
		<input type="hidden" name="action" value="select_all"> <input
			type="submit" value="�d�ߥ����|��">
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