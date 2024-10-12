package models;

import java.sql.Time;
import java.util.Date;

public class Horarios {
    private int id; // ID del horario
    private int usuarioId; // ID del usuario
    private Date fecha; // Fecha del registro
    private Time horaIngreso; // Hora de ingreso
    private Time horaSalida; // Hora de salida

    // Constructor vacío
    public Horarios() {}

    // Constructor completo
    public Horarios(int id, int usuarioId, Date fecha, Time horaIngreso, Time horaSalida) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(Time horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }
}
