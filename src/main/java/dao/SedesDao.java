package dao;

import models.Sedes;
import java.util.List;

public interface SedesDao {
    void create(Sedes sede);
    Sedes read(int id);
    List<Sedes> readAll();
    void update(Sedes sede);
    void delete(int id);
}
