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
<title>Deal List</title>
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
   <%@ include file="../nav.jsp" %>
	<hr/>
	代办任务
	<hr />
	<table width="75%">
		<thead>
			<tr>
			    <th>Task Id</th>
				<th>Task Name</th>
				<th>Created Time</th>
				<th>Operation</th>
			</tr>
		</thead>
		<c:forEach var="task" items="${tasks}">
			<tr>
			    <td><c:out value="${task.id }" /></td>
				<td><c:out value="${task.name }" /></td>
				<td><fmt:formatDate value="${task.createTime}"
						pattern="yyyy-MM-dd" /></td>
				<td>
				  	<a href="productController.do?claimTask&taskId=${task.id}">领取任务</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>