module co.edu.uniquindio.poo.tallerbicicletas {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.tallerbicicletas to javafx.fxml;
    exports co.edu.uniquindio.poo.tallerbicicletas;
}