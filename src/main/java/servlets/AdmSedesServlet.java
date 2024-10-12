package servlets;

import dao.AdmSedesDao;
import dao.AdmSedesDaoImpl;
import models.AdmSedes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/admSedes")
public class AdmSedesServlet extends HttpServlet {
    private AdmSedesDao admSedesDao;

    @Override
    public void init() throws ServletException {
        admSedesDao = new AdmSedesDaoImpl();  // Inicializamos el DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("list")) {
            // Listar todas las asignaciones de administradores a sedes
            List<AdmSedes> admSedesList = admSedesDao.readAll();
            request.setAttribute("admSedesList", admSedesList);
            request.getRequestDispatcher("admSedes.jsp").forward(request, response);
        } else if (action != null && action.equals("view")) {
            // Ver una asignación específica
            int id = Integer.parseInt(request.getParameter("id"));
            AdmSedes admSede = admSedesDao.read(id);
            request.setAttribute("admSede", admSede);
            request.getRequestDispatcher("viewAdmSede.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("create")) {
            // Crear una nueva asignación de administradores a sedes
            AdmSedes nuevaAdmSede = new AdmSedes(
                    0, // ID autoincremental
                    Integer.parseInt(request.getParameter("sedeID")),
                    Integer.parseInt(request.getParameter("encargadoManana")),
                    Integer.parseInt(request.getParameter("encargadoTarde")),
                    Date.valueOf(request.getParameter("fechaInicio")),
                    Date.valueOf(request.getParameter("fechaFin"))
            );

            admSedesDao.create(nuevaAdmSede);
            response.sendRedirect("admSedes?action=list");

        } else if (action != null && action.equals("update")) {
            // Actualizar una asignación de administradores a sedes
            AdmSedes admSedeActualizado = new AdmSedes(
                    Integer.parseInt(request.getParameter("id")),
                    Integer.parseInt(request.getParameter("sedeID")),
                    Integer.parseInt(request.getParameter("encargadoManana")),
                    Integer.parseInt(request.getParameter("encargadoTarde")),
                    Date.valueOf(request.getParameter("fechaInicio")),
                    Date.valueOf(request.getParameter("fechaFin"))
            );

            admSedesDao.update(admSedeActualizado);
            response.sendRedirect("admSedes?action=list");

        } else if (action != null && action.equals("delete")) {
            // Eliminar una asignación
            int id = Integer.parseInt(request.getParameter("id"));
            admSedesDao.delete(id);
            response.sendRedirect("admSedes?action=list");
        }
    }
}
