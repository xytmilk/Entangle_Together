<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.* ,Entity.Membership"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>welcome new member</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>
</head>

<body bgcolor='white'>
	<table id="table-1">
	<tr><td>
		 <h3>welcome new member</h3></td><td>
		 <h4><a href="administer_logIn.jsp">Back</a></h4>
	</td></tr>
</table>

<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/administer_logIn" name="add new member">
<table>
	<tr>
		<td>Account:</td>
		<td><input type="TEXT" name="account" size="45" maxlength="20"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="TEXT" name="password" size="45" maxlength="20"></td>
	</tr>
	<tr>
		<td>Nickname：</td>
		<td><input type="TEXT" name="nickname" size="45" maxlength="30"></td>
	</tr>
	<tr>
		<td>Real Name:</td>
		<td><input type="TEXT" name="realName" size="45" maxlength="30"></td>
	</tr>
	<tr>
		<td>Personal ID:</td>
		<td><input type="TEXT" name="idNumber" size="45" maxlength="10"></td>
	</tr>
	<tr>
		<td>Photo:</td>
		<td><input type="TEXT" name="photo" size="45"></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="email" name="email" size="45"></td>
	</tr>
	<tr>
		<td>Personal Description：</td>
		<td><input type="TEXT" name="statusDescription" size="45" maxlength="500"></td>
	</tr>
	<tr>
		<td>Bank Account：</td>
		<td><input type="TEXT" name="bankAccount" size="45"></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="Join us Quickly"></FORM>


</body>
</html>