package models;

import java.util.Date;

public class Datos {
    private int id; // ID del usuario
    private String dni; // DNI del usuario
    private String correoElectronico; // Correo electrónico del usuario
    private Date fechaNacimiento; // Fecha de nacimiento del usuario
    private String rutaFoto; // Ruta de la foto del usuario
    private String rutaDocumentos; // Ruta de los documentos del usuario

    // Constructor vacío
    public Datos() {}

    // Constructor completo
    public Datos(int id, String dni, String correoElectronico, Date fechaNacimiento, String rutaFoto, String rutaDocumentos) {
        this.id = id;
        this.dni = dni;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.rutaFoto = rutaFoto;
        this.rutaDocumentos = rutaDocumentos;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public String getRutaDocumentos() {
        return rutaDocumentos;
    }

    public void setRutaDocumentos(String rutaDocumentos) {
        this.rutaDocumentos = rutaDocumentos;
    }
}
