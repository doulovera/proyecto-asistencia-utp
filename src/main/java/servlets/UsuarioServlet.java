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
import java.util.logging.Logger;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    private UsuarioDao usuarioDao;

    @Override
    public void init() throws ServletException {
        usuarioDao = new UsuarioDaoImpl(); // Inicializamos el DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("list")) {
            // Lógica para listar usuarios
            request.setAttribute("usuarios", usuarioDao.readAll());
            request.getRequestDispatcher("WEB-INF/views/registrarUsuario.jsp").forward(request, response);
        } else {
            // Más acciones según sea necesario
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("create")) {
            // Lógica para crear un nuevo usuario
            Usuarios nuevoUsuario = new Usuarios(0, request.getParameter("identificador"), 
                                                request.getParameter("nombres"), 
                                                request.getParameter("apellidos"), 
                                                Integer.parseInt(request.getParameter("rolId")));
            usuarioDao.create(nuevoUsuario);
            response.sendRedirect("usuarios?action=list");
        }
        // Agregar lógica para otras acciones (update, delete) según sea necesario
    }
}
