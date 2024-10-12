package servlets;

import dao.HorariosDao;
import dao.HorariosDaoImpl;
import models.Horarios;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@WebServlet("/horarios")
public class HorariosServlet extends HttpServlet {
    private HorariosDao horariosDao;

    @Override
    public void init() throws ServletException {
        horariosDao = new HorariosDaoImpl();  // Inicializamos el DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("list")) {
            // Listar los horarios de asistencia
            List<Horarios> horariosList = horariosDao.readAll();
            request.setAttribute("horariosList", horariosList);
            request.getRequestDispatcher("horarios.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identificador = request.getParameter("identificador");
        Date fechaActual = new Date();  // Obtener la fecha actual

        // Buscar si el usuario ya tiene un registro de entrada para la fecha actual
        Horarios horario = horariosDao.buscarPorIdentificadorYFecha(identificador, new java.sql.Date(fechaActual.getTime()));

        if (horario == null) {
            // Si no hay registro de entrada, registrar la hora de entrada
            Horarios nuevoHorario = new Horarios();
            nuevoHorario.setId(Integer.parseInt(request.getParameter("usuarioID")));
            nuevoHorario.setFecha(new java.sql.Date(fechaActual.getTime()));  // Fecha actual
            nuevoHorario.setHoraIngreso(new Time(fechaActual.getTime()));  // Hora de entrada actual

            horariosDao.create(nuevoHorario);
            response.getWriter().write("Hora de entrada registrada exitosamente.");
        } else if (horario.getHoraSalida() == null) {
            // Si ya se registró la hora de entrada pero no la salida, registrar la hora de salida
            horario.setHoraSalida(new Time(fechaActual.getTime()));  // Hora de salida actual
            horariosDao.update(horario);
            response.getWriter().write("Hora de salida registrada exitosamente.");
        } else {
            // Si ya se registró tanto la entrada como la salida
            response.getWriter().write("Ya se ha registrado tanto la entrada como la salida.");
        }
    }
}
