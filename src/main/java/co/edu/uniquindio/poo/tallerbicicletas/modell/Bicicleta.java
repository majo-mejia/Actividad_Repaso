package co.edu.uniquindio.poo.tallerbicicletas.modell;

public class Bicicleta {
    private String marca;
    private String color;
    private String numeroMarco;
    private String anio;
    private TipoBicicleta tipoBicicleta;


    public Bicicleta(String marca, String color, String numeroMarco, String anio, TipoBicicleta tipoBicicleta) {
        this.marca = marca;
        this.color = color;
        this.numeroMarco = numeroMarco;
        this.anio = anio;
        this.tipoBicicleta = tipoBicicleta;
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

    @Override
    public String toString() {
        return marca + " " + color + " " + numeroMarco + " " + anio;
    }
}
