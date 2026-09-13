package co.edu.uniquindio.poo.tallerbicicletas.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrdenServicio {

      private LocalDate fechaIngreso;
      private LocalTime horaIngreso;
      private String motivoIngreso;
      private String diagnostico;

    public OrdenServicio(LocalDate fechaIngreso, LocalTime horaIngreso, String motivoIngreso, String diagnostico) {
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.motivoIngreso = motivoIngreso;
        this.diagnostico = diagnostico;
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

    @Override
    public String toString() {
        return "OrdenServicio{" +
                "fechaIngreso=" + fechaIngreso +
                ", horaIngreso=" + horaIngreso +
                ", motivoIngreso='" + motivoIngreso + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                '}';
    }
}
