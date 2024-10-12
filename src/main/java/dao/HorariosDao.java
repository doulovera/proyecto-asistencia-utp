package dao;

import java.sql.Date;
import models.Horarios;
import java.util.List;

public interface HorariosDao {
    void create(Horarios horarios);
    Horarios read(int id);
    List<Horarios> readAll();
    void update(Horarios horarios);
    void delete(int id);
    
    Horarios buscarPorIdentificadorYFecha(String identificador, Date fecha);
}

