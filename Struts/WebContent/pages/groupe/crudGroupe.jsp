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
 		<title><bean:message key="group.list" /></title>
	</head>
	<body>
	<nav class="navbar navbar-inverse">
  				<div class="container-fluid">
			    	<div class="navbar-header"><a class="navbar-brand" href="#">Yeah</a></div>
			    <ul class="nav navbar-nav">    
			      <li><a href="/Struts/CrudContact.do"><bean:message key="contact.label" /></a></li>
			      <li class="active"><a href="/Struts/CrudGroupe.do"><bean:message key="group.label" /></a></li>
			    </ul>
			 	</div>
			</nav>
		<div class="container">
			<div class="container-fluid">
				<h3 align="center"><bean:message key="group.list" /></h3><br>
				<div class="input-group col-xs-3">
    				<input class="form-control" id="myInput" type="text" placeholder="<bean:message key="action.search" />...">
    				<span class="input-group-addon"><i class="glyphicon glyphicon-search"></i></span></div>
		<div class="table-responsive">
				<table id="contact_table" class="display table table-striped table-condensed table-list">
					<thead>
						<tr>
							<th>#</th>
							<th><bean:message key="group.name" /></th>
							<th><bean:message key="group.nbcontact" /></th>
							<th><bean:message key="actions.label" /></th>
						</tr>
			<bean:define id="groupes" name="groupes" scope="session"/>
			<tbody id="myTable">
			<logic:iterate id="groupe" name="groupes">
			<tr>
				<td><bean:write name="groupe" property="groupId" /></td>
				<td><bean:write name="groupe" property="groupName" /></td>
				<td><bean:write name="groupe" property="nbContact" /></td>
				<td><a href="ReadGroupeById.do?groupId=<bean:write name="groupe" property="groupId"/>&groupName=<bean:write name="groupe" property="groupName" />" class="btn btn-info btn-lg"><span class="glyphicon glyphicon-list"></span></a>
				<a href="InputUpdateGroupe.do?groupId=<bean:write name="groupe" property="groupId"/>&groupName=<bean:write name="groupe" property="groupName" />" class="btn btn-warning btn-lg"><span class="glyphicon glyphicon-edit"></span></a>
				<a href="DeleteGroupe.do?id=<bean:write name="groupe" property="groupId"/>" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon-trash"></a></td>
			</tr>
			</logic:iterate>
			</tbody>
		</table>
		</div>
		<a href="GroupeCreation.do"><button type="button" class="btn btn-primary"><bean:message key="group.add"/></button></a><br>
		
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
