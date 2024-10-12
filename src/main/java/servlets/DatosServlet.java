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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("list")) {
            // Lógica para listar datos
            List<Datos> datosList = datosDao.readAll();
            request.setAttribute("datosList", datosList);
            request.getRequestDispatcher("datos.jsp").forward(request, response);
        } else if (action != null && action.equals("view")) {
            // Ver un registro específico
            int id = Integer.parseInt(request.getParameter("id"));
            Datos datos = datosDao.read(id);
            request.setAttribute("datos", datos);
            request.getRequestDispatcher("viewDatos.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
            
        // Convertir el string de la fecha de nacimiento a Date
        Date fechaNacimiento = null;
        try {
            fechaNacimiento = dateFormat.parse(request.getParameter("fechaNacimiento"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        if (action != null && action.equals("create")) {

            // Crear un nuevo registro
            Datos nuevoDatos = new Datos(Integer.parseInt(request.getParameter("id")),
                                         request.getParameter("dni"),
                                         request.getParameter("correoElectronico"),
                                         fechaNacimiento,
                                         request.getParameter("rutaFoto"),
                                         request.getParameter("rutaDocumentos"));

            datosDao.create(nuevoDatos);
            response.sendRedirect("datos?action=list");

        } else if (action != null && action.equals("update")) {
            // Actualizar un registro existente
            Datos datosActualizados = new Datos(Integer.parseInt(request.getParameter("id")),
                                                request.getParameter("dni"),
                                                request.getParameter("correoElectronico"),
                                                fechaNacimiento,
                                                request.getParameter("rutaFoto"),
                                                request.getParameter("rutaDocumentos"));

            datosDao.update(datosActualizados);
            response.sendRedirect("datos?action=list");

        } else if (action != null && action.equals("delete")) {
            // Eliminar un registro
            int id = Integer.parseInt(request.getParameter("id"));
            datosDao.delete(id);
            response.sendRedirect("datos?action=list");
        }
    }
}
