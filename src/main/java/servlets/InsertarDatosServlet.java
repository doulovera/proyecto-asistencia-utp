package servlets;

import dao.DatosDao;
import dao.DatosDaoImpl;
import models.Datos;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.UUID;

@WebServlet("/insertar-datos")
@MultipartConfig
public class InsertarDatosServlet extends HttpServlet {
    private DatosDao datosDao;

    @Override
    public void init() throws ServletException {
        datosDao = new DatosDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Simplemente redirigir a la página JSP para insertar datos
        request.getRequestDispatcher("/WEB-INF/views/insertarDatos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.parseInt(request.getParameter("user_id"));
        String dni = request.getParameter("dni");
        String correoElectronico = request.getParameter("correo");
        Date fechaNacimiento = Date.valueOf(request.getParameter("fecha_nacimiento"));

        // Manejo de archivos
        Part rutaFotoPart = request.getPart("ruta_foto");
        Part rutaDocumentosPart = request.getPart("ruta_documentos");

        String rutaFoto = "assets/" + UUID.randomUUID() + "_" + rutaFotoPart.getSubmittedFileName();
        String rutaDocumentos = "assets/" + UUID.randomUUID() + "_" + rutaDocumentosPart.getSubmittedFileName();

        // Ruta donde se guardarán los archivos
        String savePath = getServletContext().getRealPath("/") + "assets";
        File saveDir = new File(savePath);
        if (!saveDir.exists()) saveDir.mkdirs(); // Crear el directorio si no existe

        // Guardar los archivos
        rutaFotoPart.write(savePath + File.separator + rutaFoto.substring(6)); // Guardar la foto
        rutaDocumentosPart.write(savePath + File.separator + rutaDocumentos.substring(6)); // Guardar los documentos

        // Crear un objeto Datos
        Datos nuevoDatos = new Datos(userId, dni, correoElectronico, fechaNacimiento, rutaFoto, rutaDocumentos);

        // Intentar insertar los datos
        try {
            datosDao.create(nuevoDatos); // Llamada al método para insertar
            request.setAttribute("mensaje", "Datos registrados exitosamente.");
        } catch (Exception e) {
            // Captura cualquier excepción y establece el mensaje de error
            request.setAttribute("mensaje", "Error al registrar los datos: " + e.getMessage());
        }

        // Volver a la vista de insertar datos para mostrar el mensaje
        request.getRequestDispatcher("/WEB-INF/views/insertarDatos.jsp").forward(request, response);
    }
}
