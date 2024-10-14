package servlets;

import dao.DatosDao;
import dao.DatosDaoImpl;
import models.Sedes;
import dao.SedesDao;
import dao.SedesDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/graficos")
public class GraficosServlet extends HttpServlet {
    private DatosDao datosDao;
    private SedesDao sedesDao;

    @Override
    public void init() throws ServletException {
        datosDao = new DatosDaoImpl();
        sedesDao = new SedesDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Sedes> sedes = sedesDao.readAll();

        request.setAttribute("sedes", sedes);

        request.getRequestDispatcher("/WEB-INF/views/graficos.jsp").forward(request, response);
    }
}
