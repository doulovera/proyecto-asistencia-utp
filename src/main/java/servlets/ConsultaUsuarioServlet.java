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

@WebServlet("/consultaUsuario")
public class ConsultaUsuarioServlet extends HttpServlet {
    private UsuarioDao usuarioDao;

    @Override
    public void init() throws ServletException {
        usuarioDao = new UsuarioDaoImpl(); // Inicializa el DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identificador = request.getParameter("identificador");

        // Busca el usuario por su identificador
        Usuarios usuario = usuarioDao.buscarPorIdentificador(identificador);
        
        // Si el usuario es encontrado, envía a la vista
        if (usuario != null) {
            request.setAttribute("usuario", usuario); // Agregar el usuario al contexto de la solicitud
            request.getRequestDispatcher("/vistaConsultaUsuario.jsp").forward(request, response);
        } else {
            // Manejar el caso en que no se encuentra el usuario
            request.setAttribute("error", "Usuario no encontrado.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
