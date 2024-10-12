package models;

public class Usuarios {
    private int id; // ID del usuario
    private String identificador; // Identificador del usuario
    private String nombres; // Nombres del usuario
    private String apellidos; // Apellidos del usuario
    private int rolId; // ID del rol del usuario

    // Constructor vacío
    public Usuarios() {}

    // Constructor completo
    public Usuarios(int id, String identificador, String nombres, String apellidos, int rolId) {
        this.id = id;
        this.identificador = identificador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rolId = rolId;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }
}
