<%@ page import="domain.*, java.util.ArrayList, domain.Address" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<html:html>
<head>
<title><bean:message key="contact.show" /></title>
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<html:base />
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
	<html:form action="/ModifyContact" styleClass="form-inline">
		<fieldset><legend><bean:message key="contact.fieldset" /></legend><bean:define id="lContact" name="lContact" scope="request"/>
			<div class="form-group">
				<label class="control-label" for="firstName"><bean:message key="contact.firstName" /></label>
				<html:text property="firstName" name="lContact"  styleId="firstName" styleClass="form-control" /><html:errors  property="firstName"/> 
			</div>
			<div class="form-group">
				<label for="lastName"><bean:message key="contact.lastName" /></label>
				<html:text property="lastName" name="lContact" styleId="lastName" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="lastName"/><br> 
			</div>
			<div class="form-group">
			<label for="email"><bean:message key="contact.email" /></label>
				<html:text property="email" name="lContact" styleId="email" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="email"/><br>
			</div>
			<input type="hidden" name="id" value=<%= request.getParameter("id") %>>
			<html:submit styleClass="btn btn-primary"><bean:message key="action.update" /></html:submit>
		</fieldset>
	</html:form>
		

		<fieldset><legend>Groupe</legend><bean:define id="groupes" name="groupes" scope="request"/>
		<% ArrayList<Groupe> groups = (ArrayList<Groupe>) request.getAttribute("groupes"); 
			if (groups.size() > 0) { %>
				<table class="display table table-striped table-condensed table-list">
					<tr>
						<th>#</th>
						<th><bean:message key="group.name" /></th>
						<th><bean:message key="actions.label" /></th>
					</tr>
					<logic:iterate id="groupe" name="groupes">
					<tr>
						<td><bean:write name="groupe" property="groupId" /></td>
						<td><bean:write name="groupe" property="groupName" /></td>
						<td><a href="/Struts/DeleteContactGroup.do?contactId=<%= request.getParameter("id") %>&groupId=<bean:write name="groupe" property="groupId" />"><bean:message key="action.delete" /></a></td>
					</tr>
					</logic:iterate>
				</table>
		<% } else {%>
		 <bean:message key="group.null" />
		 <% } %>
		<a href="/Struts/AddGroupeByContactId.do?contactId=<%= request.getParameter("id") %>" target="_blank" styleClass="btn btn-primary">Affecter un nouveau groupe</a><br>
		</fieldset>
		<fieldset><legend><bean:message key="address.label" /></legend><bean:define id="lAddress" name="lAddress" scope="request"/>
		<% Address JAddress = (Address) request.getAttribute("lAddress");
			if (JAddress.getStreet() != null) { %>
			<html:form action="/ModifyAddress" styleClass="form-inline">
			
			<div class="form-group">
				<label for="street"><bean:message key="address.street" /></label>
				<html:text property="street" name="lAddress" styleId="street" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="street"/><br> 
			</div>
			<div class="form-group">
				<label for="city"><bean:message key="address.city" /></label>
				<html:text property="city" name="lAddress" styleId="city" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="city"/><br> 
			</div>
			<div class="form-group">
				<label for="zip"><bean:message key="address.zip" /></label>
				<html:text property="zip" name="lAddress"  styleId="zip"  size="30" maxlength="30" styleClass="form-control" /><html:errors  property="zip"/><br>
			</div>		
			<div class="form-group">				 
				<label for="country"><bean:message key="address.country" /></label>	
				<html:text property="country" name="lAddress" styleId="country" size="30" maxlength="30" styleClass="form-control" /><html:errors  property="country"/><br> 
			</div>			
				<input type="hidden" name="contactId" value=<%= request.getParameter("id") %>>
				<input type="hidden" name="id" value=<bean:write name="lAddress" property="id" />>
			<br/><html:submit styleClass="btn btn-primary center-block"><bean:message key="action.update" /></html:submit>
			</html:form>
			<% } else {%>
		 <bean:message key="address.null" />
		 <br><a href="/Struts/InputAddress.do?contactId=<%= request.getParameter("id") %>" target="_blank"><bean:message key="address.add" /></a><br>
		 <% } %> 
		</fieldset>
 		<fieldset><legend><bean:message key="phonenumber.label" /></legend><bean:define id="phonenumbers" name="phonenumbers" scope="request"/>
 		<% ArrayList<PhoneNumber> JPhoneNumbers = (ArrayList<PhoneNumber>) request.getAttribute("phonenumbers");
 			if (JPhoneNumbers.size() > 0) { %>
				<table class="display table table-striped table-condensed table-list">
					<tr>
						<th>#</th>
						<th><bean:message key="phonenumber.numero" /></th>
						<th><bean:message key="phonenumber.kind" /></th>
						<th><bean:message key="actions.label" /></th>
					</tr>
					<logic:iterate id="phonenumber" name="phonenumbers">
					<tr>
						<td><bean:write property="id" name="phonenumber"  /></td>
						<td><bean:write property="phoneNumber" name="phonenumber" /></td>
						<td><bean:write property="phoneKind" name="phonenumber" /></td>
						<%-- <td><a href="/Struts/InputUpdatePhoneNumber.do?id=<bean:write property="id" name="phonenumber"  />&phoneKind=<bean:write property="phoneKind" name="phonenumber"  />&phoneNumber=<bean:write property="phoneNumber" name="phonenumber"  />&contactId=<%= request.getParameter("id") %>"><bean:message key="action.update" /></a></td>--%>
						<td><a href="/Struts/DeletePhoneNumber.do?id=<bean:write property="id" name="phonenumber"  />"><bean:message key="action.delete" /></a></td>
					</tr>
					</logic:iterate>
				</table>
		<% } else {%>
		 <bean:message key="phonenumber.null" />
		 <% } %> 
		 <a href="/Struts/InputPhoneNumberByContactId.do?contactId=<%= request.getParameter("id") %>" target="_blank"><bean:message key="phonenumber.add" /></a><br>
		</fieldset>
		<% String lNumSiret = (String) request.getAttribute("numSiret");
			if (lNumSiret!=null) { %>
 		<fieldset><legend><bean:message key="entreprise.label" /></legend>
 			<html:form action="/ModifyEntreprise">
			<bean:message key="entreprise.numSiret" />
			<input type="text" name="numSiret" value=<%= lNumSiret %>>
			<input type="hidden" name="contactId" value=<%= request.getParameter("id") %>>
			<html:submit><bean:message key="action.update" /></html:submit>
			</html:form>
		</fieldset>
		<% } %> 
</div>
</html:html>
