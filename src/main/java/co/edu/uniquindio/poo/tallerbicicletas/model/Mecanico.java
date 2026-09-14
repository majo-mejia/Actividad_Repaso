package co.edu.uniquindio.poo.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;

public class Mecanico {

    private String nombre;
    private EspecialidadMecanico especialidad;
    private String codigoCertificado;
    private List<Mecanico> listaMecanicos;

    public Mecanico(String nombre, EspecialidadMecanico especialidad, String codigoCertificado,  List<Mecanico> listaMecanicos) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.codigoCertificado = codigoCertificado;
        this.listaMecanicos = listaMecanicos;
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
    public List<Mecanico> getListaMecanicos() {return listaMecanicos;
    }
    public void setListaMecanicos(List<Mecanico> listaMecanicos) {this.listaMecanicos = listaMecanicos;
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
