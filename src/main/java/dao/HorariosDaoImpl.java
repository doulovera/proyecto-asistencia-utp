package dao;

import models.Horarios;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class HorariosDaoImpl implements HorariosDao {
    private Connection connection;

    public HorariosDaoImpl() {
        connection = DBConnection.getConnection(); // Obtener conexión de DB
    }

    @Override
    public void create(Horarios horarios) {
        String sql = "INSERT INTO Horarios (UsuarioID, Fecha, Hora_Ingreso, Hora_Salida) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, horarios.getUsuarioId());
            stmt.setDate(2, new java.sql.Date(horarios.getFecha().getTime()));
            stmt.setTime(3, horarios.getHoraIngreso());
            stmt.setTime(4, horarios.getHoraSalida());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Horarios read(int id) {
        String sql = "SELECT * FROM Horarios WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Horarios(rs.getInt("ID"),
                                    rs.getInt("UsuarioID"),
                                    rs.getDate("Fecha"),
                                    rs.getTime("Hora_Ingreso"),
                                    rs.getTime("Hora_Salida"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Horarios> readAll() {
        List<Horarios> horariosList = new ArrayList<>();
        String sql = "SELECT * FROM Horarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                horariosList.add(new Horarios(rs.getInt("ID"),
                                               rs.getInt("UsuarioID"),
                                               rs.getDate("Fecha"), // Esto es un java.sql.Date
                                               rs.getTime("Hora_Ingreso"), // Convertir a LocalTime
                                               rs.getTime("Hora_Salida"))); // Convertir a LocalTime
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return horariosList;
    }

    @Override
    public void update(Horarios horarios) {
        String sql = "UPDATE Horarios SET UsuarioID = ?, Fecha = ?, Hora_Ingreso = ?, Hora_Salida = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, horarios.getUsuarioId());
            stmt.setDate(2, new java.sql.Date(horarios.getFecha().getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setTime(3, horarios.getHoraIngreso());
            stmt.setTime(4, horarios.getHoraSalida());
            stmt.setInt(5, horarios.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Horarios WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Horarios buscarPorIdentificadorYFecha(String identificador, java.sql.Date fecha) {
        String sql = "SELECT h.* FROM Horarios h JOIN Usuarios u ON h.UsuarioID = u.ID WHERE u.Identificador = ? AND h.Fecha = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, identificador);
            stmt.setDate(2, fecha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Horarios(rs.getInt("ID"),
                                    rs.getInt("UsuarioID"),
                                    rs.getDate("Fecha"),
                                    rs.getTime("Hora_Ingreso"),
                                    rs.getTime("Hora_Salida"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
