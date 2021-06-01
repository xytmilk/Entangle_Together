<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="java.util.* ,Entity.Membership"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>account detail</title>
</head>
<body>

<% List<Membership> list = (List<Membership>)request.getAttribute("mem"); %>
<% System.out.println("我是oneMember.jsp"); %>
<% System.out.println(list); %>


<% for (int i = 0; i < list.size(); i++) {
 			Membership mem = list.get(i); 
  			
 			
 			int id = mem.getId();
 			String account = mem.getAccount();
 			String password = mem.getPassword();
 			String realName = mem.getRealName();
 			String IdNumber = mem.getIdNumber();
 			byte[] photo = mem.getPhoto();
  			String email = mem.getEmail();
  			String authority = mem.getAuthority();
  			String statusDescription = mem.getStatusDescription();
  			int points = mem.getPoints();
  			int bankAccount = mem.getBankAccount();
  			int rank = mem.getFiveStartsRank();
  			String nickname = mem.getNickname();
  			java.sql.Date createdDate = mem.getCreatedDate();
  			java.sql.Date updateDate = mem.getUpdateDate();
  			
 %> 

<% System.out.println("我是Onemember.jsp，資料有近來喔"); %>
<div align="center"><font size="+2">Welcome <%=(String)session.getAttribute("name") %> </font></div>
<hr><p>

<div align="center"><b>Account: <%=account%></b></div>
<div align="center"><b>Password:<%=password%></b></div>
<div align="center"><b>Real Name:<%=realName%></b></div>
<div align="center"><b>Id Number:<%=IdNumber%></b></div>
<div align="center"><b>photo:<%=photo%></b></div>
<div align="center"><b>Email:<%=email%></b></div>
<div align="center"><b>Authority:<%=authority%></b></div>
<div align="center"><b>Status Description:<%=statusDescription%></b></div>
<div align="center"><b>points:<%=points%></b></div>
<div align="center"><b>Bank Account:<%=bankAccount%></b></div>
<div align="center"><b>Rank:<%=rank%></b></div>
<div align="center"><b>Nickname:<%=nickname%></b></div>
<div align="center"><b>Created Date:<%=createdDate%></b></div>
<div align="center"><b>Update Date:<%=updateDate%></b></div>



<%} %>



</body>
</html>