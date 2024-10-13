<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <title>Registrar Sedes</title>
    <script>
        function agregarFila() {
            var table = document.getElementById("tabla_admsedes");
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            row.innerHTML = `
                <td>
                    <select name="sede[]" required>
                        <c:forEach var="sede" items="${sedes}">
                            <option value="${sede.id}">${sede.nombreSede}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="encargado_mana[]" required>
                        <option value="">Seleccione</option>
                        <c:forEach var="usuario" items="${usuarios}">
                            <option value="${usuario.id}">${usuario.nombres}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="encargado_tarde[]" required>
                        <option value="">Seleccione</option>
                        <c:forEach var="usuario" items="${usuarios}">
                            <option value="${usuario.id}">${usuario.nombres}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <input type="date" name="fecha_inicio[]" required>
                </td>
                <td>
                    <input type="date" name="fecha_fin[]" required>
                </td>
            `;
        }
    </script>
</head>

<body>
<h2>Registrar Administracion de Sedes</h2>

<form action="admSedes" method="post">
    <input type="hidden" name="action" value="create">
    <table id="tabla_admsedes" border="1">
        <thead>
        <tr>
            <th>SEDE</th>
            <th>ENCARGADO TM</th>
            <th>ENCARGADO TT</th>
            <th>FECHA DE INICIO</th>
            <th>FECHA FIN</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <select name="sedeID" required>
                    <c:forEach var="sede" items="${sedes}">
                        <option value="${sede.id}">${sede.nombreSede}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="encargadoManana" required>
                    <option value="">Seleccione</option>
                    <c:forEach var="usuario" items="${usuarios}">
                        <option value="${usuario.id}">${usuario.nombres}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <select name="encargadoTarde" required>
                    <option value="">Seleccione</option>
                    <c:forEach var="usuario" items="${usuarios}">
                        <option value="${usuario.id}">${usuario.nombres}</option>
                    </c:forEach>
                </select>
            </td>
            <td>
                <input type="date" name="fechaInicio" required>
            </td>
            <td>
                <input type="date" name="fechaFin" required>
            </td>
        </tr>
        </tbody>
    </table>
    <button type="button" onclick="agregarFila()">Agregar Fila</button>
    <button type="submit">Guardar</button>
</form>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
