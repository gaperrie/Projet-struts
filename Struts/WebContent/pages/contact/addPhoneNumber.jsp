<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<html:html>
	<head>
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/medias/DataTables/datatables.css">
 		<script type="text/javascript" charset="utf8" src="../../medias/DataTables/datatables.js"></script>
		<title><bean:message key="phonenumber.add" /></title>
	</head>
	<body>
	<nav class="navbar navbar-inverse">
  				<div class="container-fluid">
			    	<div class="navbar-header">Yeah</div>
			    <ul class="nav navbar-nav">    
			      <li class="active"><a href="/Struts/CrudContact.do"><bean:message key="contact.label" /></a></li>
			      <li><a href="/Struts/CrudGroupe.do"><bean:message key="group.label" /></a></li>
			    </ul>
			 	</div>
			</nav>
		<div class="container">
			<div class="container-fluid">
<h3><bean:message key="phonenumber.add" /></h3><br>

<html:form action="/AddPhoneNumber" styleClass="form-inline">
		<div class="form-group">
			<label class="control-label" for="phoneNumber"><bean:message key="phonenumber.numero" /></label>
			<html:text property="phoneNumber" size="30" maxlength="30" styleClass="form-control"/><html:errors  property="phoneNumber"/><br> 		 
		</div>
		<div class="form-group">
			<label class="control-label" for="phoneKind"><bean:message key="phonenumber.kind" /></label>
			<html:text property="phoneKind" size="30" maxlength="30" styleClass="form-control"/><html:errors  property="phoneKind"/><br> 		 
		</div>
			<input type="hidden" name="contactId" value=<%= request.getParameter("contactId") %>>
		<html:submit styleClass="btn btn-primary"><bean:message key="label.save" /></html:submit><br>
</html:form>
</div>
</div>
</html:html>
