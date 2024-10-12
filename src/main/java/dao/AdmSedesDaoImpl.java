package dao;

import models.AdmSedes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class AdmSedesDaoImpl implements AdmSedesDao {
    private Connection connection;

    public AdmSedesDaoImpl() {
        connection = DBConnection.getConnection(); // Obtener conexión de DB
    }

    @Override
    public void create(AdmSedes admSede) {
        String sql = "INSERT INTO AdmSedes (SedeID, Encargado_Mañana, Encargado_Tarde, Fecha_Inicio, Fecha_Fin) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, admSede.getSedeId());
            stmt.setInt(2, admSede.getEncargadoManana());
            stmt.setInt(3, admSede.getEncargadoTarde());
            stmt.setDate(4, new java.sql.Date(admSede.getFechaInicio().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setDate(5, new java.sql.Date(admSede.getFechaFin().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AdmSedes read(int id) {
        String sql = "SELECT * FROM AdmSedes WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new AdmSedes(rs.getInt("ID"),
                                    rs.getInt("SedeID"),
                                    rs.getInt("Encargado_Mañana"),
                                    rs.getInt("Encargado_Tarde"),
                                    rs.getDate("Fecha_Inicio"),
                                    rs.getDate("Fecha_Fin"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AdmSedes> readAll() {
        List<AdmSedes> admSedesList = new ArrayList<>();
        String sql = "SELECT * FROM AdmSedes";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                admSedesList.add(new AdmSedes(rs.getInt("ID"),
                                               rs.getInt("SedeID"),
                                               rs.getInt("Encargado_Mañana"),
                                               rs.getInt("Encargado_Tarde"),
                                               rs.getDate("Fecha_Inicio"),
                                               rs.getDate("Fecha_Fin")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admSedesList;
    }

    @Override
    public void update(AdmSedes admSede) {
        String sql = "UPDATE AdmSedes SET SedeID = ?, Encargado_Mañana = ?, Encargado_Tarde = ?, Fecha_Inicio = ?, Fecha_Fin = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, admSede.getSedeId());
            stmt.setInt(2, admSede.getEncargadoManana());
            stmt.setInt(3, admSede.getEncargadoTarde());
            stmt.setDate(4, new java.sql.Date(admSede.getFechaInicio().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setDate(5, new java.sql.Date(admSede.getFechaFin().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setInt(6, admSede.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM AdmSedes WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
