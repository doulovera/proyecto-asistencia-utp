package servlets;

import dao.AdmSedesDaoImpl; // Asegúrate de tener la implementación del DAO correspondiente
import dao.SedesDaoImpl;
import dao.UsuarioDaoImpl;
import models.AdmSedes; // Asegúrate de tener el modelo correspondiente
import models.Sedes;
import models.Usuarios;

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

@WebServlet("/insertar-admsedes")
public class InsertarAdmSedesServlet extends HttpServlet {
    private AdmSedesDaoImpl admSedesDao;
    private SedesDaoImpl sedesDao;
    private UsuarioDaoImpl usuarioDao;

    @Override
    public void init() throws ServletException {
        admSedesDao = new AdmSedesDaoImpl(); // Inicializa el DAO
        sedesDao = new SedesDaoImpl();
        usuarioDao = new UsuarioDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sedes> sedes = sedesDao.readAll();
        List<Usuarios> usuarios = usuarioDao.readAll();

        request.setAttribute("sedes", sedes);
        request.setAttribute("usuarios", usuarios);

        request.getRequestDispatcher("/WEB-INF/views/insertarAdmSedes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recoge los datos del formulario
        String[] sedes = request.getParameterValues("sede[]");
        String[] encargadosMana = request.getParameterValues("encargado_mana[]");
        String[] encargadosTarde = request.getParameterValues("encargado_tarde[]");
        String[] fechasInicio = request.getParameterValues("fecha_inicio[]");
        String[] fechasFin = request.getParameterValues("fecha_fin[]");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha
        // Recorre los datos y realiza la inserción
        for (int i = 0; i < sedes.length; i++) {
            try {
                Date fechaInicioDate = dateFormat.parse(fechasInicio[i]);
                Date fechaFinDate = dateFormat.parse(fechasFin[i]);

                // Crea un objeto de AdmSedes
                AdmSedes nuevaSede = new AdmSedes(
                        0, // ID se manejará automáticamente por la base de datos
                        Integer.parseInt(sedes[i]),
                        Integer.parseInt(encargadosMana[i]),
                        Integer.parseInt(encargadosTarde[i]),
                        fechaInicioDate,
                        fechaFinDate
                );

                // Llama al método para insertar la sede
                admSedesDao.create(nuevaSede);

            } catch (ParseException e) {
                e.printStackTrace();
                // Manejo de errores, puedes redirigir a una página de error si lo prefieres
            }
        }

        request.setAttribute("mensaje", "Registros guardados exitosamente.");
        request.getRequestDispatcher("/WEB-INF/views/insertarAdmSedes.jsp").forward(request, response);
    }
}
