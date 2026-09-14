package co.edu.uniquindio.poo.tallerbicicletas.controllers;

import co.edu.uniquindio.poo.tallerbicicletas.model.TallerBicicletas;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Cliente;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Bicicleta;
import co.edu.uniquindio.poo.tallerbicicletas.modell.TipoBicicleta;
import co.edu.uniquindio.poo.tallerbicicletas.model.Mecanico;
import co.edu.uniquindio.poo.tallerbicicletas.model.EspecialidadMecanico;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Repuesto;
import co.edu.uniquindio.poo.tallerbicicletas.model.OrdenServicio;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MainController {

    private TallerBicicletas taller = new TallerBicicletas(" TallerFox", "254212812", "carrera 24 # 25-24");

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private ObservableList<Bicicleta> listaBicicletas = FXCollections.observableArrayList();
    private ObservableList<Mecanico> listaMecanicos = FXCollections.observableArrayList();
    private ObservableList<Repuesto> listaRepuestos = FXCollections.observableArrayList();
    private ObservableList<OrdenServicio> listaOrdenes = FXCollections.observableArrayList();


    @FXML private TextField txtDocCliente, txtNomCliente, txtTelCliente, txtDirCliente;
    @FXML private TableView<Cliente> tblClientes;
    @FXML private TableColumn<Cliente, String> colDocCliente, colNomCliente, colTelCliente, colDirCliente;


    @FXML private ComboBox<Cliente> cmbClienteBicicleta;
    @FXML private ComboBox<TipoBicicleta> cmbTipoBicicleta;
    @FXML private TextField txtMarcaBici, txtColorBici, txtSerialBici, txtAnioBici;
    @FXML private TableView<Bicicleta> tblBicicletas;
    @FXML private TableColumn<Bicicleta, String> colSerialBici, colMarcaBici, colTipoBici, colDuenoBici;


    @FXML private ComboBox<EspecialidadMecanico> cmbEspecialidadMecanico;
    @FXML private TextField txtNomMecanico, txtCodMecanico;
    @FXML private TableView<Mecanico> tblMecanicos;
    @FXML private TableColumn<Mecanico, String> colCodMecanico, colNomMecanico, colEspMecanico;


    @FXML private TextField txtCodRepuesto, txtNomRepuesto, txtPrecioRepuesto, txtStockRepuesto;
    @FXML private TableView<Repuesto> tblRepuestos;
    @FXML private TableColumn<Repuesto, String> colCodRepuesto, colNomRepuesto;
    @FXML private TableColumn<Repuesto, Integer> colStockRepuesto;


    @FXML private DatePicker dpFechaOrden;
    @FXML private ComboBox<Bicicleta> cmbBiciOrden;
    @FXML private ComboBox<Mecanico> cmbMecanicoOrden;
    @FXML private TextArea txtMotivoOrden;
    @FXML private TableView<OrdenServicio> tblOrdenes;
    @FXML private TableColumn<OrdenServicio, String> colFechaOrden, colBiciOrden, colMecOrden;


    @FXML private TextField txtBusquedaSerial;
    @FXML private ListView<String> lstHistorial;
    @FXML private DatePicker dpBusquedaFecha;
    @FXML private ListView<String> lstOrdenesDia;

    @FXML
    public void initialize() {
        listaClientes.setAll(taller.getClientes());
        listaBicicletas.setAll(taller.getBicicletas());
        listaMecanicos.setAll(taller.getMecanicos());
        listaRepuestos.setAll(taller.getRepuestos());
        listaOrdenes.setAll(taller.getOrdenes());

        // CORRECCIÓN: "documento" y "nombreCompleto" tal como están en tu clase Cliente
        colDocCliente.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colNomCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colTelCliente.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDirCliente.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tblClientes.setItems(listaClientes);

        cmbTipoBicicleta.getItems().addAll(TipoBicicleta.values());
        cmbClienteBicicleta.setItems(listaClientes);
        colSerialBici.setCellValueFactory(new PropertyValueFactory<>("numeroMarco"));
        colMarcaBici.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colTipoBici.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTipoBicicleta().toString()));
        // CORRECCIÓN: Usando getNombreCompleto()
        colDuenoBici.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCliente().getNombreCompleto()));
        tblBicicletas.setItems(listaBicicletas);

        cmbEspecialidadMecanico.getItems().addAll(EspecialidadMecanico.values());
        colCodMecanico.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNomMecanico.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEspMecanico.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getEspecialidad().toString()));
        tblMecanicos.setItems(listaMecanicos);

        colCodRepuesto.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNomRepuesto.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colStockRepuesto.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tblRepuestos.setItems(listaRepuestos);

        cmbBiciOrden.setItems(listaBicicletas);
        cmbMecanicoOrden.setItems(listaMecanicos);
        colFechaOrden.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        colBiciOrden.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBicicleta().getNumeroMarco()));
        colMecOrden.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMecanico().getNombre()));
        tblOrdenes.setItems(listaOrdenes);
    }

    @FXML
    public void registrarCliente(ActionEvent event) {
        if(txtDocCliente.getText().isEmpty() || txtNomCliente.getText().isEmpty()) {
            mostrarAlerta("Error", "Faltan datos obligatorios."); return;
        }
        Cliente c = new Cliente(txtDocCliente.getText(), txtNomCliente.getText(), txtTelCliente.getText(), txtDirCliente.getText());
        taller.registrarCliente(c); // CORRECCIÓN: Vuelve a usar registrarCliente
        listaClientes.setAll(taller.getClientes());
        txtDocCliente.clear(); txtNomCliente.clear(); txtTelCliente.clear(); txtDirCliente.clear();
    }

    @FXML
    public void registrarBicicleta(ActionEvent event) {
        if(cmbClienteBicicleta.getValue() == null || cmbTipoBicicleta.getValue() == null || txtSerialBici.getText().isEmpty()){
            mostrarAlerta("Error", "Faltan datos obligatorios."); return;
        }
        Bicicleta b = new Bicicleta(txtMarcaBici.getText(), txtColorBici.getText(), txtSerialBici.getText(), txtAnioBici.getText(), cmbTipoBicicleta.getValue(), cmbClienteBicicleta.getValue());
        taller.registrarBicicleta(b); // CORRECCIÓN
        listaBicicletas.setAll(taller.getBicicletas());
        txtMarcaBici.clear(); txtColorBici.clear(); txtSerialBici.clear(); txtAnioBici.clear(); cmbClienteBicicleta.setValue(null); cmbTipoBicicleta.setValue(null);
    }

    @FXML
    public void registrarMecanico(ActionEvent event) {
        if(txtNomMecanico.getText().isEmpty() || txtCodMecanico.getText().isEmpty() || cmbEspecialidadMecanico.getValue() == null){
            mostrarAlerta("Error", "Faltan datos."); return;
        }
        Mecanico m = new Mecanico(txtNomMecanico.getText(), cmbEspecialidadMecanico.getValue(), txtCodMecanico.getText());
        taller.registrarMecanico(m); // CORRECCIÓN
        listaMecanicos.setAll(taller.getMecanicos());
        txtNomMecanico.clear(); txtCodMecanico.clear(); cmbEspecialidadMecanico.setValue(null);
    }

    @FXML
    public void registrarRepuesto(ActionEvent event) {
        try {
            Repuesto r = new Repuesto(txtCodRepuesto.getText(), txtNomRepuesto.getText(), Double.parseDouble(txtPrecioRepuesto.getText()), Integer.parseInt(txtStockRepuesto.getText()));
            taller.registrarRepuesto(r); // CORRECCIÓN
            listaRepuestos.setAll(taller.getRepuestos());
            txtCodRepuesto.clear(); txtNomRepuesto.clear(); txtPrecioRepuesto.clear(); txtStockRepuesto.clear();
        } catch (Exception e) { mostrarAlerta("Error", "Precio y stock deben ser números válidos."); }
    }

    @FXML
    public void revisarStockBajo(ActionEvent event) {
        List<Repuesto> bajos = taller.listarRepuestosStockBajo();
        if (bajos.isEmpty()) {
            Alert info = new Alert(Alert.AlertType.INFORMATION); info.setContentText("Inventario OK."); info.showAndWait();
        } else {
            StringBuilder msj = new StringBuilder();
            for (Repuesto r : bajos) msj.append("- ").append(r.getNombre()).append(" (").append(r.getStock()).append(")\n");
            mostrarAlerta("⚠️ Stock Bajo", msj.toString());
        }
    }

    @FXML
    public void crearOrden(ActionEvent event) {
        if(dpFechaOrden.getValue() == null || cmbBiciOrden.getValue() == null || cmbMecanicoOrden.getValue() == null){
            mostrarAlerta("Error", "Llene todos los datos."); return;
        }

        // se envia solo 5 argume
        taller.crearOrdenServicio(dpFechaOrden.getValue(), LocalTime.now(), txtMotivoOrden.getText(), cmbBiciOrden.getValue(), cmbMecanicoOrden.getValue());
        listaOrdenes.setAll(taller.getOrdenes());
        dpFechaOrden.setValue(null); txtMotivoOrden.clear(); cmbBiciOrden.setValue(null); cmbMecanicoOrden.setValue(null);
    }

    @FXML
    public void buscarHistorialSerial(ActionEvent event) {
        lstHistorial.getItems().clear();
        List<OrdenServicio> hist = taller.consultarHistorialPorSerial(txtBusquedaSerial.getText());
        if(hist.isEmpty()) lstHistorial.getItems().add("Sin historial.");
        else for(OrdenServicio o : hist) lstHistorial.getItems().add(o.getFechaIngreso() + " | " + o.getMecanico().getNombre());
    }

    @FXML
    public void buscarOrdenesDia(ActionEvent event) {
        lstOrdenesDia.getItems().clear();
        if(dpBusquedaFecha.getValue() == null) return;
        List<OrdenServicio> ord = taller.consultarOrdenesPorFecha(dpBusquedaFecha.getValue());
        if(ord.isEmpty()) lstOrdenesDia.getItems().add("Sin órdenes.");
        else for(OrdenServicio o : ord) lstOrdenesDia.getItems().add(o.getBicicleta().getMarca() + " | " + o.getMotivoIngreso());
    }

    private void mostrarAlerta(String titulo, String msj) {
        Alert a = new Alert(Alert.AlertType.ERROR); a.setTitle(titulo); a.setHeaderText(null); a.setContentText(msj); a.showAndWait();
    }
}