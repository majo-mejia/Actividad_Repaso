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

    public TallerBicicleta() {
        this.nit = nit;
        this.nombreTallerBicicleta = nombreTallerBicicleta;
        this.direccion = direccion;

        this.listaRepuestos = new ArrayList<>();
        this.listaBicicletas = new ArrayList<>();
        this.listaMecanicos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaOrdenServicios = new ArrayList<>();
    }

    // ==========================================
    // CRUD CLIENTES
    // ==========================================

    // CREATE
    public boolean agregarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getDocumento()).isEmpty()){
            listaClientes.add(cliente);
            return true;
        }
        return false;
    }

    // READ
    public Optional<Cliente> buscarCliente(String documento){
        return listaClientes.stream()
                .filter(cliente -> cliente.getDocumento().equals(documento))
                .findFirst();
    }

    // UPDATE
    public boolean actualizarCliente(String documento, Cliente clienteActualizado) {
        Optional<Cliente> clienteEncontrado = buscarCliente(documento);
        if (clienteEncontrado.isPresent()) {
            Cliente cliente = clienteEncontrado.get();
            cliente.setNombreCompleto(clienteActualizado.getNombreCompleto());
            cliente.setTelefono(clienteActualizado.getTelefono());
            cliente.setDireccion(clienteActualizado.getDireccion());
            // No se actualiza el documento ya que es el identificador único
            return true;
        }
        return false;
    }

    // DELETE
    public boolean eliminarCliente(String documento) {
        return listaClientes.removeIf(cliente -> cliente.getDocumento().equals(documento));
    }


    // ==========================================
    // CRUD BICICLETAS
    // ==========================================

    // CREATE
    public boolean agregarBicicleta(Bicicleta bicicleta) {
        if (buscarBicicleta(bicicleta.getNumeroMarco()).isEmpty()){
            listaBicicletas.add(bicicleta);
            return true;
        }
        return false;
    }

    // READ
    public Optional<Bicicleta> buscarBicicleta(String numeroMarco){
        return listaBicicletas.stream()
                .filter(bici -> bici.getNumeroMarco().equals(numeroMarco))
                .findFirst();
    }

    // UPDATE
    public boolean actualizarBicicleta(String numeroMarco, Bicicleta bicicletaActualizada) {
        Optional<Bicicleta> bicicletaEncontrada = buscarBicicleta(numeroMarco);
        if (bicicletaEncontrada.isPresent()) {
            Bicicleta bicicleta = bicicletaEncontrada.get();
            bicicleta.setMarca(bicicletaActualizada.getMarca());
            bicicleta.setColor(bicicletaActualizada.getColor());
            bicicleta.setAnio(bicicletaActualizada.getAnio());
            bicicleta.setTipoBicicleta(bicicletaActualizada.getTipoBicicleta());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean eliminarBicicleta(String numeroMarco) {
        return listaBicicletas.removeIf(bici -> bici.getNumeroMarco().equals(numeroMarco));
    }


    // ==========================================
    // CRUD MECÁNICOS
    // ==========================================

    // CREATE
    public boolean agregarMecanico(Mecanico mecanico) {
        if (buscarMecanico(mecanico.getCodigoCertificado()).isEmpty()){
            listaMecanicos.add(mecanico);
            return true;
        }
        return false;
    }

    // READ
    public Optional<Mecanico> buscarMecanico(String codigoCertificado){
        return listaMecanicos.stream()
                .filter(mec -> mec.getCodigoCertificado().equals(codigoCertificado))
                .findFirst();
    }

    // UPDATE
    public boolean actualizarMecanico(String codigoCertificado, Mecanico mecanicoActualizado) {
        Optional<Mecanico> mecanicoEncontrado = buscarMecanico(codigoCertificado);
        if (mecanicoEncontrado.isPresent()) {
            Mecanico mecanico = mecanicoEncontrado.get();
            mecanico.setNombre(mecanicoActualizado.getNombre());
            mecanico.setEspecialidad(mecanicoActualizado.getEspecialidad());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean eliminarMecanico(String codigoCertificado) {
        return listaMecanicos.removeIf(mec -> mec.getCodigoCertificado().equals(codigoCertificado));
    }


    // ==========================================
    // CRUD REPUESTOS
    // ==========================================

    // CREATE
    public boolean agregarRepuesto(Repuesto repuesto) {
        if (buscarRepuesto(repuesto.getCodigo()).isEmpty()){
            listaRepuestos.add(repuesto);
            return true;
        }
        return false;
    }

    // READ
    public Optional<Repuesto> buscarRepuesto(String codigo){
        return listaRepuestos.stream()
                .filter(rep -> rep.getCodigo().equals(codigo))
                .findFirst();
    }

    // UPDATE
    public boolean actualizarRepuesto(String codigo, Repuesto repuestoActualizado) {
        Optional<Repuesto> repuestoEncontrado = buscarRepuesto(codigo);
        if (repuestoEncontrado.isPresent()) {
            Repuesto repuesto = repuestoEncontrado.get();
            repuesto.setNombre(repuestoActualizado.getNombre());
            repuesto.setPrecioUnitario(repuestoActualizado.getPrecioUnitario());
            repuesto.setStock(repuestoActualizado.getStock());
            return true;
        }
        return false;
    }

    // DELETE
    public boolean eliminarRepuesto(String codigo) {
        return listaRepuestos.removeIf(rep -> rep.getCodigo().equals(codigo));
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
