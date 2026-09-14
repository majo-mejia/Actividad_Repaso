module co.edu.uniquindio.poo.tallerbicicletas {
    requires javafx.controls;
    requires javafx.fxml;

    // Exportar paquetes para acceso directo
    exports co.edu.uniquindio.poo.tallerbicicletas;
    exports co.edu.uniquindio.poo.tallerbicicletas.controllers;
    exports co.edu.uniquindio.poo.tallerbicicletas.model;
    exports co.edu.uniquindio.poo.tallerbicicletas.modell;

    // Abrir paquetes para reflexión (Tablas y FXML)
    opens co.edu.uniquindio.poo.tallerbicicletas to javafx.fxml;
    opens co.edu.uniquindio.poo.tallerbicicletas.controllers to javafx.fxml;
    opens co.edu.uniquindio.poo.tallerbicicletas.model to javafx.base, javafx.fxml;
    opens co.edu.uniquindio.poo.tallerbicicletas.modell to javafx.base, javafx.fxml;
}