<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Registro de Horarios</title>

  <!-- Añadir meta refresh solo si se ha registrado un ingreso o salida -->
  <%
    if (request.getMethod().equalsIgnoreCase("POST") && request.getParameter("identificador") != null) {
      out.println("<meta http-equiv='refresh' content='5;url=" + request.getContextPath() + "/horarios'>");
    }
  %>
</head>
<body>
<!-- Formulario para ingresar el identificador -->
<form action="horarios" method="post">
  <label for="identificador">Identificador:</label>
  <input type="text" id="identificador" name="identificador" required>
  <button type="submit">Registrar</button>
</form>

<%
  // Lógica que será manejada en el Servlet
  String mensaje = (String) request.getAttribute("mensaje");
  if (mensaje != null) {
    out.println("<p>" + mensaje + "</p>");
  }
%>
</body>
</html>
