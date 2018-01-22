<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<html:html>
<head>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../../medias/DataTables/datatables.css">
 		<script type="text/javascript" charset="utf8" src="../../medias/DataTables/datatables.js"></script>
<title><bean:message key="add.contact" /></title>
<html:base />
</head>
			<nav class="navbar navbar-inverse">
  				<div class="container-fluid">
			    	<div class="navbar-header"><a class="navbar-brand" href="#">Yeah</a></div>
			    <ul class="nav navbar-nav">    
			      <li class="active"><a href="/Struts/CrudContact.do"><bean:message key="contact.label" /></a></li>
			      <li><a href="/Struts/CrudGroupe.do"><bean:message key="group.label" /></a></li>
			    </ul>
			 	</div>
			</nav>
<div class="container">

		<html:form action="/AddContactGroupe" styleClass="form-inline">

		<fieldset><legend><bean:message key="contact.fieldset" /></legend>
			<div class="form-group">
				<label class="control-label" for="firstName"><bean:message key="contact.firstName" /></label>
				<html:text property="firstName" styleId="firstName" styleClass="form-control" /><html:errors  property="firstName"/> 
			</div>
			<div class="form-group">
				<label for="lastName"><bean:message key="contact.lastName" /></label>
				<html:text property="lastName" styleId="lastName" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="lastName"/><br> 
			</div>
			<div class="form-group">
			<label for="email"><bean:message key="contact.email" /></label>
				<html:text property="email" styleId="email" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="email"/><br>
			</div>
		</fieldset>
		<fieldset><legend><bean:message key="group.label" /></legend>
			<bean:define id="groupes" name="groupes" scope="session"/>
	
			<logic:iterate id="groupe" name="groupes">
				<div class="checkbox">
	     			<label><input type="checkbox" name="groupId" value=<bean:write name="groupe" property="groupId"/>> <bean:write name="groupe" property="groupName"/></label>
				</div>
			</logic:iterate>
			<br><a href="/Struts/GroupeCreation.do" target="_blank"><bean:message key="group.add" /></a><br>
		</fieldset>
		<fieldset><legend><bean:message key="address.label" /></legend>
			<div class="form-group">
				<label for="street"><bean:message key="address.street" /></label>
				<html:text property="street" styleId="street" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="street"/><br> 
			</div>
			<div class="form-group">
				<label for="city"><bean:message key="address.city" /></label>
				<html:text property="city" styleId="city" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="city"/><br> 
			</div>
			<div class="form-group">
				<label for="zip"><bean:message key="address.zip" /></label>
				<html:text property="zip" styleId="zip" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="zip"/><br>
			</div>		
			<div class="form-group">				 
				<label for="country"><bean:message key="address.country" /></label>	
				<html:text property="country" styleId="country" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="country"/><br> 
			</div>
		</fieldset>
 		<fieldset><legend><bean:message key="phonenumber.numero" /></legend>
 			<div class="form-group">
				<label for="phoneNumber"><bean:message key="phonenumber.numero" /></label>
				<html:text property="phoneNumber" styleId="phoneNumber" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="phoneNumber"/><br> 
			</div>
			<div class="form-group">
				<label for="phoneKind"><bean:message key="phonenumber.kind" /></label>
				<html:text property="phoneKind" styleId="phoneKind" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="phoneKind"/><br> 
			</div>
		</fieldset>
 		<fieldset><legend><bean:message key="entreprise.label" /></legend>
 			<div class="form-group">
				<label for="numSiret"><bean:message key="entreprise.if" /></label>
				<html:text property="numSiret" styleId="numSiret" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="numSiret"/><br> 
			</div>
		</fieldset>
		<br/><html:submit styleClass="btn btn-primary center-block"><bean:message key="label.save" /></html:submit><br>
	</div>
	</html:form>
</div>
</html:html>
