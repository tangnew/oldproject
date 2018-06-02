<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Add</title>
<style>
table {
	border-collapse: collapse;
}

table td {
	border: 1px solid #F00;
}
</style>
</head>
<body>
	 <%@ include file="nav.jsp" %>
	 <hr/>
	添加产品
	<hr />
	<form action="productController.do">
		<input type="hidden" name="save" />
		<table border="1">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea name="description" cols="100"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>