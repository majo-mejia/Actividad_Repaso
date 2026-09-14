package co.edu.uniquindio.poo.tallerbicicletas.model;

import java.util.List;

public class Repuesto {
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private int stock;
    private List<Repuesto> listaRepuestos;

    public Repuesto(String codigo, String nombre, double precioUnitario, int stock,  List<Repuesto> listaRepuestos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.listaRepuestos = listaRepuestos;
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
    public List<Repuesto> getListaRepuestos() {return listaRepuestos;
    }
    public void setListaRepuestos(List<Repuesto> listaRepuestos) {this.listaRepuestos = listaRepuestos;
    }
}
