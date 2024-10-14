<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Consultar Datos</title>
  <link rel="stylesheet" type="text/css" href="css/estilos.css">
  <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<%@ include file="/WEB-INF/views/includes/menu.jsp" %>
<body>
<div class="form-container">
  <h2>Consultar Datos del Usuario</h2>

  <form action="datos" method="post" class="form">
    <label for="identificador">Identificador:</label>
    <input type="text" id="identificador" name="identificador" required>
    <button type="submit" class="btn">Consultar</button>
  </form>

  <c:if test="${not empty mensaje}">
    <p>${mensaje}</p>
  </c:if>

  <c:if test="${not empty datos}">
    <h3>Información del Usuario:</h3>
    <img src="${datos.rutaFoto}" alt="Foto de Perfil" width="200">
    <p><strong>ID:</strong> ${datos.identificador}</p>
    <p><strong>DNI:</strong> ${datos.dni}</p>
    <p><strong>Correo Electrónico:</strong> ${datos.correoElectronico}</p>
    <p><strong>Fecha de Nacimiento:</strong> ${datos.fechaNacimiento}</p>
    <p><strong>Ruta de Documentos:</strong> ${datos.rutaDocumentos}</p>
  </c:if>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
