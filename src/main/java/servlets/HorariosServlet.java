package servlets;

import dao.HorariosDao;
import dao.HorariosDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import models.Horarios;
import models.Usuarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/horarios")
public class HorariosServlet extends HttpServlet {
    private HorariosDao horariosDao;
    private UsuarioDao usuarioDao;

    @Override
    public void init() throws ServletException {
        horariosDao = new HorariosDaoImpl();
        usuarioDao = new UsuarioDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirigir a la página JSP que contiene el formulario de horarios
        request.getRequestDispatcher("/WEB-INF/views/registroHorario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identificador = request.getParameter("identificador");
        if (identificador == null || identificador.isEmpty()) {
            request.setAttribute("mensaje", "El identificador no puede estar vacío.");
            request.getRequestDispatcher("/WEB-INF/views/registroHorario.jsp").forward(request, response);
            return;
        }

        Usuarios usuario = usuarioDao.buscarPorIdentificador(identificador);  // Método que debe estar en UsuarioDao
        if (usuario == null) {
            request.setAttribute("mensaje", "No se encontró ningún usuario con el identificador: " + identificador);
            request.getRequestDispatcher("/WEB-INF/views/registroHorario.jsp").forward(request, response);
            return;
        }

        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        Horarios horarioHoy = horariosDao.buscarPorIdentificadorYFecha(usuario.getIdentificador(), Date.valueOf(fechaActual));

        if (horarioHoy != null) {
            if (horarioHoy.getHoraSalida() == null) {
                // Registrar salida
                horarioHoy.setHoraSalida(Time.valueOf(horaActual));
                horariosDao.update(horarioHoy);
                request.setAttribute("mensaje", usuario.getNombres() + " " + usuario.getApellidos() + " - Hora de salida registrada: " + horaActual);
            } else {
                request.setAttribute("mensaje", "Ya se ha registrado la hora de salida para hoy.");
            }
        } else {
            // Registrar ingreso
            Horarios nuevoHorario = new Horarios();
            nuevoHorario.setUsuarioId(usuario.getId());
            nuevoHorario.setFecha(Date.valueOf(fechaActual));
            nuevoHorario.setHoraIngreso(Time.valueOf(horaActual));
            horariosDao.create(nuevoHorario);
            request.setAttribute("mensaje", usuario.getNombres() + " " + usuario.getApellidos() + " - Hora de ingreso registrada: " + horaActual);
        }

        // Redirigir de nuevo al JSP con el mensaje
        request.getRequestDispatcher("/WEB-INF/views/registroHorario.jsp").forward(request, response);
    }
}
