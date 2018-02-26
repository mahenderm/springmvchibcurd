<%@page import="com.st.curd.pojo.GeoHierPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
function gotoAction(actionPath){
	document.forms[0].action=actionPath;
	document.forms[0].submit();
}


</script>
</head>
<body background="1.jpg">
<%//GeoHierPojo geo=(GeoHierPojo)request.getAttribute("geo"); %>
<%-- <table>
<tr>
<%@ include file="header.jsp" %>
</tr>
<tr>
<%@ include file="topmenu.jsp" %>
</tr>
<table>
<tr>
<td class="con_left">
<%@include file="leftmenu.jsp" %>
</td>


<td class="con_right">

 --%>


<form:form action="saveGeoHirach.do" method="post" commandName="geo">

<form:input type="hidden" path="id"/>
Name:<form:input type="text" path="name" /><br>
EntityType:<form:input type="text" path="entitytype"/><br>
Code:<form:input type="text" path="code"/><br>
Status:<form:input type="text" path="status" /><br>
<input type="button" value="submit" onclick="gotoAction('saveGeoHirach.do')"><br>
<input type="button" value="GETALL" onclick="gotoAction('geoHierList.do')"><br>
<input type="button" value="Update" onclick="gotoAction('updateGeoHier.do')"><br>
<input type="button" value="Delete" onclick="gotoAction('deleteGeoHier.do')"> <br>

</form:form>
<!-- </td>
</tr>
</table>

</table> -->
<%-- <table>

<%@include file="footer.jsp" %>

</tr>
</table> --%>
</body>
</html>