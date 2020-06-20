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
<header>
  <h2>Aggiungi Allenatore</h2>
</header>

<section>
  <nav>

  </nav>
  <article>
  <h1>Inserisci i seguenti dati:</h1>
  		<form:form action="saveDigimon" method="post" modelAttribute="digimon">
			<table border="0" cellpadding="5">
				<tr>
					<td>ID Digimon:</td>
					<td>${digimon.id}<form:hidden path="id" />
					</td>
				</tr>
				<tr>
					<td>Nome Digmon:</td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>HP Digmon:</td>
					<td><form:input path="hp" /></td>
				</tr>
				<tr>
					<td>Attacco Digmon:</td>
					<td><form:input path="atk" /></td>
				</tr>
				<tr>
					<td>Difesa Digmon:</td>
					<td><form:input path="def" /></td>
				</tr>
				<tr>
					<td>Resistenza Digmon:</td>
					<td><form:input path="res" /></td>
				</tr>
				<tr>
					<td>Evoluzione Digmon:</td>
					<td><form:radiobuttons path="evo" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
					
				</tr>
			</table>
		</form:form>
		<form action="homeA">
		<input type="submit" value="Indietro">
		</form>
  </article>
</section>

</body>
</html>
