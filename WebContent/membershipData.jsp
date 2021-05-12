<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ page import="java.util.* ,Entity.Membership"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>MembershipData</title>
</head>
<body>

<% System.out.println("我是membershipData，資料有近來喔"); %>
<font size="+2">會員資料 </font>
<hr><p><center>

<table border="1" width="720">
	<tr bgcolor="#999999">
		<th width="200">Account</th>
		<th width="100">Nick Name</th>
		<th width="100">Email</th>
		<th width="100">Status</th>
		<th width="100">Rank</th>
		<th width="120">function</th>
	</tr>


<% List<Membership> list = (List<Membership>) request.getAttribute("list"); %>
<% System.out.println("應該要有memberShip的DATA :" + list); %>
<%-- --%>

<% for (int i = 0; i < list.size(); i++) {
 			Membership mem = list.get(i); 
  			String account = mem.getAccount();
  			String nickname = mem.getNickname();
  			String email = mem.getEmail();
  			String status = mem.getStatusDescription();
  			int rank = mem.getFiveStartsRank();
  			int id = mem.getId();
 %>  
  <tr>  
		<td width="200"><div align="center"><b><%=account%></b></div></td>
		<td width="100"><div align="center"><b><%=nickname%></b></div></td>
		<td width="100"><div align="center"><b><%=email%></b></div></td>
		<td width="100"><div align="center"><b><%=status%></b></div></td>
		<td width="100"><div align="center"><b><%=rank%></b></div></td>
		
				 
		
		<form method="POST" action="<%=request.getContextPath()%>/administer_logIn">
				<td width="100"><div align="center"><input name="button" type="submit" value="check" ></div></td>
				<input type="hidden" name="action" value=<%="check_OneMember" %>  >
				<input type="hidden" name="id" value=<%= id %>>
				
		</form>
		
		
				
				<% System.out.println("我想拿ID："+ id); %>
		<% %>
 </tr>  
<% 
 }
%>



</table>

</body>
</html>