<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Registrar Datos</title>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<body>
<h2>Registrar Datos del Usuario</h2>
<form action="insertar-datos" method="post" enctype="multipart/form-data">
    <label for="user_id">Identificador:</label>
    <input type="number" id="user_id" name="user_id" required><br><br>

    <label for="dni">DNI:</label>
    <input type="text" id="dni" name="dni" required><br><br>

    <label for="correo">Correo Electrónico:</label>
    <input type="email" id="correo" name="correo" required><br><br>

    <label for="fecha_nacimiento">Fecha de Nacimiento:</label>
    <input type="date" id="fecha_nacimiento" name="fecha_nacimiento" required><br><br>

    <label for="ruta_foto">Ruta de Foto:</label>
    <input type="file" id="ruta_foto" name="ruta_foto" accept="image/*" required><br><br>

    <label for="ruta_documentos">Ruta de Documentos:</label>
    <input type="file" id="ruta_documentos" name="ruta_documentos" accept=".pdf,.doc,.docx" required><br><br>

    <button type="submit">Registrar Datos</button>
</form>

<c:if test="${not empty mensaje}">
    <p>${mensaje}</p>
</c:if>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
