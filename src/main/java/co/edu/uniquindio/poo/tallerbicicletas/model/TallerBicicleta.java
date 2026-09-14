package co.edu.uniquindio.poo.tallerbicicletas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TallerBicicleta {
    private String nit;
    private String nombreTallerBicicleta;
    private String direccion;

    private List<Repuesto> listaRepuestos;
    private List<Cliente> listaClientes;
    private List<Mecanico> listaMecanicos;
    private List<Bicicleta> listaBicicletas;
    private List<OrdenServicio> listaOrdenServicios;

    public TallerBicicleta(String nit, String nombreTallerBicicleta, String direccion) {
        this.nit = nit;
        this.nombreTallerBicicleta = nombreTallerBicicleta;
        this.direccion = direccion;

        this.listaRepuestos = new ArrayList<>();
        this.listaBicicletas = new ArrayList<>();
        this.listaMecanicos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaOrdenServicios = new ArrayList<>();
    }

    //CRUD clientes
    public boolean agregarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getDocumento()).isEmpty()){
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }
    public Optional<Cliente> buscarCliente(String documento){

    }

    public String getNit() {return nit;
    }
    public void setNit(String nit) {this.nit = nit;
    }
    public String getNombreTallerBicicleta() {return nombreTallerBicicleta;
    }
    public void setNombreTallerBicicleta(String nombreTallerBicicleta) {this.nombreTallerBicicleta = nombreTallerBicicleta;
    }
    public String getDireccion() {return direccion;
    }
    public void setDireccion(String direccion) {this.direccion = direccion;
    }
    public List<Repuesto> getListaRepuestos() {return listaRepuestos;
    }
    public void setListaRepuestos(List<Repuesto> listaRepuestos) {this.listaRepuestos = listaRepuestos;
    }
    public List<Cliente> getListaClientes() {return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {this.listaClientes = listaClientes;
    }
    public List<Mecanico> getListaMecanicos() {return listaMecanicos;
    }
    public void setListaMecanicos(List<Mecanico> listaMecanicos) {this.listaMecanicos = listaMecanicos;
    }
    public List<Bicicleta> getListaBicicletas() {return listaBicicletas;
    }
    public void setListaBicicletas(List<Bicicleta> listaBicicletas) {this.listaBicicletas = listaBicicletas;
    }
    public List<OrdenServicio> getListaOrdenServicios() {return listaOrdenServicios;
    }
    public void setListaOrdenServicios(List<OrdenServicio> listaOrdenServicios) {this.listaOrdenServicios = listaOrdenServicios;
    }
}
