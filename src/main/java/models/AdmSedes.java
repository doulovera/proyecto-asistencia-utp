package models;

import java.util.Date;

public class AdmSedes {
    private int id; // ID del registro de administración de sede
    private int sedeId; // ID de la sede
    private int encargadoManana; // ID del encargado de la mañana
    private int encargadoTarde; // ID del encargado de la tarde
    private Date fechaInicio; // Fecha de inicio
    private Date fechaFin; // Fecha de fin

    // Constructor vacío
    public AdmSedes() {}

    // Constructor completo
    public AdmSedes(int id, int sedeId, int encargadoManana, int encargadoTarde, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.sedeId = sedeId;
        this.encargadoManana = encargadoManana;
        this.encargadoTarde = encargadoTarde;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSedeId() {
        return sedeId;
    }

    public void setSedeId(int sedeId) {
        this.sedeId = sedeId;
    }

    public int getEncargadoManana() {
        return encargadoManana;
    }

    public void setEncargadoManana(int encargadoManana) {
        this.encargadoManana = encargadoManana;
    }

    public int getEncargadoTarde() {
        return encargadoTarde;
    }

    public void setEncargadoTarde(int encargadoTarde) {
        this.encargadoTarde = encargadoTarde;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
