module co.poli.edu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens co.poli.edu to javafx.fxml;
    exports co.poli.edu;
}
