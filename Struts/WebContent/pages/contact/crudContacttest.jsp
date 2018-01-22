<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<html>
	<head>
    <script type="text/javascript" src='DataTables/jQuery-3.2.1/jquery-3.2.1.js'></script>
    <script type="text/javascript" src="DataTables/DataTables-1.10.16/js/jquery.dataTables.js"></script>
    <link rel="stylesheet" type="text/css" href="DataTables/DataTables-1.10.16/css/jquery.dataTables.css">
	</head>
	<body>
		<div class="container">
			<h3 align="center">Liste des contacts</h3><br>
			<div class="table-responsive">
			<table id="contact" class="display">
				<thead>
					<tr>
						<th>#</th>
						<th>Prenom</th>
						<th>Nom</th>
						<th>Email</th>
						<th>Nb groupe</th>
						<th width="240">Actions</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
					</tr>
					<tr>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
					</tr>					<tr>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
					</tr>					<tr>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
					</tr>					<tr>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
						<td>test</td>
					</tr>
				</tbody>
			</table>
	<script>
			$(document).ready( function () {
    $('#contact').DataTable();
});
</script>
			</div>
			<a href="InputContactGroupe.do"><button type="button" class="btn btn-primary"><bean:message key="add.contact"/></button></a><br>
			<a href="AccueilContact.do">Main</a>
		</div>
	</body>
</html>

