<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Home</title>
</head>
<body>
  <form action="loginController.do">
    <input type="hidden" name="home"/>
    name:
    <select name="loginName">
       <option id="lisi">lisi</option>
       <option id="low0">low0</option> 
       <option id="low1">low1</option>
       <option id="hi0">hi0</option> 
       <option id="hi1">hi1</option>
    </select>
    <input type="submit" value="Login"/>
  </form>
</body>
</html>