package dao;

import models.Datos;
import java.util.List;

public interface DatosDao {
    void create(Datos datos); // Crear un nuevo registro de datos
    Datos read(int id); // Leer datos por ID
    Datos readByIdentificador(Integer identificador); // Leer datos por identificador
    List<Datos> readAll(); // Leer todos los registros de datos
    void update(Datos datos); // Actualizar un registro de datos
    void delete(int id); // Eliminar un registro de datos por ID
}
