package models;

public class Sedes {
    private int id; // ID de la sede
    private String nombreSede; // Nombre de la sede
    private String correo; // Correo de la sede
    private String direccion; // Dirección de la sede

    // Constructor vacío
    public Sedes() {}

    // Constructor completo
    public Sedes(int id, String nombreSede, String correo, String direccion) {
        this.id = id;
        this.nombreSede = nombreSede;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
