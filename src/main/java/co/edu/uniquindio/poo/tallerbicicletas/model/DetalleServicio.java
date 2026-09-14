package co.edu.uniquindio.poo.tallerbicicletas.model;

public class DetalleServicio {

    private String descripcion;
    private TipoDetalle tipo;
    private int cantidad;
    private double costoUnitario;
    private Repuesto repuesto;

    public DetalleServicio(String descripcion, TipoDetalle tipo, int cantidad, double costoUnitario, Repuesto repuesto) {
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.repuesto = repuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoDetalle getTipo() {
        return tipo;
    }

    public void setTipo(TipoDetalle tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }

    // metodo
    public double calcularSubtotal(){
        return cantidad * costoUnitario;
    }

    @Override
    public String toString() {
        return "DetalleServicio{" +
                "descripcion='" + descripcion + '\'' +
                ", tipo=" + tipo +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                ", repuesto=" + repuesto +
                '}';
    }
}
