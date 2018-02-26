<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <table><tr><tiles:insertAttribute name="header"/></tr>
<tr><tiles:insertAttribute name="topmenu"/></tr>
<tr><table><tr><td class=con_left><tiles:insertAttribute name="leftmenu"/></td>
<td class=con_right><tiles:insertAttribute name="body"/></td></tr></table></tr>

</table>
<table><tr><tiles:insertAttribute name="footer"/></tr></table> --%>
<tiles:insertAttribute name="body"/>
</body>
</html>