package co.edu.uniquindio.poo.tallerbicicletas.modell;

public class Repuesto {
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int stock;

    public Repuesto(String codigo, String nombre, double precioUnitario, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
    }

    public String getCodigo() {return codigo;
    }
    public void setCodigo(String codigo) {this.codigo = codigo;
    }
    public String getNombre() {return nombre;
    }
    public void setNombre(String nombre) {this.nombre = nombre;
    }
    public double getPrecioUnitario() {return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {this.precioUnitario = precioUnitario;
    }
    public int getStock() {return stock;
    }
    public void setStock(int stock) {this.stock = stock;
    }
}
