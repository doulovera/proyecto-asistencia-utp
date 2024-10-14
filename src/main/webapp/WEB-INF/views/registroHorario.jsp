<!DOCTYPE html>
<html lang="es">
<head>
  <title>Registro de Horarios</title>

  <!-- AÃ±adir meta refresh solo si se ha registrado un ingreso o salida -->
  <%
    if (request.getMethod().equalsIgnoreCase("POST") && request.getParameter("identificador") != null) {
      out.println("<meta http-equiv='refresh' content='5;url=" + request.getContextPath() + "/horarios'>");
    }
  %>
  <%@ include file="/WEB-INF/views/includes/header.jsp" %>
</head>
<%@ include file="/WEB-INF/views/includes/menu.jsp" %>
<body>
<div class="form-container">
  <h2>Registro de Horarios</h2>
  <!-- Formulario para ingresar el identificador -->
  <form action="horarios" method="post" class="form">
    <label for="identificador">Identificador:</label>
    <input type="text" id="identificador" name="identificador" class="input-field" required>
    <button type="submit" class="btn" >Registrar</button>
  </form>


  <%
    // LÃ³gica que serÃ¡ manejada en el Servlet
    String mensaje = (String) request.getAttribute("mensaje");
    if (mensaje != null) {
      out.println("<p>" + mensaje + "</p>");
    }
  %>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
