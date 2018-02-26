<%@page import="com.st.curd.pojo.GeoHierPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
<h1><marquee><font color="red">GeoHierDetails</font></marquee></h1>
<font color="white">
<table bordercolor="red" border="2">

<tr>
<th>Name</th>
<th>EntityType</th>
<th>Code</th>
<th>Status</th>
</tr>
<%List<GeoHierPojo> geoList=(List<GeoHierPojo>)request.getAttribute("geoList");
for(GeoHierPojo geo:geoList){
%>
<tr>
<td><a href="getGeoHier.do?id=<%=geo.getId()%>"><%=geo.getName()%></a></td> 
<td><%=geo.getEntitytype() %></td>
<td><%=geo.getCode() %></td>
<td><%=geo.getStatus() %></td>
</tr>

<%} %>
</table>
</font>
</body>
</html>