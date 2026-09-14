package co.edu.uniquindio.poo.tallerbicicletas.model;

import java.util.List;

public class Bicicleta {
    private String marca;
    private String color;
    private String numeroMarco;
    private String anio;
    private TipoBicicleta tipoBicicleta;
    private List<Bicicleta> listaBicicleta;


    public Bicicleta(String marca, String color, String numeroMarco, String anio, TipoBicicleta tipoBicicleta, List<Bicicleta> listaBicicleta) {
        this.marca = marca;
        this.color = color;
        this.numeroMarco = numeroMarco;
        this.anio = anio;
        this.tipoBicicleta = tipoBicicleta;
        this.listaBicicleta = listaBicicleta;
    }

    public String getMarca() {return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getColor() {return color;
    }
    public void setColor(String color) {this.color = color;
    }
    public String getNumeroMarco() {return numeroMarco;
    }
    public void setNumeroMarco(String numeroMarco) {this.numeroMarco = numeroMarco;
    }
    public String getAnio() {return anio;
    }
    public void setAnio(String anio) {this.anio = anio;
    }

    public TipoBicicleta getTipoBicicleta() {return tipoBicicleta;
    }
    public void setTipoBicicleta(TipoBicicleta tipoBicicleta) {this.tipoBicicleta = tipoBicicleta;
    }
    public List<Bicicleta> getListaBicicleta() {return listaBicicleta;
    }
    public void setListaBicicleta(List<Bicicleta> listaBicicleta) {this.listaBicicleta = listaBicicleta;
    }

    @Override
    public String toString() {
        return marca + " " + color + " " + numeroMarco + " " + anio;
    }
}
