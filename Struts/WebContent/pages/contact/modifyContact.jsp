<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
	<%  String lastName = (String) request.getParameter("lastName"); %>
	<%  String firstName = (String) request.getParameter("firstName"); %>
	<%  String email = (String) request.getParameter("email"); %>
	<%  String id = (String) request.getParameter("id"); %>
	
<html:html>
<head>
<title><bean:message key="add.contact" /></title>
<html:base />
</head>

<html:form action="/ModifyContact">


		First Name 
		<html:text property="firstName" size="30" maxlength="30" value="<%= firstName %>"/><html:errors  property="firstName"/><br> 
		 
		Last Name 	
		<html:text property="lastName" size="30" maxlength="30" value="<%= lastName %>" /><html:errors  property="lastName"/><br> 
		
		E-mail address 
		<html:text property="email" size="30" maxlength="30" value="<%= email %>" /><html:errors  property="email"/><br>
		
		<html:hidden property="id" name="id" value="<%= id %>" /><br>

		<html:submit>Update</html:submit><br>
</html:form>
</html:html>
