<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登入頁面</title>
<meta charset="UTF-8">
<title>This is Administrator's login page</title>
</head>
<body>
	<div>
		<form name="logIn" method="POST"
			action="<%=request.getContextPath()%>/administer_logIn">
			<p>
				Account: <input type="text" name="name"><br />
			<p>
				Password: <input type="text" name="Password"><br />
			<br><br/>
				<input name="button" type="submit" value="Log in" > 
				<input type="hidden" name="action" value="log_in" >
				
		</form>
		
		
		<form name="Sing_in" method="POST"
			action="<%=request.getContextPath()%>/administer_logIn">
				<input name="button" type="submit" value="Sign in" > 
				<input type="hidden" name="action" value="Sign_in" >
		</form>
		
		
		
		<a>forgetting password</a>
	</div>
</body>
</html>