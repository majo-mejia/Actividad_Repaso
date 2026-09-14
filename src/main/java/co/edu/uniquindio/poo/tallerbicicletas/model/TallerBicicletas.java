package co.edu.uniquindio.poo.tallerbicicletas.model;

import co.edu.uniquindio.poo.tallerbicicletas.modell.Bicicleta;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Cliente;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Repuesto;
import co.edu.uniquindio.poo.tallerbicicletas.modell.TipoBicicleta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TallerBicicletas {

    private String nombreTaller;
    private String nit;
    private String direccion;

    private List<Cliente> clientes;
    private List<Bicicleta> bicicletas;
    private List<Mecanico> mecanicos;
    private List<Repuesto> repuestos;
    private List<OrdenServicio> ordenes;

    public TallerBicicletas(String nombreTaller, String nit, String direccion) {
        this.nombreTaller= nombreTaller;
        this.nit = nit;
        this. direccion = direccion;

        this.clientes = new ArrayList<>();
        this.bicicletas = new ArrayList<>();
        this.mecanicos = new ArrayList<>();
        this.repuestos = new ArrayList<>();
        this.ordenes = new ArrayList<>();

        cargarDatosDePrueba();
    }

    //getters

    public String getNombreTaller() {
        return nombreTaller;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Cliente> getClientes() { return clientes; }
    public List<Bicicleta> getBicicletas() { return bicicletas; }
    public List<Mecanico> getMecanicos() { return mecanicos; }
    public List<Repuesto> getRepuestos() { return repuestos; }
    public List<OrdenServicio> getOrdenes() { return ordenes; }



    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void registrarBicicleta(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
    }

    public void registrarMecanico(Mecanico mecanico) {
        mecanicos.add(mecanico);
    }

    public void registrarRepuesto(Repuesto repuesto) {
        repuestos.add(repuesto);
    }



    public OrdenServicio crearOrdenServicio(LocalDate fecha, LocalTime hora, String motivo,
                                            Bicicleta bicicleta, Mecanico mecanico) {
        OrdenServicio orden = new OrdenServicio(fecha, hora, motivo, bicicleta, mecanico);
        ordenes.add(orden);
        return orden;
    }

    public List<OrdenServicio> consultarHistorialPorSerial(String numeroMarco) {
        List<OrdenServicio> historial = new ArrayList<>();
        for (OrdenServicio orden : ordenes) {
            if (orden.getBicicleta().getNumeroMarco().equalsIgnoreCase(numeroMarco)) {
                historial.add(orden);
            }
        }
        return historial;
    }

    public List<OrdenServicio> consultarOrdenesPorFecha(LocalDate fecha) {
        List<OrdenServicio> resultado = new ArrayList<>();
        for (OrdenServicio orden : ordenes) {
            if (orden.getFechaIngreso().equals(fecha)) {
                resultado.add(orden);
            }
        }
        return resultado;
    }

    public List<Repuesto> listarRepuestosStockBajo() {
        List<Repuesto> alerta = new ArrayList<>();
        for (Repuesto repuesto : repuestos) {
            if (repuesto.getStock() < 5) {
                alerta.add(repuesto);
            }
        }
        return alerta;
    }

    private void cargarDatosDePrueba() {
        // clientes
        Cliente cliente1 = new Cliente("1001", "Maria Lopez", "3001112233", "Calle 10 #5-20");
        Cliente cliente2 = new Cliente("1002", "Juan Perez", "3002223344", "Carrera 8 #12-30");
        registrarCliente(cliente1);
        registrarCliente(cliente2);

        // bicicletas
        Bicicleta bici1 = new Bicicleta("Trek", "Rojo", "MARCO123", "2022", TipoBicicleta.RUTA, cliente1);
        Bicicleta bici2 = new Bicicleta("GW", "Azul", "MARCO456", "2020", TipoBicicleta.MTB, cliente2);
        registrarBicicleta(bici1);
        registrarBicicleta(bici2);

        // mecánicos
        Mecanico mecanico1 = new Mecanico("Carlos Ruiz", EspecialidadMecanico.FRENOS_Y_TRANSMISION, "MEC001");
        Mecanico mecanico2 = new Mecanico("Ana Torres", EspecialidadMecanico.SUSPENSION, "MEC002");
        registrarMecanico(mecanico1);
        registrarMecanico(mecanico2);

        // repuestos
        Repuesto repuesto1 = new Repuesto("R001", "Pastillas de freno", 25000, 12);
        Repuesto repuesto2 = new Repuesto("R002", "Cadena", 40000, 3); // Stock bajo para probar alertas
        registrarRepuesto(repuesto1);
        registrarRepuesto(repuesto2);

        // ordenes servicio
        crearOrdenServicio(LocalDate.now(), LocalTime.now(), "Frenos largos, no responden", bici1, mecanico1);
    }
}