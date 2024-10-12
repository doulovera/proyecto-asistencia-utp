<form action="usuarios" method="post">
    <input type="hidden" name="action" value="create">
    <label for="identificador">Identificador:</label>
    <input type="text" id="identificador" name="identificador" required><br><br>

    <label for="nombres">Nombres:</label>
    <input type="text" id="nombres" name="nombres" required><br><br>

    <label for="apellidos">Apellidos:</label>
    <input type="text" id="apellidos" name="apellidos" required><br><br>

    <label for="rolId">Rol ID:</label>
    <input type="number" id="rolId" name="rolId" required><br><br>

    <input type="submit" value="Registrar">
</form>
