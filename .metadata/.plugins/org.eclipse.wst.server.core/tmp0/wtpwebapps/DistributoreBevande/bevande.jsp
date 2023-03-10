<%@page import="com.models.dao.BevandaDao"%>
<%@page import="com.models.Bevanda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Elenco bevande disponibili</h1>

	<%
		List<Bevanda> elenco = BevandaDao.getIstanza().findAll();
		
		String risultato = "";
		for(Bevanda bevanda: elenco){
			risultato += bevanda.getNome() + " " 
			+ bevanda.getDescrizione() + " " 
			+ bevanda.getGradoAlcolico() + " " 
			+ "<br />";
		}
		
		out.write(risultato);
	%>
</body>
</html>