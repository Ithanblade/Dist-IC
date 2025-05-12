package Evaluacion;

public class Estudiante {
    private int id;
    private String nombre;
    private String telefono;
    private String carrera;
    private int semestre;
    private boolean gratuidad;

    public Estudiante(int id, String nombre, String telefono, String carrera, int semestre, boolean gratuidad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.carrera = carrera;
        this.semestre = semestre;
        this.gratuidad = gratuidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public boolean isGratuidad() {
        return gratuidad;
    }

    public void setGratuidad(boolean gratuidad) {
        this.gratuidad = gratuidad;
    }

    @Override
    public String toString() {
        return "Estudiante ID: " + id + "\n" +
               "Nombre: " + nombre + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Carrera: " + carrera + "\n" +
               "Semestre: " + semestre + "\n" +
               "Gratuidad: " + (gratuidad ? "Sí" : "No");
    }
}

