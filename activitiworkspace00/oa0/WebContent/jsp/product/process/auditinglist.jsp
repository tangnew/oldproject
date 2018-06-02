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
	<%@ include file="../nav.jsp"%>
	<hr />
	审核中的申请
	<hr />
	<table width="75%">
		<thead>
			<tr>
			    <th>Product Id</th>
			    <th>Product Name</th>
			    <th>Product Created User</th>
			    <th>Product Created Time</th>
			    <th>Task Id</th>
				<th>Task Name</th>
				<th>Task Accept Created Time</th>
				<th>Operation</th>
			</tr>
		</thead>
		<c:forEach var="product" items="${products}">
			<tr>
			   <td><c:out value="${product.id }" /></td>
			   <td><c:out value="${product.name }" /></td>
			   <td><c:out value="${product.userName }" /></td>
			   <td>
			      <fmt:formatDate value="${product.createdTime}"
						pattern="yyyy-MM-dd" />
			   </td>
			   <td><c:out value="${product.task.id }" /></td>
			   <td><c:out value="${product.task.name }" /></td>
			   <td>
			      <fmt:formatDate value="${product.task.createTime}"
						pattern="yyyy-MM-dd" />
			    </td>
				<td>
				  	<a href="productController.do?aduitTaskDetail&taskId=${product.task.id}">查看详细信息</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>