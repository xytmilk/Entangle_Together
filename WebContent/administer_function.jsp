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
	
		<!-- 20210430
		�]���A�U�����O�� jsp:include �i�ӭ����A�ڦL�H���n�� requestScope �~����ƶǨ� include��������
		��pageContext�n���Ǥ��i�h�A�ҥH�����A�令request�F
		
		1.�q servlet�Ӫ���ƭn�����X�iList<Membership> list = (List<Membership>) request.getAttribute("list");�j
		2.�M�����X����Ʃ��JSP���������irequest.setAttribute("list", list);�j
		3.�̫�c:if �n�Ϊ��ɭԡA�q�A��i�h��scope�irequestScope�j�����X�ӥΡitest="${requestScope.list != null}"�j
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