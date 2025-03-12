module co.edu.poli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens co.edu.poli.ejemplo1.controlador to javafx.fxml;
    opens co.edu.poli.ejemplo1.vista to javafx.fxml;
    
    exports co.edu.poli.ejemplo1.vista;
    exports co.edu.poli.ejemplo1.controlador;
}
