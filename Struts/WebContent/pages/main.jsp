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

        <h4><a href="AccueilContact.do">Contacts</a></h4><br>
    	<h4><a href="AccueilGroupe.do">Groupes</a></h4><br>

    </body>
   </html:html>
