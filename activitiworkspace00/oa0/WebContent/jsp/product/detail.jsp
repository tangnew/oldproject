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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
	Detail
	<hr />
	<table width="55%">
		<tbody>
			<tr>
				<td>Name</td>
				<td><c:out value="${product.name }" /></td>
			</tr>
			<tr>
			    <td>Description</td>
				<td><c:out value="${product.description }" /></td>
			</tr>
			<c:choose>
			  <c:when test="${transitions != null and fn:length(transitions) > 0 }">
				  <tr>
				    <td colspan="2">
				      <form action="productController.do">
				         <input type="hidden" name="dealWithTask"/>
				         <input type="hidden" name="taskId"  value="${taskId}"/>
				         <c:forEach var="transition" items="${transitions}">
				         <input type="submit" name="transition" value="${transition}"/>
				       </c:forEach>
				       </form>
				    </td>
				   </tr>
			  </c:when>
			  <c:otherwise>
			   <tr>
			    <td colspan="2">
			      <form action="productController.do">
			         <input type="hidden" name="dealWithTask"/>
			         <input type="hidden" name="taskId"  value="${taskId}"/>
			         <input type="submit" name="transition" value="提交"/>
			       </form>
			    </td>
			   </tr>
			  </c:otherwise>
			</c:choose>
		</tbody>
	</table>

</body>
</html>