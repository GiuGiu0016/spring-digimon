<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>DigiMondo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #007acc;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 500px;
  height: 800px; /* only for demonstration, should be removed */
  padding: 20px;
  background-image: url("https://i.pinimg.com/originals/f0/ab/7d/f0ab7db5991b8960649915b77e506f36.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  background-size: 100%;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
 float: right;
  padding: 20px;
  width: 70%;
  height: 300px; /* only for demonstration, should be removed */
  margin-top: 10%;
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}


/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
</head>
<body>
<body>
<header>
<h2>Scegli i tuoi digimon:</h2>
</header>
<section>
  <nav>

  </nav>
  <article>
			<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>HP</th>
				<th>Attacco</th>
				<th>Difesa</th>
				<th>Resistenza</th>
				<th>Evoluzione</th>
				<th>Scegli Digimon</th>
			</tr>
			<c:forEach items="${digimon}" var="digimon">
				<tr>
		<form:form action="aggiungiDigimon" modelAttribute="digimon" method="post">
					<td>${digimon.id}</td>
					<td>${digimon.nome}</td>
					<td>${digimon.hp}</td>
					<td>${digimon.atk}</td>
					<td>${digimon.def}</td>
					<td>${digimon.res}</td>
					<td>${digimon.evo}</td>

					<td colspan="2"><input type="submit" value="Aggiungi"></td>
					<input type="hidden" name="idDigimon" value="${digimon.id}" />
					<input type="hidden" name="idAllenatore" value="${allenatore.id}" />
		</form:form>
				</tr>
				</c:forEach>
     
			</table>
					<form action="homeA">
		<input type="submit" value="Indietro">
		</form>
		</article>
		</section>
</body>
</html>