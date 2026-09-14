module co.edu.uniquindio.poo.tallerbicicletas {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.tallerbicicletas to javafx.fxml;
    opens co.edu.uniquindio.poo.tallerbicicletas.controllers to javafx.fxml;
    opens co.edu.uniquindio.poo.tallerbicicletas.model to javafx.base;
    exports co.edu.uniquindio.poo.tallerbicicletas;
}