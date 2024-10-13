<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<!doctype html>
<html lang="es">
<head>
    <title>Registro</title>
</head>
<body>
    <div class="form-container">
        <h2>Registro de Usuario</h2>
        <form class="form" action="usuarios" method="post"> <!-- Asegúrate de incluir la clase 'form' -->
            <input type="hidden" name="action" value="create">
            <label for="identificador">Identificador:</label>
            <input type="text" id="identificador" name="identificador" required><br><br>

            <label for="nombres">Nombres:</label>
            <input type="text" id="nombres" name="nombres" required><br><br>

            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellidos" name="apellidos" required><br><br>

            <label for="rolId">Rol ID:</label>
            <input type="number" id="rolId" name="rolId" required><br><br>

            <input type="submit" class="btn" value="Registrar">
        </form>
    </div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
