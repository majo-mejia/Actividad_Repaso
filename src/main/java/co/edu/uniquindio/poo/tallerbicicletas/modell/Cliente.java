package co.edu.uniquindio.poo.tallerbicicletas.modell;

public class Cliente {
    private String documento;
    private String nombreCompleto;
    private String telefono;
    private String direccion;

    public Cliente(String documento, String nombreCompleto, String telefono, String direccion) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.direccion = direccion;

    }

    public String getDocumento() {return documento;
    }
    public void setDocumento(String documento) {this.documento = documento;
    }
    public String getNombreCompleto() {return nombreCompleto;
    }
    public void setNombreCompleto(String nombreCompleto) {this.nombreCompleto = nombreCompleto;
    }
    public String getTelefono() {return telefono;
    }
    public void setTelefono(String telefono) {this.telefono = telefono;
    }
    public String getDireccion() {return direccion;
    }
    public void setDireccion(String direccion) {this.direccion = direccion;
    }

    @Override
    public String toString() {
        return documento + " " + nombreCompleto + " " + telefono + " " + direccion;
    }
}
