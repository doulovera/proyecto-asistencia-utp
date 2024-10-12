package dao;

import models.Usuarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class UsuarioDaoImpl implements UsuarioDao {
    private Connection connection;

    public UsuarioDaoImpl() {
        connection = DBConnection.getConnection(); // Obtener conexión de DB
    }

    @Override
    public void create(Usuarios usuario) {
        String sql = "INSERT INTO Usuarios (Identificador, Nombres, Apellidos, Rol_ID) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getIdentificador());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setInt(4, usuario.getRolId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuarios read(int id) {
        String sql = "SELECT * FROM Usuarios WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuarios(rs.getInt("ID"),
                                    rs.getString("Identificador"),
                                    rs.getString("Nombres"),
                                    rs.getString("Apellidos"),
                                    rs.getInt("Rol_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuarios> readAll() {
        List<Usuarios> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuarios(rs.getInt("ID"),
                                           rs.getString("Identificador"),
                                           rs.getString("Nombres"),
                                           rs.getString("Apellidos"),
                                           rs.getInt("Rol_ID")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void update(Usuarios usuario) {
        String sql = "UPDATE Usuarios SET Identificador = ?, Nombres = ?, Apellidos = ?, Rol_ID = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getIdentificador());
            stmt.setString(2, usuario.getNombres());
            stmt.setString(3, usuario.getApellidos());
            stmt.setInt(4, usuario.getRolId());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Usuarios WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public Usuarios buscarPorIdentificador(String identificador) {
        String sql = "SELECT * FROM Usuarios WHERE Identificador = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, identificador);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuarios(rs.getInt("ID"),
                                    rs.getString("Identificador"),
                                    rs.getString("Nombres"),
                                    rs.getString("Apellidos"),
                                    rs.getInt("Rol_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
