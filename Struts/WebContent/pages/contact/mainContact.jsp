<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<html:html>
    <head>
        <title><bean:message key="main.page.title"/></title>
        
    </head> 

    <body>
        <h1><bean:message key="main.page.menu"/></h1>

        <h4><a href="AccueilGroupe.do">Groupes</a></h4><br>
        <h4><a href="InputContactGroupe.do"><bean:message key="add.contact"/></a></h4><br>
    	<!-- <h4><a href="ReadContact.do">Liste des contacts</a></h4><br>
    	<h4><a href="UpdateContactDisplay.do">Modifier un contact</a></h4><br>
    	<h4><a href="DeleteContactDisplay.do">Supprimer un contact</a></h4><br>-->
    	<h4><a href="CrudContact.do">CRUD contact</a></h4><br> 
    	<h4><a href="CrudContacttest.do">CRUD contact test</a></h4><br> 
    	<h4><a href="CrudEntreprise.do">CRUD entreprise</a></h4><br>
    </body>
   </html:html>
