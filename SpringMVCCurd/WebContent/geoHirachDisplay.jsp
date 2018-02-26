<%@page import="com.st.curd.pojo.GeoHierPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function test() {
	alert("your details are success fully submited");
	document.forms[0].action="saveGeoHirach.do";
	document.forms[0].submit();
}
function getAllGeoHier() {
	alert("your details are displayed");
	document.forms[0].action="geoHierList.do";
	document.forms[0].submit();
	
}
function update() {
	alert("update");
	document.forms[0].action="updateGeoHier.do";
	document.forms[0].submit();
	
}
function deletegeo() {
	alert("delete");
	document.forms[0].action="deleteGeoHier.do";
	document.forms[0].submit();
	
}



</script>
</head>
<body background="1.jpg">
<%GeoHierPojo geo=(GeoHierPojo)request.getAttribute("geo"); %>
<form action="saveGeoHirach.do">
ID:<input type="text" name="id" value="<%=geo.getId()%>" readonly="readonly"><br>
Name:<input type="text" name="name" value="<%=geo.getName()%>"><br>
EntityType:<input type="text" name="entitytype" value="<%=geo.getEntitytype() %>"><br>
Code:<input type="text" name="code" value="<%=geo.getCode() %>"><br>
Status:<input type="text" name="status" value="<%=geo.getStatus() %>"><br>
<input type="button" value="submit" onclick="test()">
<input type="button" value="GETALL" onclick="getAllGeoHier()">
<input type="button" value="Update" onclick="update()">
<input type="button" value="Delete" onclick="deletegeo()"> 


</form>
</body>
</html>