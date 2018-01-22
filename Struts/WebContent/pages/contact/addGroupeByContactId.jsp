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
		<title><bean:message key="group.affect" /></title>
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
				<h3 align="center"><bean:message key="group.affect" /></h3><br>
				<div class="input-group col-xs-3">
    				<input class="form-control" id="myInput" type="text" placeholder="<bean:message key="action.search" />...">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span></div>
		<div class="table-responsive">
		<html:form action="/ContactGroupAdd">
				<table id="contact_table" class="display table table-striped table-condensed table-list">
					<thead>
						<tr>
							<th>#</th>
							<th><bean:message key="group.name" /></th>
							<th><bean:message key="actions.label" /></th>
						</tr>
			<bean:define id="groupes" name="groupes" scope="session"/>
			<tbody id="myTable">
			<logic:iterate id="groupe" name="groupes">
			<tr>
				<td><bean:write name="groupe" property="groupId" /></td>
				<td><bean:write name="groupe" property="groupName" /></td>
				<td><input type="checkbox" name="groupId" value=<bean:write name="groupe" property="groupId"/>></td>
			</tr>
			</logic:iterate>
			</tbody>
		</table>
		<input type="hidden" name="contactId" value=<%= request.getParameter("contactId") %>>
		<html:submit styleClass="btn btn-primary"><bean:message key="label.affect" /></html:submit>
	</html:form>
	<br><a href="/Struts/GroupeCreation.do" target="_blank"><bean:message key="group.add" /></a><br>
		</div>
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
</html:html>
