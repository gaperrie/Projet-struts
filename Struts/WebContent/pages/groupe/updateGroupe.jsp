<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<html:html>
	<head>
		<title>Liste des groupes</title>
	</head>
	<body>
		<table border=1>
			<tr>
				<th>#</th>
				<th>Nom du groupe</th>
			</tr>
			<bean:define id="groupes" name="groupes" scope="session"/>
			<logic:iterate id="groupe" name="groupes">
			<tr>
				<td><bean:write name="groupe" property="groupId" /></td>
				<td><bean:write name="groupe" property="groupName" /></td>
				<td><a href="InputUpdateGroupe.do?groupId=<bean:write name="groupe" property="groupId"/>&groupName=<bean:write name="groupe" property="groupName" />">Modifier</a></td>
			</tr>
			</logic:iterate>
		</table>
			<a href="AccueilGroupe.do">Main</a>
	</body>
</html:html>
