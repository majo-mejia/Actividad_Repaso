package co.edu.uniquindio.poo.tallerbicicletas.model;

import co.edu.uniquindio.poo.tallerbicicletas.modell.Bicicleta;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Cliente;
import co.edu.uniquindio.poo.tallerbicicletas.modell.Repuesto;
import co.edu.uniquindio.poo.tallerbicicletas.modell.TipoBicicleta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TallerBicicletasTest {

    private TallerBicicletas taller;

    @BeforeEach
    public void setUp() {
        taller = new TallerBicicletas("Taller Central", "900123456", "Calle 10 # 20-30");
    }

    @Test
    public void testCargarDatosDePruebaIniciales() {
        assertEquals(2, taller.getClientes().size());
        assertEquals(2, taller.getBicicletas().size());
        assertEquals(2, taller.getMecanicos().size());
        assertEquals(2, taller.getRepuestos().size());
        assertEquals(1, taller.getOrdenes().size());
    }

    @Test
    public void testRegistrarCliente() {
        Cliente nuevoCliente = new Cliente("1003", "Carlos Gomez", "3119998877", "Carrera 5 # 10-15");
        taller.registrarCliente(nuevoCliente);

        assertEquals(3, taller.getClientes().size());
        assertTrue(taller.getClientes().contains(nuevoCliente));
    }

    @Test
    public void testRegistrarBicicleta() {
        Cliente cliente = taller.getClientes().get(0);
        Bicicleta nuevaBici = new Bicicleta("Specialized", "Negro", "MARCO789", "2023", TipoBicicleta.RUTA, cliente);
        taller.registrarBicicleta(nuevaBici);

        assertEquals(3, taller.getBicicletas().size());
        assertTrue(taller.getBicicletas().contains(nuevaBici));
    }

    @Test
    public void testRegistrarMecanico() {
        Mecanico nuevoMecanico = new Mecanico("Mario Rossi", EspecialidadMecanico.BICICLETAS_ELECTRICAS, "MEC003");
        taller.registrarMecanico(nuevoMecanico);

        assertEquals(3, taller.getMecanicos().size());
        assertTrue(taller.getMecanicos().contains(nuevoMecanico));
    }

    @Test
    public void testRegistrarRepuesto() {
        Repuesto nuevoRepuesto = new Repuesto("R003", "Líquido de frenos", 15000, 10);
        taller.registrarRepuesto(nuevoRepuesto);

        assertEquals(3, taller.getRepuestos().size());
        assertTrue(taller.getRepuestos().contains(nuevoRepuesto));
    }

    @Test
    public void testCrearOrdenServicio() {
        Bicicleta bicicleta = taller.getBicicletas().get(1);
        Mecanico mecanico = taller.getMecanicos().get(1);

        OrdenServicio orden = taller.crearOrdenServicio(
                LocalDate.now(),
                LocalTime.now(),
                "Mantenimiento general",
                bicicleta,
                mecanico
        );

        assertNotNull(orden);
        assertEquals(2, taller.getOrdenes().size());
        assertTrue(taller.getOrdenes().contains(orden));
    }

    @Test
    public void testConsultarHistorialPorSerial() {
        // En los datos de prueba la bici1 tiene el serial MARCO123
        List<OrdenServicio> historialExistent = taller.consultarHistorialPorSerial("MARCO123");
        assertEquals(1, historialExistent.size());

        // Búsqueda insensible a mayúsculas/minúsculas
        List<OrdenServicio> historialMinusculas = taller.consultarHistorialPorSerial("marco123");
        assertEquals(1, historialMinusculas.size());

        // Consulta sobre una bicicleta sin órdenes registradas
        List<OrdenServicio> historialInexistente = taller.consultarHistorialPorSerial("MARCO456");
        assertEquals(0, historialInexistente.size());
    }

    @Test
    public void testConsultarOrdenesPorFecha() {
        // La orden inicial fue creada con LocalDate.now()
        List<OrdenServicio> ordenesHoy = taller.consultarOrdenesPorFecha(LocalDate.now());
        assertEquals(1, ordenesHoy.size());

        // Consulta para una fecha sin órdenes
        List<OrdenServicio> ordenesAyer = taller.consultarOrdenesPorFecha(LocalDate.now().minusDays(1));
        assertEquals(0, ordenesAyer.size());
    }

    @Test
    public void testListarRepuestosStockBajo() {
        // R001 tiene stock 12, R002 tiene stock 3 (< 5)
        List<Repuesto> repuestosBajos = taller.listarRepuestosStockBajo();

        assertEquals(1, repuestosBajos.size());
        assertEquals("R002", repuestosBajos.get(0).getCodigo());
    }
}