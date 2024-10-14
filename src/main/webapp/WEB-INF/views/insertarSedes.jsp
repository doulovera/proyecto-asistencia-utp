<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Registrar Sede</title>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<%@ include file="/WEB-INF/views/includes/menu.jsp" %>
<body>
<div class="form-container">
    <h2>Registrar Sede</h2>

    <form action="insertar-sedes" method="post" class="form">
        <label for="nombre_sede">Nombre de la Sede:</label>
        <input type="text" id="nombre_sede" name="nombre_sede" required><br><br>

        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" required><br><br>

        <label for="direccion">Dirección:</label>
        <input type="text" id="direccion" name="direccion" required><br><br>

        <button type="submit" class="btn">Registrar Sede</button>
    </form>
</div>

<c:if test="${not empty mensaje}">
    <p>${mensaje}</p>
</c:if>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
