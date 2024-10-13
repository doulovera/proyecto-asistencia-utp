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

@WebServlet("/insertar-sedes")
public class SedeServlet extends HttpServlet {
    private SedesDao sedesDao;

    @Override
    public void init() throws ServletException {
        sedesDao = new SedesDaoImpl();  // Inicializamos el DAO para gestionar las operaciones
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/insertarSedes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Crear una nueva sede
        Sedes nuevaSede = new Sedes(
                0, // Asignar un id predeterminado ya que es AUTO_INCREMENT
                request.getParameter("nombre_sede"),
                request.getParameter("correo"),
                request.getParameter("direccion")
        );

        System.out.println("1111");


        try {
            sedesDao.create(nuevaSede);
            request.setAttribute("mensaje", "Sede creada correctamente");
        } catch (Exception e) {
            request.setAttribute("mensaje", "Error al crear la sede");
        }

        System.out.println("Sede creada correctamente");

        request.getRequestDispatcher("/WEB-INF/views/insertarSedes.jsp").forward(request, response);
    }
}
