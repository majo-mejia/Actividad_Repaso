package co.edu.uniquindio.poo.tallerbicicletas.model;

import co.edu.uniquindio.poo.tallerbicicletas.model.DetalleServicio;
import co.edu.uniquindio.poo.tallerbicicletas.model.Mecanico;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Bicicleta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrdenServicio {

    private LocalDate fechaIngreso;
    private LocalTime horaIngreso;
    private String motivoIngreso;
    private String diagnostico;
    private Bicicleta bicicleta;
    private Mecanico mecanico;
    private List<DetalleServicio> detalles;

    public OrdenServicio(LocalDate fechaIngreso, LocalTime horaIngreso, String motivoIngreso,
                         Bicicleta bicicleta, Mecanico mecanico) {
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.motivoIngreso = motivoIngreso;
        this.bicicleta = bicicleta;
        this.mecanico = mecanico;
        this.diagnostico = null;
        this.detalles = new ArrayList<>();
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getMotivoIngreso() {
        return motivoIngreso;
    }

    public void setMotivoIngreso(String motivoIngreso) {
        this.motivoIngreso = motivoIngreso;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public List<DetalleServicio> getDetalles() {
        return detalles;
    }

    public void agregarDetalle(DetalleServicio detalle) {
        if (detalle != null) {
            detalles.add(detalle);
        }
    }

    public double calcularCostoTotal() {
        double total = 0;
        for (DetalleServicio d : detalles) {
            total += d.calcularSubtotal();
        }
        return total;
    }

    public String generarResumenTrabajos() {
        String resumen = "";
        for (DetalleServicio d : detalles) {
            resumen = resumen + d.getDescripcion() + "; ";
        }
        return resumen;
    }

    @Override
    public String toString() {
        return "OrdenServicio{" +
                "fechaIngreso=" + fechaIngreso +
                ", horaIngreso=" + horaIngreso +
                ", motivoIngreso='" + motivoIngreso + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", bicicleta=" + bicicleta +
                ", mecanico=" + mecanico +
                ", costoTotal=" + calcularCostoTotal() +
                '}';
    }
}
