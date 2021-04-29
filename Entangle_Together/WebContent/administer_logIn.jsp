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
				Administrator's Name: <input type="text" name="name"><br />
			<p>
				Adiministrator's Password: <input type="text" name="Password"><br />
				<input name="button" type="submit" value="submit" > <input
					type="hidden" name="action" value="log_in" >
		</form>
		<a>forgetting password</a>
	</div>
</body>
</html>