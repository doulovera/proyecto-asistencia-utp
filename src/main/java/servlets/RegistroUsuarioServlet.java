package servlets;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import models.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {
    private UsuarioDao usuarioDao;

    @Override
    public void init() throws ServletException {
        usuarioDao = new UsuarioDaoImpl(); // Inicializamos el DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirigir a la página de registro de usuario
        request.getRequestDispatcher("/WEB-INF/views/registroUsuario.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Manejar la creación de un nuevo usuario
        String identificador = request.getParameter("identificador");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int rolId = Integer.parseInt(request.getParameter("rolId"));

        // Crear un nuevo objeto Usuario
        Usuarios nuevoUsuario = new Usuarios(0, identificador, nombres, apellidos, rolId);

        // Registrar el nuevo usuario en la base de datos
        usuarioDao.create(nuevoUsuario);

        // Redirigir a la lista de usuarios o a otra página después de registrar
        response.sendRedirect("usuarios?action=list");
    }
}
