<%@page import="com.st.curd.pojo.GeoHierPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
<h1><marquee><font color="red">GeoHierDetails</font></marquee></h1>



<table border="2" bordercolor="red">
<tr>
<td>Name</td>
<td>EntityType</td>
<td>Code</td>
<td>Status</td>
</tr>

<c:forEach items="${geoList }" var="obj">
<tr><td><a href="getGeoHier.do?id=${obj.id}">${obj.name }</td>
<td>${obj.entitytype }</td>
<td>${obj.code }</td>
<td>${obj.status }</td>
</tr>
</c:forEach>
</table>



<%	Integer pageno=(Integer)session.getAttribute("pageno"); 
if(pageno==1){
%>
<a href="#">PREVIOUS</a>

<%}else {%>
<a href="getprevpage.do">PREVIOUS</a>

<%} %>


 ||<%=pageno %>||



<%String end=(String)session.getAttribute("end"); 
if(end!=null&&end.equals("yes"))
{%>
<a href="#">Next</a>
<%}
else{ %>
<a href="getnextpage.do">Next</a>

<%} %>


</body>
</html>