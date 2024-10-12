package dao;

import models.Usuarios;
import java.util.List;

public interface UsuarioDao {
    void create(Usuarios usuario); // Crear un nuevo usuario
    Usuarios read(int id); // Leer un usuario por ID
    List<Usuarios> readAll(); // Leer todos los usuarios
    void update(Usuarios usuario); // Actualizar un usuario existente
    void delete(int id); // Eliminar un usuario por ID
    Usuarios buscarPorIdentificador(String identificador);
}
