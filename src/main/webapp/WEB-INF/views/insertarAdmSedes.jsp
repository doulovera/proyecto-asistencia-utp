<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <title>Registrar Sedes</title>

    <!-- Vinculación del archivo CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilos.css">
    <script>
        function agregarFila() {
            var table = document.getElementById("tabla_admsedes");
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            row.innerHTML = `
                <td>
                    <select name="sede[]" class="input-field" required>
                        <c:forEach var="sede" items="${sedes}">
                            <option value="${sede.id}">${sede.nombreSede}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="encargado_mana[]" class="input-field" required>
                        <option value="">Seleccione</option>
                        <c:forEach var="usuario" items="${usuarios}">
                            <option value="${usuario.id}">${usuario.nombres}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="encargado_tarde[]" class="input-field" required>
                        <option value="">Seleccione</option>
                        <c:forEach var="usuario" items="${usuarios}">
                            <option value="${usuario.id}">${usuario.nombres}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <input type="date" name="fecha_inicio[]" class="input-field" required>
                </td>
                <td>
                    <input type="date" name="fecha_fin[]" class="input-field"required>
                </td>
            `;
        }
    </script>
</head>
<%@ include file="/WEB-INF/views/includes/menu.jsp" %>
<body>

<div class="form-container-rectangular">
    <h2>Registrar Administracion de Sedes</h2>

    <form action="admSedes" method="post" class="form">
        <input type="hidden" name="action" value="create">
        <table id="tabla_admsedes" border="1"  class="table">
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
                    <select name="sedeID" class="input-field" required>
                        <c:forEach var="sede" items="${sedes}">
                            <option value="${sede.id}">${sede.nombreSede}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="encargadoManana" class="input-field" required>
                        <option value="">Seleccione</option>
                        <c:forEach var="usuario" items="${usuarios}">
                            <option value="${usuario.id}">${usuario.nombres}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select name="encargadoTarde" class="input-field" required>
                        <option value="">Seleccione</option>
                        <c:forEach var="usuario" items="${usuarios}">
                            <option value="${usuario.id}">${usuario.nombres}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <input type="date" name="fechaInicio" class="input-field" required>
                </td>
                <td>
                    <input type="date" name="fechaFin" class="input-field" required>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Botón "Agregar Fila" con estilo personalizado -->
        <button type="button" class="btn" onclick="agregarFila()">Agregar Fila</button>

        <!-- Botón "Guardar" con estilo personalizado -->
        <button type="submit" class="btn">Guardar</button>
    </form>
</div>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
