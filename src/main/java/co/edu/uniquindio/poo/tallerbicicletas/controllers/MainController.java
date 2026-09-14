package co.edu.uniquindio.poo.tallerbicicletas.controllers;

// --- IMPORTACIONES DE TUS MODELOS ---
import co.edu.uniquindio.poo.tallerbicicletas.model.TallerBicicletas;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Cliente;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Bicicleta;
import co.edu.uniquindio.poo.tallerbicicletas.modell.TipoBicicleta;
import co.edu.uniquindio.poo.tallerbicicletas.model.Mecanico;
import co.edu.uniquindio.poo.tallerbicicletas.model.EspecialidadMecanico;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Repuesto;
import co.edu.uniquindio.poo.tallerbicicletas.model.OrdenServicio;

// --- IMPORTACIONES DE JAVAFX ---
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

// --- IMPORTACIONES DE FECHAS (JAVA) ---
import java.time.LocalDate;
import java.time.LocalTime;

public class MainController {

    private TallerBicicletas taller = new TallerBicicletas();

    // ==========================================
    //         LISTAS OBSERVABLES Y VARIABLES
    // ==========================================

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private ObservableList<Bicicleta> listaBicicletas = FXCollections.observableArrayList();
    private ObservableList<Mecanico> listaMecanicos = FXCollections.observableArrayList();
    private ObservableList<Repuesto> listaRepuestos = FXCollections.observableArrayList();
    private ObservableList<OrdenServicio> listaOrdenes = FXCollections.observableArrayList();

    // PESTAÑA CLIENTES
    @FXML private TextField txtDocCliente, txtNomCliente, txtTelCliente, txtDirCliente;
    @FXML private TableView<Cliente> tblClientes;
    @FXML private TableColumn<Cliente, String> colDocCliente, colNomCliente, colTelCliente, colDirCliente;

    // PESTAÑA BICICLETAS
    @FXML private ComboBox<Cliente> cmbClienteBicicleta;
    @FXML private ComboBox<TipoBicicleta> cmbTipoBicicleta;
    @FXML private TextField txtMarcaBici, txtColorBici, txtSerialBici, txtAnioBici;
    @FXML private TableView<Bicicleta> tblBicicletas;
    @FXML private TableColumn<Bicicleta, String> colSerialBici, colMarcaBici, colTipoBici, colDuenoBici;

    // PESTAÑA MECÁNICOS
    @FXML private ComboBox<EspecialidadMecanico> cmbEspecialidadMecanico;
    @FXML private TextField txtNomMecanico, txtCodMecanico;
    @FXML private TableView<Mecanico> tblMecanicos;
    @FXML private TableColumn<Mecanico, String> colCodMecanico, colNomMecanico, colEspMecanico;

    // PESTAÑA REPUESTOS
    @FXML private TextField txtCodRepuesto, txtNomRepuesto, txtPrecioRepuesto, txtStockRepuesto;
    @FXML private TableView<Repuesto> tblRepuestos;
    @FXML private TableColumn<Repuesto, String> colCodRepuesto, colNomRepuesto;
    @FXML private TableColumn<Repuesto, Integer> colStockRepuesto;

    // PESTAÑA NUEVA ORDEN
    @FXML private DatePicker dpFechaOrden;
    @FXML private ComboBox<Bicicleta> cmbBiciOrden;
    @FXML private ComboBox<Mecanico> cmbMecanicoOrden;
    @FXML private TextArea txtMotivoOrden;
    @FXML private TableView<OrdenServicio> tblOrdenes;
    @FXML private TableColumn<OrdenServicio, String> colFechaOrden, colBiciOrden, colMecOrden;

    // PESTAÑAS DE BÚSQUEDA
    @FXML private TextField txtBusquedaSerial;
    @FXML private ListView<String> lstHistorial;
    @FXML private DatePicker dpBusquedaFecha;
    @FXML private ListView<String> lstOrdenesDia;

    // ==========================================
    //         MÉTODO INICIALIZADOR
    // ==========================================

    @FXML
    public void initialize() {
        // Clientes
        colDocCliente.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colNomCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colTelCliente.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDirCliente.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tblClientes.setItems(listaClientes);

        // Bicicletas
        cmbTipoBicicleta.getItems().addAll(TipoBicicleta.values());
        cmbClienteBicicleta.setItems(listaClientes);
        colSerialBici.setCellValueFactory(new PropertyValueFactory<>("numeroMarco"));
        colMarcaBici.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colTipoBici.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoBicicleta().toString()));
        colDuenoBici.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNombreCompleto()));
        tblBicicletas.setItems(listaBicicletas);

        // Mecánicos
        cmbEspecialidadMecanico.getItems().addAll(EspecialidadMecanico.values());
        colCodMecanico.setCellValueFactory(new PropertyValueFactory<>("codigoCertificado"));
        colNomMecanico.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEspMecanico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEspecialidad().toString()));
        tblMecanicos.setItems(listaMecanicos);

        // Repuestos
        colCodRepuesto.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNomRepuesto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colStockRepuesto.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tblRepuestos.setItems(listaRepuestos);

        // Órdenes
        cmbBiciOrden.setItems(listaBicicletas);
        cmbMecanicoOrden.setItems(listaMecanicos);
        colFechaOrden.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        colBiciOrden.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBicicleta().getNumeroMarco()));
        colMecOrden.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMecanico().getNombre()));
        tblOrdenes.setItems(listaOrdenes);
    }

    // ==========================================
    //         MÉTODOS PARA LOS BOTONES
    // ==========================================

    @FXML
    public void registrarCliente(ActionEvent event) {
        String doc = txtDocCliente.getText();
        String nom = txtNomCliente.getText();
        String tel = txtTelCliente.getText();
        String dir = txtDirCliente.getText();

        if (doc.isEmpty() || nom.isEmpty()) {
            mostrarAlerta("Error", "El documento y el nombre son obligatorios.");
            return;
        }

        Cliente nuevoCliente = new Cliente(doc, nom, tel, dir);
        taller.getClientes().add(nuevoCliente);
        listaClientes.add(nuevoCliente);
        txtDocCliente.clear(); txtNomCliente.clear(); txtTelCliente.clear(); txtDirCliente.clear();
    }

    @FXML
    public void registrarBicicleta(ActionEvent event) {
        Cliente cliente = cmbClienteBicicleta.getValue();
        TipoBicicleta tipo = cmbTipoBicicleta.getValue();
        String marca = txtMarcaBici.getText();
        String color = txtColorBici.getText();
        String serial = txtSerialBici.getText();
        String anio = txtAnioBici.getText();

        if (cliente == null || tipo == null || serial.isEmpty()) {
            mostrarAlerta("Error", "Debe seleccionar cliente, tipo y llenar el serial.");
            return;
        }

        Bicicleta nuevaBici = new Bicicleta(marca, color, serial, anio, tipo, cliente);
        listaBicicletas.add(nuevaBici);
        txtMarcaBici.clear(); txtColorBici.clear(); txtSerialBici.clear(); txtAnioBici.clear();
        cmbClienteBicicleta.setValue(null); cmbTipoBicicleta.setValue(null);
    }

    @FXML
    public void registrarMecanico(ActionEvent event) {
        String nombre = txtNomMecanico.getText();
        String codigo = txtCodMecanico.getText();
        EspecialidadMecanico especialidad = cmbEspecialidadMecanico.getValue();

        if (nombre.isEmpty() || codigo.isEmpty() || especialidad == null) {
            mostrarAlerta("Error", "Todos los campos son obligatorios.");
            return;
        }

        Mecanico nuevoMecanico = new Mecanico(nombre, especialidad, codigo);
        taller.getMecanicos().add(nuevoMecanico);
        listaMecanicos.add(nuevoMecanico);
        txtNomMecanico.clear(); txtCodMecanico.clear(); cmbEspecialidadMecanico.setValue(null);
    }

    @FXML
    public void registrarRepuesto(ActionEvent event) {
        try {
            String cod = txtCodRepuesto.getText();
            String nom = txtNomRepuesto.getText();
            double precio = Double.parseDouble(txtPrecioRepuesto.getText());
            int stock = Integer.parseInt(txtStockRepuesto.getText());

            Repuesto rep = new Repuesto(cod, nom, precio, stock);
            listaRepuestos.add(rep);
            taller.getRepuestos().add(rep);
            txtCodRepuesto.clear(); txtNomRepuesto.clear(); txtPrecioRepuesto.clear(); txtStockRepuesto.clear();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Precio y stock deben ser números.");
        }
    }

    @FXML
    public void revisarStockBajo(ActionEvent event) {
        StringBuilder mensaje = new StringBuilder();
        for (Repuesto rep : listaRepuestos) {
            if (rep.getStock() < 5) {
                mensaje.append("- ").append(rep.getNombre()).append(" (Quedan ").append(rep.getStock()).append(")\n");
            }
        }
        if (mensaje.length() > 0) {
            mostrarAlerta("⚠️ Alerta de Stock Bajo", "Repuestos agotándose:\n\n" + mensaje.toString());
        } else {
            Alert info = new Alert(Alert.AlertType.INFORMATION);
            info.setHeaderText(null);
            info.setContentText("Todo el inventario está bien.");
            info.showAndWait();
        }
    }

    @FXML
    public void crearOrden(ActionEvent event) {
        LocalDate fecha = dpFechaOrden.getValue();
        Bicicleta bici = cmbBiciOrden.getValue();
        Mecanico mecanico = cmbMecanicoOrden.getValue();
        String motivo = txtMotivoOrden.getText();

        if (fecha == null || bici == null || mecanico == null || motivo.isEmpty()) {
            mostrarAlerta("Error", "Llene todos los campos.");
            return;
        }

        OrdenServicio orden = new OrdenServicio(fecha, LocalTime.now(), motivo, bici, mecanico);
        listaOrdenes.add(orden);
        taller.getOrdenes().add(orden);
        dpFechaOrden.setValue(null); cmbBiciOrden.setValue(null); cmbMecanicoOrden.setValue(null); txtMotivoOrden.clear();
    }

    @FXML
    public void buscarHistorialSerial(ActionEvent event) {
        lstHistorial.getItems().clear();
        String serialBuscado = txtBusquedaSerial.getText().trim();

        if (serialBuscado.isEmpty()) return;

        boolean encontrado = false;
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getBicicleta().getNumeroMarco().equalsIgnoreCase(serialBuscado)) {
                lstHistorial.getItems().add("Fecha: " + orden.getFechaIngreso() + " | Mecánico: " + orden.getMecanico().getNombre());
                encontrado = true;
            }
        }
        if (!encontrado) lstHistorial.getItems().add("Sin historial.");
    }

    @FXML
    public void buscarOrdenesDia(ActionEvent event) {
        lstOrdenesDia.getItems().clear();
        LocalDate fechaBuscada = dpBusquedaFecha.getValue();

        if (fechaBuscada == null) return;

        boolean encontrado = false;
        for (OrdenServicio orden : listaOrdenes) {
            if (orden.getFechaIngreso().equals(fechaBuscada)) {
                lstOrdenesDia.getItems().add("Bicicleta: " + orden.getBicicleta().getMarca() + " | Motivo: " + orden.getMotivoIngreso());
                encontrado = true;
            }
        }
        if (!encontrado) lstOrdenesDia.getItems().add("Sin órdenes.");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}