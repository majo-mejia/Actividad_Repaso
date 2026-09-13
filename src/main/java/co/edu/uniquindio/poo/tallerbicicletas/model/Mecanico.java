package co.edu.uniquindio.poo.tallerbicicletas.model;

public class Mecanico {

    private String nombre;
    private EspecialidadMecanico especialidad;
    private String codigoCertificado;

    public Mecanico(String nombre, EspecialidadMecanico especialidad, String codigoCertificado) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.codigoCertificado = codigoCertificado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EspecialidadMecanico getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadMecanico especialidad) {
        this.especialidad = especialidad;
    }

    public String getCodigoCertificado() {
        return codigoCertificado;
    }

    public void setCodigoCertificado(String codigoCertificado) {
        this.codigoCertificado = codigoCertificado;
    }

    @Override
    public String toString() {
        return "Mecanico {" +
                "nombre='" + nombre + '\'' +
                ", especialidad=" + especialidad +
                ", codigoCertificado='" + codigoCertificado + '\'' +
                '}';
}

}
