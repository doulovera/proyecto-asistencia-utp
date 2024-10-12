package servlets;

import dao.SedesDao;
import dao.SedesDaoImpl;
import models.Sedes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/sedes")
public class SedeServlet extends HttpServlet {
    private SedesDao sedesDao;

    @Override
    public void init() throws ServletException {
        sedesDao = new SedesDaoImpl();  // Inicializamos el DAO para gestionar las operaciones
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("list")) {
            // Lógica para listar todas las sedes
            List<Sedes> sedeList = sedesDao.readAll();
            request.setAttribute("sedeList", sedeList);
            request.getRequestDispatcher("sedes.jsp").forward(request, response);
        } else if (action != null && action.equals("view")) {
            // Ver una sede específica
            int id = Integer.parseInt(request.getParameter("id"));
            Sedes sede = sedesDao.read(id);
            request.setAttribute("sede", sede);
            request.getRequestDispatcher("viewSede.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("create")) {
            // Crear una nueva sede
            Sedes nuevaSede = new Sedes(
                    0, // Asignar un id predeterminado ya que es AUTO_INCREMENT
                    request.getParameter("nombreSede"),
                    request.getParameter("correo"),
                    request.getParameter("direccion")
            );

            sedesDao.create(nuevaSede);
            response.sendRedirect("sedes?action=list");

        } else if (action != null && action.equals("update")) {
            // Actualizar una sede existente
            Sedes sedeActualizada = new Sedes(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("nombreSede"),
                    request.getParameter("correo"),
                    request.getParameter("direccion")
            );

            sedesDao.update(sedeActualizada);
            response.sendRedirect("sedes?action=list");

        } else if (action != null && action.equals("delete")) {
            // Eliminar una sede
            int id = Integer.parseInt(request.getParameter("id"));
            sedesDao.delete(id);
            response.sendRedirect("sedes?action=list");
        }
    }
}
