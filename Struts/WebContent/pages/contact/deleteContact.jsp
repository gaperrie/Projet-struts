<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<html:html>
	<head>
		<title>Liste des contacts</title>
	</head>
	<body>
			<table border=1>
				<tr>
					<th>#</th>
					<th>Prenom</th>
					<th>Nom</th>
					<th>Email</th>
				</tr>
				<bean:define id="contacts" name="contacts" scope="session"/>
				<logic:iterate id="contact" name="contacts">
				<tr>
					<td><bean:write name="contact" property="id" /></td>
					<td><bean:write name="contact" property="firstName" /></td>
					<td><bean:write name="contact" property="lastName" /></td>
					<td><bean:write name="contact" property="email" /></td>
					<td><a href="DeleteContact.do?id=<bean:write name="contact" property="id"/>&lastName=<bean:write name="contact" property="lastName" />&firstName=<bean:write name="contact" property="firstName" />&email=<bean:write name="contact" property="email"/>">Supprimer</a></td>
				</tr>
				</logic:iterate>
			</table>
			<a href="AccueilContact.do">Main</a>
	</body>
</html:html>
