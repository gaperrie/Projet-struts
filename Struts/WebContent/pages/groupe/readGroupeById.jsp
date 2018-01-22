<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%  String groupId = (String) request.getParameter("groupId"); %>
<%  String groupName = (String) request.getParameter("groupName"); %>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.css"/>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://cdn.datatables.net/v/bs/dt-1.10.16/datatables.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" type="text/css" href="/medias/DataTables/datatables.css">
 		<script type="text/javascript" charset="utf8" src="../../medias/DataTables/datatables.js"></script>
 		<title><bean:message key="group.show" /></title>
	</head>
		<body>
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
			<div class="container-fluid">
				<h3 align="center"><bean:message key="group.show" /></h3><br>
				<html:form action="/ModifyGroupe"  styleClass="form-inline">

		<div class="form-group">
				<label class="control-label" for="groupName"><bean:message key="group.name" /></label>
		<html:text property="groupName" value="<%= groupName %>" size="30" maxlength="30" styleClass="form-control" disabled="true"/><html:errors  property="groupName"/><br> 		 
		</div>
		<br>
</html:form>
			  	<div class="input-group col-xs-3">
    				<input class="form-control" id="myInput" type="text" placeholder="<bean:message key="action.search" />...">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span></div>
				<div class="table-responsive">
				<table id="contact_table" class="display table table-striped table-condensed table-list">
					<thead>
						<tr>
							<th>#</th>
							<th><bean:message key="contact.firstName" /></th>
							<th><bean:message key="contact.lastName" /></th>
							<th><bean:message key="contact.email" /></th>
						</tr>
					</thead>
					<bean:define id="contacts" name="contacts" scope="session"/>
					<tbody id="myTable">
						<logic:iterate id="contact" name="contacts">
						<tr>
							<td><a href="ReadContactById.do?id=<bean:write name="contact" property="id"/>" ><bean:write name="contact" property="id" /></a></td>
							<td><bean:write name="contact" property="firstName" /></td>
							<td><bean:write name="contact" property="lastName" /></td>
							<td><bean:write name="contact" property="email" /></td>
						</tr>
						</logic:iterate>
					</tbody>
				</table>
				</div>
				<a href="InputContactGroupe.do"><button type="button" class="btn btn-primary"><bean:message key="contact.add"/></button></a><br>
			</div>
		</div>
		<script>
		$(document).ready(function(){
		  $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		});
		</script>
	</body>
</html>
