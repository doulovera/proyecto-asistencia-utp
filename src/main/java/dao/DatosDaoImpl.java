package dao;

import models.Datos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class DatosDaoImpl implements DatosDao {
    private Connection connection;

    public DatosDaoImpl() {
        connection = DBConnection.getConnection(); // Obtener conexión de DB
    }

    @Override
public void create(Datos datos) {
    String sql = "INSERT INTO Datos (ID, DNI, Correo_Electronico, Fecha_Nacimiento, Ruta_Foto, Ruta_Documentos) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, datos.getId());
        stmt.setString(2, datos.getDni());
        stmt.setString(3, datos.getCorreoElectronico());
        stmt.setDate(4, new java.sql.Date(datos.getFechaNacimiento().getTime()));
        stmt.setString(5, datos.getRutaFoto());
        stmt.setString(6, datos.getRutaDocumentos());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// En el método read
@Override
public Datos read(int id) {
    String sql = "SELECT * FROM Datos WHERE ID = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Datos(rs.getInt("ID"),
                             rs.getString("DNI"),
                             rs.getString("Correo_Electronico"),
                             rs.getDate("Fecha_Nacimiento"),
                             rs.getString("Ruta_Foto"),
                             rs.getString("Ruta_Documentos"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    @Override
    public List<Datos> readAll() {
        List<Datos> datosList = new ArrayList<>();
        String sql = "SELECT * FROM Datos";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                datosList.add(new Datos(rs.getInt("ID"),
                                        rs.getString("DNI"),
                                        rs.getString("Correo_Electronico"),
                                        rs.getDate("Fecha_Nacimiento"),
                                        rs.getString("Ruta_Foto"),
                                        rs.getString("Ruta_Documentos")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datosList;
    }

    @Override
    public void update(Datos datos) {
        String sql = "UPDATE Datos SET DNI = ?, Correo_Electronico = ?, Fecha_Nacimiento = ?, Ruta_Foto = ?, Ruta_Documentos = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, datos.getDni());
            stmt.setString(2, datos.getCorreoElectronico());
            stmt.setDate(3, new java.sql.Date(datos.getFechaNacimiento().getTime()));
            stmt.setString(4, datos.getRutaFoto());
            stmt.setString(5, datos.getRutaDocumentos());
            stmt.setInt(6, datos.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Datos WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
