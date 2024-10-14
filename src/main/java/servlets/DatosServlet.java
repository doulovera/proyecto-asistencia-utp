package servlets;

import dao.DatosDao;
import dao.DatosDaoImpl;
import models.Datos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/datos")
public class DatosServlet extends HttpServlet {
    private DatosDao datosDao;

    @Override
    public void init() throws ServletException {
        datosDao = new DatosDaoImpl(); // Inicializamos el DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/consultarDatos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recoger el identificador del formulario
        String identificadorStr = request.getParameter("identificador");
        Datos datos = null;

        try {
            int identificador = Integer.parseInt(identificadorStr);
            datos = datosDao.readByIdentificador(identificador);
        } catch (NumberFormatException e) {
            request.setAttribute("mensaje", "El identificador debe ser un número.");
        }

        if (datos == null) {
            request.setAttribute("mensaje", "No se encontraron datos con el identificador proporcionado.");
        }

        // Pasar la información a la vista
        request.setAttribute("datos", datos);
        request.getRequestDispatcher("/WEB-INF/views/consultarDatos.jsp").forward(request, response);
    }
}
