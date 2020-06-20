<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<title>DigiHome</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<!-- Header -->
<header class="w3-display-container w3-content w3-center" style="max-width:1500px">
  <img class="w3-image" src="https://images7.alphacoders.com/701/701863.png" alt="Me" width="1500" height="600">
  <div class="w3-display-middle w3-padding-large w3-border w3-wide w3-text-black w3-center">
    <h1 class="w3-hide-medium w3-hide-small w3-xxxlarge">DIGIMONDO</h1>
    <h5 class="w3-hide-large" style="black-space:nowrap;">DIGIMONDO</h5>
    <h3 class="w3-hide-medium w3-hide-small">DIGIMANAGER</h3>
  </div>
  
  <!-- Navbar (placed at the bottom of the header image) -->
  <div class="w3-bar w3-black w3-round w3-display-bottommiddle w3-hide-small" style="bottom:-16px">
    <a href="newDigimon" class="w3-bar-item w3-button">Aggiugi Digimon</a>
    <a href="newAllenatore" class="w3-bar-item w3-button">Aggiungi Allenatore</a>
  </div>
 <style type="text/css">
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #007acc;
  color: white;
}
</style>
</header>

<!-- Page content -->
<div class="w3-content w3-padding-large w3-margin-top">
<h2>DigiDex WEB</h2>
		<table border="1" >
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>HP</th>
				<th>Attacco</th>
				<th>Difesa</th>
				<th>Resistenza</th>
				<th>Evoluzione</th>
				<th>Modifica</th>
				<th>Rimuovi</th>
			</tr>
			<c:forEach items="${digiLista}" var="digimon">
				<tr>
					<td>${digimon.id}</td>
					<td>${digimon.nome}</td>
					<td>${digimon.hp}</td>
					<td>${digimon.atk}</td>
					<td>${digimon.def}</td>
					<td>${digimon.res}</td>
					<td>${digimon.evo}</td>
					<td><a href="editDigimon?id=${digimon.id}">Modifica</a></td> 
					<td><a href="deleteDigimon?id=${digimon.id}">Rimuovi</a></td>
				</tr>
			</c:forEach>
		</table>
<h2>Lista Allenatori</h2>
		<table border="1" >
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Registra un Digimon</th>
				<th>Modifica</th>
				<th>Rimuovi</th>
				
			</tr>
			<c:forEach items="${listaAllenatore}" var="allenatore">
				<tr>
					<td>${allenatore.id}</td>
					<td>${allenatore.nome}</td>
					<td><a href="addDigimon?idAllenatore=${allenatore.id}">Registra</a> </td>
					<td><a href="editAllenatore?id=${allenatore.id}">Modifica</a> </td>
					<td><a href="deleteAllenatore?id=${allenatore.id}">Rimuovi</a></td>
				</tr>
			</c:forEach>
		</table>

<!-- End page content -->
</div>

</body>
</html>
