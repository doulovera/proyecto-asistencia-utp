package dao;

import models.Sedes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class SedesDaoImpl implements SedesDao {
    private Connection connection;

    public SedesDaoImpl() {
        connection = DBConnection.getConnection(); // Obtener conexión de DB
    }

    @Override
    public void create(Sedes sede) {
        String sql = "INSERT INTO Sedes (Nombre_Sede, Correo, Direccion) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, sede.getNombreSede());
            stmt.setString(2, sede.getCorreo());
            stmt.setString(3, sede.getDireccion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sedes read(int id) {
        String sql = "SELECT * FROM Sedes WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Sedes(rs.getInt("ID"),
                                 rs.getString("Nombre_Sede"),
                                 rs.getString("Correo"),
                                 rs.getString("Direccion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Sedes> readAll() {
        List<Sedes> sedesList = new ArrayList<>();
        String sql = "SELECT * FROM Sedes";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                sedesList.add(new Sedes(rs.getInt("ID"),
                                        rs.getString("Nombre_Sede"),
                                        rs.getString("Correo"),
                                        rs.getString("Direccion")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sedesList;
    }

    @Override
    public void update(Sedes sede) {
        String sql = "UPDATE Sedes SET Nombre_Sede = ?, Correo = ?, Direccion = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, sede.getNombreSede());
            stmt.setString(2, sede.getCorreo());
            stmt.setString(3, sede.getDireccion());
            stmt.setInt(4, sede.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Sedes WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
