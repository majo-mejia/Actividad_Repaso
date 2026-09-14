package co.edu.uniquindio.poo.tallerbicicletas.model;


import co.edu.uniquindio.poo.tallerbicicletas.modell.Cliente;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Repuesto;

import java.util.ArrayList;
import java.util.List;

public class TallerBicicletas {

    private List<Cliente> clientes;
    private List<Mecanico> mecanicos;
    private List<Repuesto> repuestos;
    private List<OrdenServicio> ordenes;

    public TallerBicicletas() {
        this.clientes = new ArrayList<>();
        this.mecanicos = new ArrayList<>();
        this.repuestos = new ArrayList<>();
        this.ordenes = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public List<Repuesto> getRepuestos() {
        return repuestos;
    }

    public List<OrdenServicio> getOrdenes() {
        return ordenes;
    }
}