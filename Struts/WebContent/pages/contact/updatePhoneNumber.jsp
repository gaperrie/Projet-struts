<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
	<%  String phoneKind = (String) request.getParameter("phoneKind"); %>
	<%  String phoneNumber = (String) request.getParameter("phoneNumber"); %>
	<%  String contactId = (String) request.getParameter("contactId"); %>
	<%  String id = (String) request.getParameter("id"); %>
	
<html:html>
<head>
<title><bean:message key="add.contact" /></title>
<html:base />
</head>

<html:form action="/ModifyPhoneNumber">
	<fieldset><legend>PhoneNumber</legend>
		PhoneNumber 
		<html:text property="phoneNumber" size="30" maxlength="30" value="<%= phoneNumber %>"/><html:errors  property="phoneNumber"/><br> 
		 
		PhoneKind	
		<html:text property="phoneKind" size="30" maxlength="30" value="<%= phoneKind %>" /><html:errors  property="phoneKind"/><br> 
		
		<html:hidden property="id" name="id" value="<%= id %>" />
		<html:hidden property="contactId" name="contactId" value="<%= contactId %>" />
	</fieldset>
		<html:submit>Update</html:submit><br>
</html:form>
</html:html>
