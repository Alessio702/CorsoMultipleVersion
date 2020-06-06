<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DragDrop.jsp</title>
</head>
<body>
	<ul id="elementi_da_trascinare"
		ondragstart="iniziaTrascinamento(event)">
		<li draggable="true" data-icona="http://bit.ly/h5Khyt"
			data-valore="0.5">50 Cents</li>
		<li draggable="true" data-icona="http://bit.ly/gnyFfh" data-valore="1">
			1 Euro</li>
		<li draggable="true" data-icona="http://bit.ly/eXq6y5" data-valore="2">
			2 Euro</li>
		<li draggable="true" data-icona="http://bit.ly/hiftBg"
			data-valore="10">10 Euro</li>
	</ul>

	<img id="portamonete" dropzone="copy s:text" draggable="false"
		src="aaa.png" alt="portamonete" ondragenter="ingressoInZonaDiDrop(event)"
		ondragleave="uscitaZonaDiDrop(event)"
		ondragover="trascinamentoInZonaDiDrop(event)"
		ondrop="rilascioDellOggettoTrascinato(event)">
		
	<p>
		Il portamonete contiene:
		<output id="sommatoria">0</output>
		euro
	</p>

	<script>
  iniziaTrascinamento = function(evento){
    evento.dataTransfer.setData("text", evento.target.dataset.valore);
    evento.dataTransfer.effectAllowed = 'copy';
    icona = document.createElement('img');
    icona.src = evento.target.dataset.icona;
    evento.dataTransfer.setDragImage(icona, -10, -10);
  }
  
  ingressoInZonaDiDrop = function(evento){
      evento.target.src = "http://bit.ly/gRo6cc";
      evento.preventDefault();
    }
  
    uscitaZonaDiDrop = function(evento){
      evento.target.src = "http://bit.ly/gZH4H5";
    }
    
    trascinamentoInZonaDiDrop = function(evento){
      evento.dataTransfer.dropEffect = 'copy';
      evento.preventDefault();
    }
    
    rilascioDellOggettoTrascinato = function(evento){
      sommatoria = document.getElementById("sommatoria");
      sommatoria.innerHTML = parseFloat(sommatoria.innerHTML) + parseFloat
	(evento.dataTransfer.getData("text"));
      evento.target.src = "http://bit.ly/gZH4H5";
    }

</script>

</body>
</html>