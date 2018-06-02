<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>List</title>
<style>
table {
	border-collapse: collapse;
	text-align: center;
}

table td {
	border: 1px solid #F00;
}

table th {
	border: 1px solid #F00;
	background-color: gray;
}
</style>
</head>
<body>
   <%@ include file="nav.jsp" %>
	<hr/>
	 有效的产品表
	<hr />
	<table width="75%">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Status</th>
				<th>Created Time</th>
			</tr>
		</thead>
		<c:forEach var="product" items="${products}">
			<tr>
				<td><c:out value="${product.name }" /></td>
				<td><c:out value="${product.description }" /></td>
				<td><c:out value="${product.statusName }" /></td>
				<td><fmt:formatDate value="${product.createdTime}"
						pattern="yyyy-MM-dd" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>