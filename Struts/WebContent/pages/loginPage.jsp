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
		<title><bean:message key="auth.label" /></title>
	</head>
	<body>
	<nav class="navbar navbar-inverse">
  				<div class="container-fluid">
			    	<div class="navbar-header">Yeah</div>
			    <ul class="nav navbar-nav">    
			    </ul>
			 	</div>
			</nav>
		<div class="container">
			<div class="container-fluid">
<h3><bean:message key="auth.label" /></h3><br>

<html:form action="/Login">

<div class="form-group">
			<label class="control-label" for="login"><bean:message key="auth.login" /></label>
			<html:text property="login" size="30" maxlength="30" styleClass="form-control"/><html:errors  property="login"/><br> 		 
		</div>
<div class="form-group">
			<label class="control-label" for="password"><bean:message key="auth.password" /></label>
			<html:text property="password" size="30" maxlength="30" styleClass="form-control"/><html:errors  property="password"/><br> 		 
		</div>

		<html:submit styleClass="btn btn-primary"><bean:message key="auth.submit" /></html:submit><br>
</html:form>	
</div>
</div>
</html:html>
